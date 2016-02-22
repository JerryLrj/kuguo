package com.kuguo.front.repository;

import java.util.List;

import com.kuguo.front.entity.Channel;

@MyBatisRepository
public interface ChannelDao {
	Channel get(Long id);
	
	List<Channel> getAll();
}
