package com.kuguo.front.repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Item;
import com.taobao.api.request.ItemGetRequest;
import com.taobao.api.response.ItemGetResponse;

@Component
public class TaobaoDao {
	private static final Logger LOGGER = Logger.getLogger(TaobaoDao.class);
	private TaobaoClient client;

	public Item getTaoBaoItemByUrl(String url) {
		Matcher matcher = Pattern.compile("id=(\\d+)&?").matcher(url);
		if (matcher.find()) {
			Long itemId = Long.parseLong(matcher.group(1));
			ItemGetRequest request = new ItemGetRequest();
			request.setFields("title,pic_url,price,detail_url,item_img");
			request.setNumIid(itemId);
			try {
				ItemGetResponse response = client.execute(request);
				if (response.isSuccess()) {
					return response.getItem();
				}
			} catch (ApiException e) {
				LOGGER.error(e);
			}
		}
		return new Item();
	}

	@Autowired
	public void setClient(TaobaoClient client) {
		this.client = client;
	}
}
