package com.kuguo.front.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kuguo.front.entity.Comment;
import com.kuguo.front.entity.Favorite;
import com.kuguo.front.entity.Product;
import com.kuguo.front.entity.User;
import com.kuguo.front.repository.CommentDao;
import com.kuguo.front.repository.FavoriteDao;
import com.kuguo.front.repository.ProductDao;
import com.kuguo.front.repository.TaobaoDao;
import com.kuguo.front.utils.Constant;
import com.taobao.api.domain.Item;

@Component
@Transactional(readOnly = true)
public class ProductService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private TaobaoDao taobaoDao;
	@Autowired
	private FavoriteDao favoriteDao;

	public List<Product> getProductsByPage(int page) {
		return productDao.getAll(page * Constant.PAGE_NUMBER);
	}
	
	public Integer getProductsCount() {
		Integer count = productDao.getCountProduct();
		Integer pagenum = 0;
		if(count%Constant.PAGE_NUMBER == 0) {
			pagenum = count/Constant.PAGE_NUMBER;
		} else {
			pagenum = count/Constant.PAGE_NUMBER + 1;
		}
		return pagenum;
	}

	public List<Product> getPopProducts() {
		return productDao.getPop();
	}

	public Product getProduct(Long id) {
		return productDao.get(id);
	}

	@Transactional(readOnly = false)
	public Integer saveProduct(Product entity) {
		Integer result = productDao.save(entity);
		Comment comment = entity.getComment();
		comment.setProductId(entity.getId());
		commentDao.save(comment);
		return result;
	}

	public Item getTaobaoItemByUrl(String url) {
		return taobaoDao.getTaoBaoItemByUrl(url);
	}

	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Autowired
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Autowired
	public void setTaobaoDao(TaobaoDao taobaoDao) {
		this.taobaoDao = taobaoDao;
	}

	public List<Product> getUserProducts(Long id) {
		return productDao.getUP(id);
	}

	public List<User> getLikedUsers(Long id) {
		return productDao.getLikedUsers(id);
	}

	public List<Product> getCommentProducts(Long id) {
		return productDao.getCommentProducts(id);
	}
	
	public List<Product> getFriendsActivity(Long id) {
		return productDao.getFriendsActivity(id);
	}
	
	@Transactional(readOnly = false)
	public Boolean saveFavorite(Favorite favorite, Product product) {
		Boolean result = false;
		try {
			favoriteDao.saveFavorite(favorite);
			result = true;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		product.setFavorite_num(product.getFavorite_num() + 1);
		productDao.updateProduct(product);
		return result;
	}
	
	public List<Product> getProductByTag(String name) {
		return productDao.getProductByTag(name);
	}
}
