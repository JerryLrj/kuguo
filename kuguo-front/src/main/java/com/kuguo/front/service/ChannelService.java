package com.kuguo.front.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kuguo.front.entity.Channel;
import com.kuguo.front.repository.ChannelDao;

@Component
@Transactional(readOnly = true)
public class ChannelService {
	@Autowired
	private ChannelDao channelDao;
	
	public List<Channel> getAllChannel() {
		return channelDao.getAll();
	}
}