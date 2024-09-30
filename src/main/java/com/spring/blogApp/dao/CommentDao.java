package com.spring.blogApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.blogApp.bean.Comment;

@Repository
public interface CommentDao extends JpaRepository<Comment, Long>{

	List<Comment> findByPostId(Long postId);

}
