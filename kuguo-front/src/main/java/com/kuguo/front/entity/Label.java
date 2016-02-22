package com.kuguo.front.entity;

import java.util.Date;

/**
 * 标签
 * @author jerry
 *
 */
public class Label extends IdEntity {
	private String name;
	private User create_user;
	private Date create_time;
	private Product product;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getCreate_user() {
		return create_user;
	}

	public void setCreate_user(User create_user) {
		this.create_user = create_user;
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
