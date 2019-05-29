package com.school.model;

import java.util.Date;
import java.util.List;
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

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;


@SuppressWarnings("serial")
@Entity(name = "Post")
@Table(name = "Post")
public class Post implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "post_id")
	private int postId;
	
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account_id;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category_id;
	
	@Column(nullable = false)
	private String text;
	
	@Column(length = 50, nullable = false)
	private String title;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false)
	private Date creationDate;
	
	@Column(name = "tags", columnDefinition="text[]")
	@Type(type = "com.karakays.hibernate.array.EnumArrayType",
    parameters = { @Parameter(name="enumClass", value="com.school.Post$Tag") })
	private List<Tag> tags;
	
	@OneToMany(mappedBy = "post_id", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Commentary> commentaries;

	public enum Tag {
		SAUDE, EDUCACAO, ARTIGO, DUVIDA;
	}
	
	public Post() {
	}

	public Post(int postId, Account account_id, Category category_id, String text, String title, Date creationDate,
			List<Tag> tags) {
		this.postId = postId;
		this.account_id = account_id;
		this.category_id = category_id;
		this.text = text;
		this.title = title;
		this.creationDate = creationDate;
		this.tags = tags;
	}

	public Post(int postId, Account account_id, Category category_id, String text, String title, Date creationDate,
			List<Tag> tags, Commentary commentaries) {
		this.postId = postId;
		this.account_id = account_id;
		this.category_id = category_id;
		this.text = text;
		this.title = title;
		this.creationDate = creationDate;
		this.tags = tags;
		this.commentaries = Stream.of(commentaries).collect(Collectors.toSet());
		this.commentaries.forEach(x -> x.setPostId(this));
	}

	public int getPostId() {
		return this.postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public Account getAccountId() {
		return this.account_id;
	}

	public void setAccountId(Account account_id) {
		this.account_id = account_id;
	}

	public Category getCategoryId() {
		return this.category_id;
	}

	public void setCategoryId(Category category_id) {
		this.category_id = category_id;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Tag> getTags() {
		return this.tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Set<Commentary> getCommentaries() {
		return this.commentaries;
	}

	public void setCommentaries(Set<Commentary> commentaries) {
		this.commentaries = commentaries;
	}

}
