package com.kuguo.front.entity;

import java.util.Date;

/**
 * 我的好友信息
 * @author jerry
 *
 */
public class Friend extends IdEntity {
	private User uid;
	private User fid;
	private Date create_time;
	
	public User getUid() {
		return uid;
	}
	public void setUid(User uid) {
		this.uid = uid;
	}
	public User getFid() {
		return fid;
	}
	public void setFid(User fid) {
		this.fid = fid;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	
}
