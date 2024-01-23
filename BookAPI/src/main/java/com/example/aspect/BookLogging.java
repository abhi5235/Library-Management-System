package com.example.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.exception.BookNotAvailableException;


@Aspect
@Component
public class BookLogging {

	Log LOGGER=LogFactory.getLog(BookLogging.class);
	
	@AfterThrowing(pointcut = "execution(* com.example.controller.BooksController.addBook(..))", throwing = "exception")
	public void afterThrowingforAddBook(BookNotAvailableException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());

	}

	@AfterThrowing(pointcut = "execution(* com.example.controller.BooksController.getBookByBookId(..))", throwing = "exception")
	public void afterThrowingforGetBookByBookId(BookNotAvailableException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());

	}
	@AfterThrowing(pointcut = "execution(* com.example.controller.BooksController.updateBook(..))", throwing = "exception")
	public void afterThrowingforUpdateBook(BookNotAvailableException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());

	}
	@AfterThrowing(pointcut = "execution(* com.example.controller.BooksController.deleteBook(..))", throwing = "exception")
	public void afterThrowingforDeleteBook(BookNotAvailableException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}
	@AfterThrowing(pointcut = "execution(* com.example.controller.BooksController.issueBook(..))", throwing = "exception")
	public void afterThrowingforIssueBook(BookNotAvailableException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}
	@AfterThrowing(pointcut = "execution(* com.example.controller.BooksController.returnBook(..))", throwing = "exception")
	public void afterThrowingforReturnBook(BookNotAvailableException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}
}
