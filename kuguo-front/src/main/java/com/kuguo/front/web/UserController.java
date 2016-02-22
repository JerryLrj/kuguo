package com.kuguo.front.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kuguo.front.entity.Friend;
import com.kuguo.front.entity.Label;
import com.kuguo.front.entity.User;
import com.kuguo.front.service.LabelService;
import com.kuguo.front.service.ProductService;
import com.kuguo.front.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private LabelService labelService;
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String createForm(Model model) {
		return "register";
	}

	//注册用户
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String create(@Valid User newUser,HttpServletResponse response,
			RedirectAttributes redirectAttributes) {
		//1. 保存用户入库、密码用salt处理
		userService.saveUser(newUser);
		//2.自动登录
		UsernamePasswordToken token = new UsernamePasswordToken();
		token.setUsername(newUser.getEmail());
		token.setPassword(newUser.getPlainPassword().toCharArray());
		SecurityUtils.getSubject().login(token);
		return "redirect:/selected";
	}
	
	//显示喜爱的商品 
	@RequestMapping(value = "/u/{id}/likes")
	public String likes(@PathVariable("id") Long id,Model model) {
		model.addAttribute("user", userService.getUser(id));
		model.addAttribute("products", userService.getLikedProducts(id));
		userNum(id, model);
		return "user/likes";
	}
	
	//显示被谁关注
	@RequestMapping(value = "/u/{id}/fans")
	public String fans(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getUser(id));
		model.addAttribute("fans", userService.getFans(id));
		userNum(id, model);
		return "user/fans";
	}
	
	//显示关注的人
	@RequestMapping(value = "/u/{id}/followings")
	public String followings(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getUser(id));
		model.addAttribute("friends", userService.getFriends(id));
		userNum(id, model);
		return "user/followings";
	}
	
	@RequestMapping(value = "/u/{id}/notes")
	public String notes(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getUser(id));
		//点评过的商品
		model.addAttribute("products", productService.getCommentProducts(id));
		userNum(id, model);
		return "user/notes";
	}
	
	//显示添加的商品
	@RequestMapping(value = "/u/{id}/posts")
	public String posts(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getUser(id));
		model.addAttribute("products", productService.getUserProducts(id));
		userNum(id, model);
		return "user/posts";
	}
	
	//我的分享 对应标题数量
	public void userNum(Long id, Model model) {
		model.addAttribute("pronum", productService.getUserProducts(id).size());
		model.addAttribute("comnum", productService.getCommentProducts(id).size());
		model.addAttribute("likenum", userService.getLikedProducts(id).size());
		model.addAttribute("tagnum", labelService.getLabelCountByUser(id));
		model.addAttribute("fannum", userService.getFans(id).size());
		model.addAttribute("frinum", userService.getFriends(id).size());
	}
	
	//显示添加的标签
	@RequestMapping(value = "/u/{id}/tags")
	public String tags(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getUser(id));
		userNum(id, model);
		return "user/tags";
	}
	
	//用户消息
	@RequestMapping(value = "user/message")
	public String message(Model model) {
		List<Label> labels = labelService.getHotLabel(5);
		List<User> users = userService.getHotUsers(5);
		model.addAttribute("labels", labels);
		model.addAttribute("users", users);
		//TODO 显示用户消息
		return "user/message";
	}

	@ResponseBody
	@RequestMapping(value = "/check_email_availability/", method = RequestMethod.POST)
	public String checkEmailValide(@RequestParam String email) {
		String result = "true";
		//校验邮箱是否已注册
		User user = userService.findUserByEmail(email);
		if(user != null) {
			result = "false";
		}
		return result;	
	}
	
	@ResponseBody
	@RequestMapping(value = "/check_nickname_availability/", method = RequestMethod.POST)
	public String checkNicknameValide(@RequestParam String name) {
		String result = "true";
		//校验用户名是否已注册
		User user = userService.findUserByName(name);
		if(user != null) {
			result = "false";
		}
		return result;	
	}
	
	@ResponseBody
	@RequestMapping(value = "user/setting/check_password_availability/", method = RequestMethod.POST)
	public String checkPasswordValide(@RequestParam String password) {
		String result = "false";
		//修改密码验证
		User nowuser = userService.getActiveUser();
		User validate = userService.validate(nowuser.getEmail(), password);
		if(validate != null) {
			result = "true";
		}
		return result;
	}

	//跳转到用户信息页面
	@RequestMapping(value = "user/setting", method = RequestMethod.GET)
	public String updateFrom(Model model) {
		//这里要带用户信息
		model.addAttribute("user",userService.getActiveUser());
		return "user/setting";
	}

	//修改用户信息
	@RequestMapping(value = "user/setting", method = RequestMethod.POST)
	public String update(@Valid User user, RedirectAttributes redirectAttributes) {
		//保存修改的用户信息
		userService.updateUser(user);
		return "redirect:/selected";
	}
	
	@RequestMapping(value = "user/update/password", method = RequestMethod.POST)
	public String updatePassword(@RequestParam(value="id") Long id, @RequestParam(value = "new_password") String newpassword) {
		User user = userService.getUser(id);
		user.setPlainPassword(newpassword);
		userService.updateUser(user);
		return "redirect:/selected";
	}
	
	//关注/取消用户
	@ResponseBody
	@RequestMapping(value = "user/follow/{fid}/{uid}/{type}", method=RequestMethod.POST)
	public Boolean followFriend(@PathVariable("fid") Long fid, @PathVariable("uid") Long uid, @PathVariable("type") Long type) {
		if(fid == uid) {
			return false;
		}
		Friend friend = new Friend();
		//当前用户id
		friend.setUid(userService.getUser(uid));
		//被关注人id
		friend.setFid(userService.getUser(fid));
		friend.setCreate_time(new Date());
		if (type == 0) {
			return userService.saveFriend(friend);
		} else {
			return userService.unfollow(friend);
		}
		
	}
	
	@RequestMapping(value = "/origin/upload/", method = RequestMethod.POST)
	public Boolean uploadFile() {
		
		return null;
	}
	
//	//取消关注
//	@ResponseBody
//	@RequestMapping(value = "user/unfollow/{fid}/{uid}", method=RequestMethod.POST)
//	public Boolean unFollowFriend(@PathVariable("fid") Long fid, @PathVariable("uid") Long uid) {
//		Friend friend = new Friend();
//		//当前用户id
//		friend.setUid(userService.getUser(uid));
//		//被关注人id
//		friend.setFid(userService.getUser(fid));
//		return userService.unfollow(friend);
//	}
	
}
