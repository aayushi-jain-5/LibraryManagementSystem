package com.library;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Library system managing a collection of books.
 */
public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * Add a new book to the library collection with exception handling.
     * @param book Book to be added to the library.
     */
    public void addBook(Book book) {
        try {
            if (isBookExists(book.getBookId())) {
                throw new BookValidationException("Book with ID " + book.getBookId() + " already exists.");
            }
            books.add(book);
            System.out.println("Book added successfully!");
        } catch (BookValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * View all books in the library.
     */
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            books.forEach(book -> System.out.println(book.getBookId() + " | " + book.getTitle() + " | " + book.getAuthor() + " | " + book.getGenre() + " | " + book.getAvailabilityStatus()));
        }
    }

    /**
     * Search for a book by ID or Title with exception handling.
     * @param searchQuery Book ID or Title.
     * @return Book object if found.
     * @throws BookNotFoundException if the book is not found.
     */
    public Book searchBook(String searchQuery) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getBookId().equalsIgnoreCase(searchQuery) || book.getTitle().equalsIgnoreCase(searchQuery)) {
                return book;
            }
        }
        throw new BookNotFoundException("Book not found with ID or Title: " + searchQuery);
    }

    /**
     * Update the details of a book with exception handling.
     * @param bookId Book ID of the book to update.
     * @param newAvailabilityStatus New availability status for the book.
     */
    public void updateBookDetails(String bookId, String newAvailabilityStatus) {
        try {
            Book book = findBookById(bookId);
            if (book != null) {
                book.setAvailabilityStatus(newAvailabilityStatus);
                System.out.println("Book availability status updated.");
            } else {
                throw new BookNotFoundException("Book with ID " + bookId + " not found.");
            }
        } catch (BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Delete a book from the library collection with exception handling.
     * @param bookId Book ID of the book to delete.
     */
    public void deleteBook(String bookId) {
        try {
            Book book = findBookById(bookId);
            if (book != null) {
                books.remove(book);
                System.out.println("Book deleted successfully.");
            } else {
                throw new BookNotFoundException("Book with ID " + bookId + " not found.");
            }
        } catch (BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Check if a book exists by its ID.
     * @param bookId Book ID to search for.
     * @return true if the book exists, false otherwise.
     */
    private boolean isBookExists(String bookId) {
        return books.stream().anyMatch(book -> book.getBookId().equalsIgnoreCase(bookId));
    }

    /**
     * Helper method to find a book by its ID.
     * @param bookId Book ID to search for.
     * @return Book object if found, null otherwise.
     */
    private Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equalsIgnoreCase(bookId)) {
                return book;
            }
        }
        return null;
    }
}
