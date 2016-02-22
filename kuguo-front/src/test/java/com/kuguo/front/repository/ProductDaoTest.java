package com.kuguo.front.repository;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.*;

import com.kuguo.front.SpringTransactionalTestCase;
import com.kuguo.front.entity.Product;

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ProductDaoTest extends SpringTransactionalTestCase {
	@Autowired
	private ProductDao productDao;

	@Test
	public void getProduct() {
		Product product = productDao.get(4L);
		assertNotNull(product);
	}

	@Test
	public void saveProduct() {
		Product product = new Product();
		product.setName("测试");
		product.setPicture("http");
		product.setOrder_link("http://sjfdlsjdfk");
		product.setBrand("");
		product.setPrice(0);
		product.setChannel("");
		productDao.save(product);
	}
	
	@Test
	public void getAll(){
		List<Product> all = productDao.getAll(0);
		assertNotNull(all);
	}
}
