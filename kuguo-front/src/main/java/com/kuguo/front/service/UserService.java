package com.kuguo.front.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kuguo.front.entity.Friend;
import com.kuguo.front.entity.Product;
import com.kuguo.front.entity.User;
import com.kuguo.front.repository.UserDao;
import com.kuguo.front.utils.Digests;
import com.kuguo.front.utils.Encodes;

@Component
@Transactional(readOnly = true)
public class UserService {
	
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	public static final String HASH_ALGORITHM = "SHA-1";
	
	@Autowired
	private UserDao userDao;

	/**
	 * 获取热门用户
	 * @param number 获取数量
	 * @return
	 */
	public List<User> getHotUsers(int number) {
		return userDao.getHotUsers(number);
	}

	/**
	 * 保存用户信息
	 * @param user
	 */
	@Transactional(readOnly = false)
	public void saveUser(User user) {
		entryptPassword(user);
		user.setHead("http://img5.duitang.com/uploads/item/201309/05/20130905192250_tG5SU.jpeg");
		user.setBio("这家伙很懒,什么都没有留下!");
		userDao.save(user);
	}
	
	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));
		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}

	/**
	 * 更新用户信息
	 * @param user
	 */
	@Transactional(readOnly = false)
	public Boolean updateUser(User user) {
		if(user.getPlainPassword() != null) {
			entryptPassword(user);
			userDao.update(user);
		} else {
			userDao.update(user);
		}
		return true;
	}
	
	/**
	 * @return
	 */
	public User getActiveUser() {
		Subject subject = SecurityUtils.getSubject();
		String userName = subject.getPrincipal().toString();
		return userDao.getUserByName(userName);
	}

	/**
	 * 根据id获取用户
	 * @param id
	 * @return
	 */
	public User getUser(Long id) {
		return userDao.get(id);
	}

	/**
	 * 验证登录
	 * @param email
	 * @param password
	 * @return
	 */
	public User validate(String email, String password) {
		// 1. 根据email获取用户(主要包含password和salt用来验证登录)
		User user = userDao.getUserByEmail(email);
		if (user != null) {
			byte[] salt = Encodes.decodeHex(user.getSalt());
			String hashPassword = Encodes.encodeHex(Digests.sha1(password.getBytes(), salt, HASH_INTERATIONS));
			if (hashPassword.equals(user.getPassword())) {
				return user;
			}
		}
		return null;
	}

	/**
	 * 通过邮箱获取用户
	 * @param email
	 * @return
	 */
	public User findUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
	
	/**
	 * 通过name获取用户
	 * @param name
	 * @return
	 */
	public User findUserByName(String name) {
		return userDao.getUserByName(name);
	}

	/**
	 * 获取所有用户
	 * @return
	 */
	public List<User> getAllUser() {
		return userDao.getUser();
	}

	/**
	 * 获取喜爱的商品
	 * @param id
	 * @return
	 */
	public List<Product> getLikedProducts(Long id) {
		return userDao.getLikedProducts(id);
	}

	/**
	 * 获取关注信息
	 * @param id
	 * @return
	 */
	public List<User> getFriends(Long id) {
		return userDao.getFriends(id);
	}

	/**
	 * 获取粉丝
	 * @param id
	 * @return
	 */
	public List<User> getFans(Long id) {
		return userDao.getFans(id);
	}
	
	/**
	 * 关注用户
	 * @param friend
	 */
	@Transactional(readOnly = false)
	public Boolean saveFriend(Friend friend) {
		Integer num = userDao.setFriend(friend);
		if(num > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 取消关注用户
	 * @param friend
	 */
	@Transactional(readOnly = false)
	public Boolean unfollow(Friend friend) {
		Integer num = userDao.unfollow(friend);
		if(num > 0) {
			return true;
		}
		return false;
	}
}
