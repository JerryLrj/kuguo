package com.kuguo.front.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.kuguo.front.SpringTransactionalTestCase;
import com.kuguo.front.entity.User;

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class UserDaoTest extends SpringTransactionalTestCase {
	@Autowired
	private UserDao userDao;

	@Test
	public void getUser() {
		User user = userDao.get(9L);
		assertNotNull(user);
	}

}
