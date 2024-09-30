package com.spring.blogApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.blogApp.bean.Post;
import com.spring.blogApp.service.PostService;
import java.util.List;

@RestController
public class PostController {
	@Autowired
	private PostService postService;
	
	@PostMapping 
	public ResponseEntity<String> createPost(@RequestBody Post post) {
		Post response = postService.createPost(post);
		
		return new ResponseEntity<>("Post created successfully. Id ->" + response.getId(), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getPost/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post response = postService.getPostById(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getPosts")
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }

    @PutMapping("/updatePost/{id}")
    public ResponseEntity<String> updatePost(@RequestBody Post post, @PathVariable Long id) {
        postService.updatePostById(post, id);

        return new ResponseEntity<>("Post updated successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePostById(id);

        return new ResponseEntity<>("Post deleted successfully.", HttpStatus.OK);
    }
	

}
