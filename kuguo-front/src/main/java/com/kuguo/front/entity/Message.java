package com.kuguo.front.entity;

import java.util.Date;

/**
 * 消息
 * @author jerry
 *
 */
public class Message extends IdEntity {
	private int type;
	private Date create_time;
	private User user;
	private Product product;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

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

}
