package com.kuguo.front.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.kuguo.front.SpringTransactionalTestCase;
import com.kuguo.front.entity.Comment;
import com.kuguo.front.entity.Product;
import com.kuguo.front.repository.CommentDao;
import com.kuguo.front.repository.ProductDao;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ProductServiceTest extends SpringTransactionalTestCase {
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CommentDao commentDao;
	
	@Test
	public void testget() {
		Product product = productDao.get(4L);
		assertNotNull(product);
	}
	
	@Test
	public void commentTest() {
		List<Comment> comment = commentDao.getComments(4L);
		assertNotNull(comment);
	}
}
