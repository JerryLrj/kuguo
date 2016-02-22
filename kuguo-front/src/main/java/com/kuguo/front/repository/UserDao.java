package com.kuguo.front.repository;

import java.util.List;

import com.kuguo.front.entity.Friend;
import com.kuguo.front.entity.Product;
import com.kuguo.front.entity.User;

@MyBatisRepository
public interface UserDao {
	List<User> getHotUsers(int number);

	void save(User user);

	void update(User user);

	User get(Long id);

	User getUserByEmail(String email);
	
	User getUserByName(String name);

	List<User> getUser();

	List<Product> getLikedProducts(Long id);

	List<User> getFriends(Long id);

	List<User> getFans(Long id);

	Integer setFriend(Friend friend);
	
	Integer unfollow(Friend friend);
	
}
