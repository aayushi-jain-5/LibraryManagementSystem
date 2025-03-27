package com.library;

/**
 * Custom exception for handling invalid book data.
 */
public class BookValidationException extends Exception {
    public BookValidationException(String message) {
        super(message);
    }
}
