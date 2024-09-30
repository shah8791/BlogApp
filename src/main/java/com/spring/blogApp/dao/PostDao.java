package com.spring.blogApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.blogApp.bean.Post;

@Repository
public interface PostDao extends JpaRepository<Post, Long> {

}
