package com.kuguo.front.repository;

import com.kuguo.front.entity.Favorite;

@MyBatisRepository
public interface FavoriteDao {
	//添加喜爱商品
	Integer saveFavorite(Favorite favorite);
}
