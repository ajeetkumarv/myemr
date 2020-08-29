package com.myemr.security.keycloak.model;

import org.springframework.stereotype.Component;

@Component
public class Book {
	private String id;
	private String title;
	private String author;
	
	public Book() {}
	public Book(String id, String title, String author) {
		this.id=id;
		this.title=title;
		this.author=author;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
