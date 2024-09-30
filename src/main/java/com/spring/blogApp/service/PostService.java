package com.spring.blogApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.blogApp.bean.Post;
import com.spring.blogApp.dao.PostDao;

@Service
public class PostService {
	@Autowired
	private PostDao postDao;
	
	public Post createPost(Post post) {
		return postDao.save(post);
	}
	
	 public Post getPostById(Long id) {
	        return postDao.findById(id).orElseThrow(() -> new RuntimeException(id + " -> This id doesn't exists"));
	    }

	    public List<Post> getAllPost() {
	        return postDao.findAll();
	    }

	    public void updatePostById(Post post, Long id){
	        if(postDao.findById(id).isPresent()) {
	            Post newPost = new Post();
	            newPost.setId(id);
	            newPost.setTitle(post.getTitle());
	            newPost.setDescription(post.getDescription());

	            postDao.save(newPost);
	        } else {
	            throw new RuntimeException(id + " -> This id doesn't exists");
	        }
	    }

	    public void deletePostById(Long id) {
	        if(postDao.findById(id).isPresent()) {
	            postDao.deleteById(id);
	        } else {
	            throw new RuntimeException(id + " -> This id doesn't exists");
	        }
	    }

}
