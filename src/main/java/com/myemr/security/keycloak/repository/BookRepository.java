package com.myemr.security.keycloak.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.myemr.security.keycloak.model.Book;

@Repository
public class BookRepository {

	private static Map<String, Book> books = new ConcurrentHashMap<>();
	
	public List<Book> readAll() {
		List<Book> allBooks = new ArrayList<>(books.values());
        allBooks.sort(Comparator.comparing(Book::getId));
        return allBooks;
	}
	
	public void create(Book book) {
        books.put(book.getId(), book);
    }

    public Book read(String id) {
        return books.get(id);
    }

    public void update(Book book) {
        books.put(book.getId(), book);
    }

    public void delete(String id) {
        books.remove(id);
    }
}
