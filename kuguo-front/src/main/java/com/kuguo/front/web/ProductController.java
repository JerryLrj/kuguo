package com.kuguo.front.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuguo.front.entity.Channel;
import com.kuguo.front.entity.Favorite;
import com.kuguo.front.entity.Label;
import com.kuguo.front.entity.Product;
import com.kuguo.front.entity.User;
import com.kuguo.front.service.ChannelService;
import com.kuguo.front.service.CommentService;
import com.kuguo.front.service.LabelService;
import com.kuguo.front.service.ProductService;
import com.kuguo.front.service.ServiceException;
import com.kuguo.front.service.UserService;
import com.kuguo.front.utils.Exceptions;

@Controller
@RequestMapping(value = "")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ChannelService channelService;

	@Autowired
	private LabelService labelService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/")
	public String toSelected() {
		return "redirect:/selected";
	}
	
	@RequestMapping(value = "/selected")
	public String list(@RequestParam(value = "page", defaultValue = "0") int pageNumber, Model model) {
		List<Product> products = productService.getProductsByPage(pageNumber);
		List<Channel> channels = channelService.getAllChannel();
		List<Label> labels = labelService.getHotLabel(5);
		List<User> users = userService.getHotUsers(5);
		Integer pagenum = productService.getProductsCount();
		model.addAttribute("products", products);
		model.addAttribute("channels", channels);
		model.addAttribute("labels", labels);
		model.addAttribute("users", users);
		model.addAttribute("page", pageNumber);
		model.addAttribute("pagenum", pagenum);
		Subject subject = SecurityUtils.getSubject();
		if(subject.getPrincipals() != null) {
			User user = userService.getActiveUser();
			model.addAttribute("uid", user.getId());
			List<User> friends = userService.getFriends(user.getId());
			model.addAttribute("friends", friends);
		}
		return "selected";
	}
	
	@RequestMapping(value = "/popular")
	public String poplist(Model model, HttpServletResponse response) {
		List<Product> products = productService.getPopProducts();
		model.addAttribute("products", products);
		return "popular";
	}

	@RequestMapping(value = "/discover")
	public String discover(Model model) {
		List<Product> products = productService.getPopProducts();
		List<Channel> channels = channelService.getAllChannel();
		model.addAttribute("channels", channels);
		model.addAttribute("products", products);
		return "discover";
	}
	
	@RequestMapping(value = "/activity")
	public String activity(Model model) {		
		List<Channel> channels = channelService.getAllChannel();
		List<Label> labels = labelService.getHotLabel(5);
		List<User> users = userService.getHotUsers(5);
		List<Product> activity = productService.getFriendsActivity(userService.getActiveUser().getId());
		model.addAttribute("channels", channels);
		model.addAttribute("labels", labels);
		model.addAttribute("users", users);
		model.addAttribute("products", activity);
		model.addAttribute("uid", userService.getActiveUser().getId());
		return "activity";
	}
	
	@RequestMapping(value = "/detail/{id}/", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		//1. 商品信息(带第一条评论)
		model.addAttribute("product", productService.getProduct(id));
		//2. 评论列表
		model.addAttribute("comments", commentService.getComments(id));
		model.addAttribute("likedUsers", productService.getLikedUsers(id));
		return "product/detail";
	}
	
	//喜爱商品
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping(value = "/product/like/{pid}/{uid}", method=RequestMethod.POST)
	public Boolean saveFavorite(@PathVariable("pid") Long pid, @PathVariable("uid") Long uid) {
		Boolean result = false;
		Product product = productService.getProduct(pid);
		Favorite favorite = new Favorite();
		favorite.setProduct(product);
		favorite.setUser(userService.getUser(uid));
		try {
			result = productService.saveFavorite(favorite, product);
			result = true;
		} catch (ServiceException e) {
			Exceptions.getStackTraceAsString(e);
		} finally {
			return result;
		}
	}
}
