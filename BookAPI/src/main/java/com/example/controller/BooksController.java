package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;
import com.example.service.BookService;

@RestController
@CrossOrigin
public class BooksController {

	@Autowired
	BookService bookService;
	
	@PostMapping("/book")
	public ResponseEntity<Book> addBook( @RequestBody Book book){
		Book addBook=bookService.addBook(book);
		return new ResponseEntity<>(addBook, HttpStatus.CREATED);
	}
	@GetMapping("/book/{id}")
	public Book getBookByBookId(@PathVariable int id){
//		if(id==10) {
//			throw new RuntimeException();
//		}
		return bookService.getBookFromDB(id);
	}
	@PutMapping("/book/updateBook")
	public String updateBook(@RequestBody Book book) {
		return bookService.updateBookInDB(book);
	}
	@DeleteMapping("/book/{bookId}")
	public String deleteBook(@PathVariable ("bookId") int id) {
		return bookService.deleteBookById(id);
	}
	@PutMapping("/book/issueBook/{studentId}/{bookId}")
	public ResponseEntity<Book> issueBook(@PathVariable int studentId , @PathVariable int bookId){
		Book issueBookToStudent=bookService.issueBookToStudent(studentId,bookId);
		return new ResponseEntity<Book>(issueBookToStudent, HttpStatus.CREATED);
		
	}
	@PutMapping("/book/returnBook/{studentId}/{bookId}")
	public ResponseEntity<Book> returnBook(@PathVariable int studentId,@PathVariable int bookId){
		Book returnBookToBookAPI=bookService.returnBookToBookAPI(studentId,bookId);
		return new ResponseEntity<Book>(returnBookToBookAPI, HttpStatus.CREATED);
	}
}
