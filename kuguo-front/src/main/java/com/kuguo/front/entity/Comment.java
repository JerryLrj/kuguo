package com.kuguo.front.entity;

import java.util.Date;

/**
 * 商品评论信息
 * @author jerry
 *
 */
public class Comment extends IdEntity {
	private String content;
	private int poke;
	private int hoot;
	private Date create_time;
	private User user;
	private Long productId;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPoke() {
		return poke;
	}

	public void setPoke(int poke) {
		this.poke = poke;
	}

	public int getHoot() {
		return hoot;
	}

	public void setHoot(int hoot) {
		this.hoot = hoot;
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
}