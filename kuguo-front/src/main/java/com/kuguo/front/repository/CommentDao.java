package com.kuguo.front.repository;

import java.util.List;

import com.kuguo.front.entity.Comment;

@MyBatisRepository
public interface CommentDao {
	void save(Comment comment);

	List<Comment> getComments(Long id);

}
