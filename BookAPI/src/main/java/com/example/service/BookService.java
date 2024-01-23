package com.example.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.BookDTO;
import com.example.entity.Book;
import com.example.exception.BookNotAvailableException;
import com.example.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;

	public Book addBook(Book book) {
		return bookRepo.save(book);
	}

	public Book getBookFromDB(int id) {
		Optional<Book> OptionalBook = bookRepo.findById(id);
		Book orElseThrow = OptionalBook.orElseThrow(() -> new BookNotAvailableException("Book is not availbale"));
		return orElseThrow;
	}

	@Transactional
	public String updateBookInDB(Book book) {
		Optional<Book> findById = bookRepo.findById(book.getBookId());
		if (findById.isPresent()) {
			Book bookInDB = findById.get();
			bookInDB.setAuthorName(book.getAuthorName());
			bookInDB.setBookName(book.getBookName());
			bookInDB.setAvailability(book.getAvailability());
			bookInDB.setIssuedTo(book.getIssuedTo());
			bookInDB.setIssuedDate(book.getIssuedDate());
			return "Book " + book.getBookId() + " data is updated";
		} else {
			return "Book " + book.getBookId() + " is not available";
		}
	}

	public String deleteBookById(int id) {
		Optional<Book> findById = bookRepo.findById(id);
		findById.orElseThrow(
				() -> new BookNotAvailableException("Book which you are trying to delete already unavailable"));
		bookRepo.deleteById(id);
		return "deleted";

	}
    @Transactional
	public Book issueBookToStudent(int studentId, int bookId) {
		Book book= bookRepo.findById(bookId).orElseThrow(()->new BookNotAvailableException("Book is not available in database"));
		if(book.getAvailability().equals("Yes")) {
			book.setAvailability("No");
			book.setIssuedDate(LocalDate.now());
			book.setIssuedTo(studentId);
		}else {
			throw new BookNotAvailableException("Book is already issued to another student");
		}
		return book;
		
	}

    @Transactional
	public Book returnBookToBookAPI(int studentId, int bookId) {
		Optional<Book> findById = bookRepo.findById(bookId);
		Book book = findById.orElseThrow(()->new BookNotAvailableException("Data of book is not available in database"));
		if(book.getAvailability().equals("No")) {
			book.setAvailability("Yes");
			book.setIssuedDate(null);
			book.setIssuedTo(0);
		}else {
			throw new BookNotAvailableException("Book is already issued");
		}
		return book;
		
	}
}

	


