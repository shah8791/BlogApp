package com.spring.blogApp.service;


import com.spring.blogApp.bean.Comment;
import com.spring.blogApp.bean.Post;
import com.spring.blogApp.dao.CommentDao;
import com.spring.blogApp.dao.PostDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
	@Autowired
	private PostDao postDAO;

	@Autowired
	private CommentDao commentDAO;
	//addComment()
	public Comment addComment(Comment comment, Long postId) {
        Post post = postDAO.findById(postId)
                .orElseThrow(() -> new RuntimeException(postId + " -> This post id doesn't exists"));
        comment.setPost(post);

        return commentDAO.save(comment);
    }

	//getCommentByCommentId()
	 public Comment getCommentByCommentId(Long id) {
	        return commentDAO.findById(id)
	                .orElseThrow(() -> new RuntimeException(id + " -> This id doesn't exists"));
	    }

	//getCommentByPostId()
	public List<Comment> getCommentByPostId(Long postId) {
		return commentDAO.findByPostId(postId);
	}
	
	//updateComment()
	public void updateCommentByCommentId(Long commentId, Long postId, Comment comment) {
        Post post = postDAO.findById(postId)
                .orElseThrow(() -> new RuntimeException(postId + " -> This post id doesn't exists"));

        comment.setId(commentId);
        comment.setPost(post);

        commentDAO.save(comment);
    }
	
	//deleteComment()
	public void deleteCommentByCommentId(Long id) {
        if(commentDAO.findById(id).isPresent()) {
            commentDAO.deleteById(id);
        } else {
            throw new RuntimeException(id + " -> This id doesn't exists");
        }
    }
}
