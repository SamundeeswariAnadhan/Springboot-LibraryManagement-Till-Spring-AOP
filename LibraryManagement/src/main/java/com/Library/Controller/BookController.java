package com.Library.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Library.Exception.ResourceNotFoundException;
import com.Library.Model.Book;
import com.Library.Repository.BookRepository;
import com.Library.Service.BookService;


@RestController
@RequestMapping("/library/")
public class BookController {
	
@Autowired 
  private BookRepository bookrepo;
@Autowired
  private BookService bookservice;

@GetMapping("books")
public List<Book> getAllBooks(){
return this.bookrepo.findAll();
}
@GetMapping("/books/{id}")
public ResponseEntity<Book> getBookById(@PathVariable(value="id") Integer Id) throws ResourceNotFoundException
{
Book book=bookrepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("book id is not available"+Id));
return ResponseEntity.ok().body(book);
}
@PostMapping("addbook")
public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) 
{
Book savedBook=bookservice.createBook(book);
return new ResponseEntity<Book>(savedBook,HttpStatus.CREATED);
}
@PutMapping("/books/{id}")
public ResponseEntity<Book> updateBook(@PathVariable(value="id") Integer Id, @Validated @RequestBody Book bookDetails) throws ResourceNotFoundException
{
Book book=bookrepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Book id is not available"+Id));
book.setAuthorName(bookDetails.getAuthorName());
book.setBookName(bookDetails.getBookName());

return ResponseEntity.ok(this.bookrepo.save(book));
}

@DeleteMapping("/books/{id}")
public Map<String,Boolean> deleteBook(@PathVariable(value="id") Integer Id) throws ResourceNotFoundException
{
Book book=bookrepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Book id is not available"+Id));
this.bookrepo.delete(book);
Map<String,Boolean> response=new HashMap<>();
response.put("deleted", Boolean.TRUE);
return response;

}












/*

@GetMapping("books")
public List<Book> getAllBooks() throws Exception
{
	List<Book> book = bookrepo.findAll();
	if (book.isEmpty()) {
		throw new Exception(
		"There are no data found ");
		}	
return book;
}

@PostMapping("addBook")
public ResponseEntity<Book> createBook(@Valid @RequestBody Book book)
{
	
Book savedBook=bookservice.createBook(book);


return new ResponseEntity<Book>(savedBook,HttpStatus.CREATED);

}

@DeleteMapping("/delete/{id}")
private void deleteBook(@PathVariable("id") int id)   
{  
	
bookservice.delete(id);  
}  

@GetMapping("/Get/{id}")  
private Book getBook(@PathVariable("id") int id) throws Exception   
{ 
	Book bookid=bookservice.getBookById(id);
	if (bookid==null) {
		throw new Exception(
		"There are no data found for Id:" + id);
		}
	return bookid;
//return bookservice.getBookById(id);  
}  
*/

}