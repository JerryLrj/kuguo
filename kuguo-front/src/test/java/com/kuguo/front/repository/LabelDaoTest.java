package com.kuguo.front.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;

import com.kuguo.front.SpringTransactionalTestCase;
import com.kuguo.front.entity.Label;
import com.kuguo.front.entity.ProductLabel;

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class LabelDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private LabelDao labelDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void saveLabel() {
		Label label = new Label();
		label.setName("测试标签");
		label.setProduct(productDao.get(10L));
		label.setCreate_user(userDao.get(9L));
		labelDao.saveLabel(label);
	}
	
	@Test
	public void getLabelId() {
		Label label = labelDao.getByName("标签");
		assertNotNull(label);
	}
	
	@Test
	public void saveProductLabel() {
		ProductLabel pl = new ProductLabel();
		pl.setLabel(labelDao.get(1L));
		pl.setProduct(productDao.get(7L));
		labelDao.saveProductLabel(pl);
	}
	
}
