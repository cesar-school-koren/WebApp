package com.school.koren.model;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


@SuppressWarnings("serial")
@Entity(name = "Category")
@Table(name = "Category")
@Immutable
public class Category implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(nullable = false)
	private String title;
	
	@OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Post> posts;

	public Category() {
	}

	public Category(int categoryId, String title) {
		this.categoryId = categoryId;
		this.title = title;
	}

	public Category(int categoryId, String title, Post posts) {
		this.categoryId = categoryId;
		this.title = title;
		this.posts = Stream.of(posts).collect(Collectors.toSet());
		this.posts.forEach(x -> x.setCategoryId(this));
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

}
