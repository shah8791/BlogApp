package com.spring.blogApp.bean;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long Id;
	@Column
	String title;
	@Column
	String description;
	
	@OneToMany(mappedBy = "post")
	List<Comment> comments= new ArrayList<>();
	
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

	public Object getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	public void setDescription(Object description2) {
		// TODO Auto-generated method stub
		
	}

	public void setTitle(Object title2) {
		// TODO Auto-generated method stub
		
	}

	public Object getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
