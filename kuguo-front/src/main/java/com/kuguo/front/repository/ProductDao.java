package com.kuguo.front.repository;

import java.util.List;

import com.kuguo.front.entity.Product;
import com.kuguo.front.entity.User;

@MyBatisRepository
public interface ProductDao {
	List<Product> getAll(int page);
	
	Product get(Long id);

	Integer save(Product product);

	List<Product> getPop();

	List<Product> getUP(Long id);

	List<User> getLikedUsers(Long id);

	List<Product> getCommentProducts(Long id);
	
	Integer getCountProduct();
	
	//获取好友的动态
	List<Product> getFriendsActivity(Long id);
	
	Integer updateProduct(Product product);
	
	List<Product> getProductByTag(String name);
}
