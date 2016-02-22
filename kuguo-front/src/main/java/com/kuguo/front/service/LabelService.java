package com.kuguo.front.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kuguo.front.entity.Label;
import com.kuguo.front.entity.ProductLabel;
import com.kuguo.front.repository.LabelDao;

@Component
@Transactional(readOnly = true)
public class LabelService {
	@Autowired
	private LabelDao labelDao;
	
	public List<Label> getHotLabel(int num) {
		return labelDao.getHotLabel(num);
	}
	
	public Label getLabeByName(String name) {
		return labelDao.getByName(name);
	}
	
	@Transactional(readOnly = false)
	public Boolean saveLabel(Label label) {
		Boolean result = false;
		Integer savenum = labelDao.saveLabel(label);
		if(savenum > 0) {
			result = true;
		}
		return result;
	}
	
	@Transactional(readOnly = false)
	public Boolean saveProductLabel(ProductLabel productLabel) {
		Boolean result = false;
		try {
			labelDao.saveProductLabel(productLabel);
			result = true;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return result;
	}
	
	public Integer getLabelCountByUser(Long id) {
		return labelDao.getLabelCountByUser(id);
	}
}
