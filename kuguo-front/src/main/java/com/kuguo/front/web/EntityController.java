package com.kuguo.front.web;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kuguo.front.entity.Comment;
import com.kuguo.front.entity.Label;
import com.kuguo.front.entity.Product;
import com.kuguo.front.entity.ProductLabel;
import com.kuguo.front.entity.User;
import com.kuguo.front.service.CommentService;
import com.kuguo.front.service.LabelService;
import com.kuguo.front.service.ProductService;
import com.kuguo.front.service.UserService;
import com.kuguo.front.service.ShiroDbRealm.ShiroUser;
import com.kuguo.front.utils.Exceptions;

@Controller
@RequestMapping(value = "/entity")
public class EntityController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private LabelService labelService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/taobao/info", method = RequestMethod.POST)
	public String getFromTaobao(String url, Model model) {
		model.addAttribute("item", productService.getTaobaoItemByUrl(url));
		return "product/taobaoItemInfo";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("action", "create");
		return "product/new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String create(@Valid Product newProduct, RedirectAttributes redirectAttributes) {
		ShiroUser currentUser = (ShiroUser)SecurityUtils.getSubject().getPrincipal();
		User user = new User();
		user.setId(currentUser.getId());
		newProduct.setUser(user);
		newProduct.getComment().setUser(user);
		productService.saveProduct(newProduct);
		//添加商品时添加标签
		String content = newProduct.getComment().getContent();
		if(content.contains("#")) {
			content = content.substring(content.indexOf("#") + 1,content.length());
			if(content.contains(" ")) {
				content = content.substring(0, content.indexOf(" "));
			}
			addTags(content, currentUser.getId(), newProduct.getId());
		}
		return "redirect:/selected/";
	}
	
	/**
	 * 添加评论
	 * @param newComment
	 * @return
	 */
	@RequestMapping(value = "/note/create/", method = RequestMethod.POST)
	public String createComment(@Valid Comment newComment) {
		ShiroUser currentUser = (ShiroUser)SecurityUtils.getSubject().getPrincipal();
		if(currentUser != null) {
			User user = new User();
			user.setId(currentUser.getId());
			newComment.setUser(user);
			commentService.saveComment(newComment);
		}
		return "redirect:/detail/" + newComment.getProductId()+"/";
	}
	
	@RequestMapping(value = "/note/update/{id}/", method = RequestMethod.POST)
	public String update(Product product) {
		productService.saveProduct(product);
		return "redirect:/selected/";
	}
	
	//跳转至标签页面
	@RequestMapping(value="/tag/{tag}", method=RequestMethod.GET)
	public String toTags(@PathVariable("tag") String tag, Model model) {
		String newTag = null;
		try {
			newTag = URLDecoder.decode(tag, "utf-8");
		} catch (Exception e) {
			Exceptions.getStackTraceAsString(e);
		}
		List<Label> hotLabel = labelService.getHotLabel(10);
		List<String> names = new ArrayList<String>();
		for(Label lb : hotLabel) {
			names.add(lb.getName());
		}
		if(!names.contains(newTag)) {
			Label lb = new Label();
			lb.setName(newTag);
			hotLabel.add(lb);
		}
		model.addAttribute("labels", hotLabel);
		if("all".equals(newTag)) {
			//查询所有标签
		} else {
			List<Product> product = productService.getProductByTag(newTag);
			model.addAttribute("products", product);
		}
		return "product/tags";
	}
	
	//添加标签
	@ResponseBody
	@RequestMapping(value="/addtag/", method = RequestMethod.POST)
	public Boolean addTags(@Param("tag") String tag, @Param("uid") Long uid, @Param("pid") Long pid) {
		Boolean result = false;
		if(tag != null) {
			Label label = labelService.getLabeByName(tag);
			ProductLabel pl = new ProductLabel();
			pl.setProduct(productService.getProduct(pid));
			if(label != null) {
				pl.setLabel(label);
				result = labelService.saveProductLabel(pl);
			} else {
				Label lb = new Label();
				lb.setName(tag);
				lb.setCreate_user(userService.getUser(uid));
				lb.setProduct(productService.getProduct(pid));
				result = labelService.saveLabel(lb);
				pl.setLabel(lb);
				labelService.saveProductLabel(pl);
			}
		}
		return result;
	}
	
	@RequestMapping(value = "/tagsuggest/", method=RequestMethod.GET)
	public String seaTags(@Param("prefix") String prefix) {
		//TODO 查询已有标签并且进行提示
		
		return null;
	}
}
