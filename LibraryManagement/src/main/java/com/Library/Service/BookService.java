package com.Library.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.Model.Book;
import com.Library.Repository.BookRepository;



@Service
@Transactional
public class BookService {
	
	@Autowired
	private BookRepository bookrepo;

	public Book createBook(Book book) {
		System.out.println("check");

	return bookrepo.save(book);
	}

	public List<Book> listAll() {
	return bookrepo.findAll();
	}

	public Book get(int bookId) {
	return bookrepo.findById(bookId).get();
	}
	public void delete(int bookId) {
	bookrepo.deleteById(bookId);
	}

	public Book getBookById(int id)   
	{  
	return bookrepo.findById(id).get();  
	}
	
}
