package com.example.exception;

public class BookNotAvailableException extends RuntimeException {

	public BookNotAvailableException(String message) {
		super(message);
	}

}
