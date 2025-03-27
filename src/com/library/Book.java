package com.library;

/**
 * Represents a Book in the Library.
 */
public class Book {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;

    /**
     * Constructor to initialize the Book object with validation.
     * @param bookId Book ID (must be unique).
     * @param title Title of the book (cannot be empty).
     * @param author Author of the book (cannot be empty).
     * @param genre Genre of the book.
     * @param availabilityStatus Availability status of the book ("Available" or "Checked Out").
     * @throws BookValidationException if any validation fails.
     */
    public Book(String bookId, String title, String author, String genre, String availabilityStatus) throws BookValidationException {
        if (title == null || title.isEmpty()) {
            throw new BookValidationException("Title cannot be empty.");
        }
        if (author == null || author.isEmpty()) {
            throw new BookValidationException("Author cannot be empty.");
        }
        if (!availabilityStatus.equals("Available") && !availabilityStatus.equals("Checked Out")) {
            throw new BookValidationException("Invalid availability status. Must be 'Available' or 'Checked Out'.");
        }

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    // Getters and Setters
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
