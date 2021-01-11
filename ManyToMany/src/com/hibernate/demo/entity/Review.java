package com.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="Review")
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="Comment")
	private String Comment;
	
	public Review() {
		
	}

	public Review(String comment) {
		super();
		Comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", Comment=" + Comment + "]";
	}
	
	
}
