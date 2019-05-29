package com.school.koren.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SuppressWarnings("serial")
@Entity(name = "Account")
@Table(name = "Account")
public class Account implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int accountId;
	
	@Column(length = 50, nullable = false,unique = true)
	private String username;
	
	@Column(length = 50, nullable = false)
	private String password;
	
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false)
	private Date creationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login", nullable = true)
	private Date lastLogin;
	
	@Column(nullable = false)
	private Integer privilege;
	
	@OneToMany(mappedBy = "account_id", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Commentary> commentaries;
	
	@OneToMany(mappedBy = "account_id", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Post> posts;

	public Account() {
	}

	public Account(int accountId, String username, String password, String email, Date creationDate, Integer privilege) {
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.creationDate = creationDate;
		this.privilege = privilege;
	}

	public Account(int accountId, String username, String password, String email, Date creationDate, Date lastLogin, Integer privilege,
			Commentary commentaries, Post posts) {
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.creationDate = creationDate;
		this.lastLogin = lastLogin;
		this.privilege = privilege;
		this.commentaries = Stream.of(commentaries).collect(Collectors.toSet());
		this.commentaries.forEach(x -> x.setAccountId(this));
		this.posts = Stream.of(posts).collect(Collectors.toSet());
		this.posts.forEach(x -> x.setAccountId(this));
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public Integer getPrivilege() {
		return this.privilege;
	}
	
	public void setPrivilege(Integer privilege) {
		this.privilege = privilege;
	}

	public Set<Commentary> getCommentaries() {
		return this.commentaries;
	}

	public void setCommentaries(Set<Commentary> commentaries) {
		this.commentaries = commentaries;
	}

	public Set<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

}