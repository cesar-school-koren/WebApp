package com.school.model;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SuppressWarnings("serial")
@Entity(name = "Commentary")
@Table(name = "Commentary")
public class Commentary implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "commentary_id")
	private int commentaryId;
	
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account_id;
	
	@ManyToOne
	@JoinColumn(name = "parent_id", nullable = true)
	private Commentary parent_id;
	
	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false)
	private Post post_id;
	
	@Column(nullable = false)
	private String text;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false)
	private Date creationDate;
	
	@OneToMany(mappedBy = "parent_id", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Commentary> commentaries;

	public Commentary() {
	}

	public Commentary(int commentaryId, Account account_id, Commentary parent_id, Post post_id, String text,
			Date creationDate) {
		this.commentaryId = commentaryId;
		this.account_id = account_id;
		this.parent_id = parent_id;
		this.post_id = post_id;
		this.text = text;
		this.creationDate = creationDate;
	}

	public Commentary(int commentaryId, Account account_id, Commentary parent_id, Post post_id, String text,
			Date creationDate, Commentary commentaries) {
		this.commentaryId = commentaryId;
		this.account_id = account_id;
		this.parent_id = parent_id;
		this.post_id = post_id;
		this.text = text;
		this.creationDate = creationDate;
		this.commentaries = Stream.of(commentaries).collect(Collectors.toSet());
		this.commentaries.forEach(x -> x.setParentId(this));
	}

	public int getCommentaryId() {
		return this.commentaryId;
	}

	public void setCommentaryId(int commentaryId) {
		this.commentaryId = commentaryId;
	}

	public Account getAccountId() {
		return this.account_id;
	}

	public void setAccountId(Account account_id) {
		this.account_id = account_id;
	}

	public Commentary getParentId() {
		return this.parent_id;
	}

	public void setParentId(Commentary parent_id) {
		this.parent_id = parent_id;
	}

	public Post getPostId() {
		return this.post_id;
	}

	public void setPostId(Post post_id) {
		this.post_id = post_id;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Set<Commentary> getCommentaries() {
		return this.commentaries;
	}

	public void setCommentaries(Set<Commentary> commentaries) {
		this.commentaries = commentaries;
	}

}
