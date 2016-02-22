package com.kuguo.front.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kuguo.front.entity.Comment;
import com.kuguo.front.repository.CommentDao;

@Component
@Transactional(readOnly = true)
public class CommentService {
	@Autowired
	private CommentDao commentDao;
	
	public List<Comment> getComments(Long id) {
		return commentDao.getComments(id);
	}
	
	@Transactional(readOnly = false)
	public void saveComment(Comment comment) {
		commentDao.save(comment);
	}
}
