package com.kuguo.front.repository;

import java.util.List;

import com.kuguo.front.entity.Label;
import com.kuguo.front.entity.ProductLabel;

@MyBatisRepository
public interface LabelDao {
	
	Label get(Long id);
	
	/**
	 * 通过name获取标签
	 * @param name
	 * @return
	 */
	Label getByName(String name);

	/**
	 * 获取热门标签
	 * @param num
	 * @return
	 */
	List<Label> getHotLabel(int num);
	
	/**
	 * 保存标签
	 * @param label
	 */
	Integer saveLabel(Label label);
	
	/**
	 * 将商品和标签关联
	 * @param productLabel
	 */
	void saveProductLabel(ProductLabel productLabel);
	
	/**
	 * 获取当前用户添加标签数量
	 * @param id
	 * @return
	 */
	Integer getLabelCountByUser(Long id);
	
	/**
	 * 通过id获取该用户所添加的标签信息
	 * @param id
	 * @return
	 */
	List<Label> getLabelByUser(Long id);
}
