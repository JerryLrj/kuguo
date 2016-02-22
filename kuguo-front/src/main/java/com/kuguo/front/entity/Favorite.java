package com.kuguo.front.entity;

import java.util.Date;

/**
 * 喜爱的商品信息
 * @author jerry
 *
 */
public class Favorite extends IdEntity {
	private User user;
	private Product product;
	private Date create_time;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
}
