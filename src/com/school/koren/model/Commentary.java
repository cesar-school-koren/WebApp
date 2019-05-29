package com.school.koren.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
	
	@Column(nullable = false)
	private Integer depth;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false, updatable = false)
	private Date creationDate;
	
	@OneToMany(mappedBy = "parent_id", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Commentary> commentaries;

	public Commentary() {
	}

	public Commentary(int commentaryId, Account account_id, Commentary parent_id, Post post_id, String text, Integer depth,
			Date creationDate) {
		this.commentaryId = commentaryId;
		this.account_id = account_id;
		this.parent_id = parent_id;
		this.post_id = post_id;
		this.text = text;
		this.depth = depth;
		this.creationDate = creationDate;
	}

	public Commentary(int commentaryId, Account account_id, Commentary parent_id, Post post_id, String text, Integer depth,
			Date creationDate, Commentary commentaries) {
		this.commentaryId = commentaryId;
		this.account_id = account_id;
		this.parent_id = parent_id;
		this.post_id = post_id;
		this.text = text;
		this.depth = depth;
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

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
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
	
	public static List<Commentary> sortComments(List<Commentary> lista){
		final Commentary nullPlaceholder = new Commentary();
		Map<Object, List<Commentary>> byParent = lista.stream()
		         .collect(Collectors.groupingBy(obj -> 
		           (obj.getParentId() == null ? nullPlaceholder : obj.getParentId())
		           , Collectors.toList()));

		List<Commentary> ordered = new ArrayList<>();
		Queue<Commentary> processor = new LinkedList<>();
		byParent.get(nullPlaceholder).forEach(processor::add);
		while (!processor.isEmpty()) {
			Commentary tmp = processor.poll();
		    byParent.getOrDefault(tmp, Collections.emptyList())
		    .forEach(processor::add);
		    ordered.add(tmp);
		}
		lista.clear();
		lista.addAll(ordered);
		    
		List<Commentary> sortedLista = new ArrayList<>();
		Commentary[] array = lista.stream().toArray(Commentary[]::new);
		Commentary temp = new Commentary();
		
		for (int i = 0; i < array.length; i++) {
			int counter = 1;
			Commentary pai = array[i];
			for (int j = i+1; j < array.length; j++) {
				if (array[j].getParentId() == pai) {
					temp = array[j];
					for(int k = j; k>=i+counter; k--) {
						array[k] = array[k-1];
					}
					array[i+counter] = temp;
					counter = counter + 1;
			    }
			}
		}
		

		sortedLista = Arrays.asList(array);   
		return sortedLista;
	}
}
