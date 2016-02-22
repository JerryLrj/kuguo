package com.kuguo.front.entity;

/**
 * 分类
 * @author jerry
 *
 */
public class Channel extends IdEntity {
	private String name;
	private Channel channel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

}
