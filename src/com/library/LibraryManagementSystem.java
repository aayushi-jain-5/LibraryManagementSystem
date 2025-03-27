package com.library;

import java.util.Scanner;

/**
 * Main class to interact with the library management system.
 */
public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addBook(library, scanner);
                    break;
                case 2:
                    library.viewAllBooks();
                    break;
                case 3:
                    searchBook(library, scanner);
                    break;
                case 4:
                    updateBook(library, scanner);
                    break;
                case 5:
                    deleteBook(library, scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

    private static void addBook(Library library, Scanner scanner) {
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Availability Status (Available/Checked Out): ");
        String availabilityStatus = scanner.nextLine();

        try {
            Book book = new Book(bookId, title, author, genre, availabilityStatus);
            library.addBook(book);
        } catch (BookValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void searchBook(Library library, Scanner scanner) {
        System.out.print("Enter Book ID or Title to search: ");
        String query = scanner.nextLine();
        try {
            Book foundBook = library.searchBook(query);
            System.out.println("Book Found: " + foundBook.getBookId() + " | " + foundBook.getTitle() + " | " + foundBook.getAuthor() + " | " + foundBook.getGenre() + " | " + foundBook.getAvailabilityStatus());
        } catch (BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updateBook(Library library, Scanner scanner) {
        System.out.print("Enter Book ID to update: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter new availability status (Available/Checked Out): ");
        String newAvailabilityStatus = scanner.nextLine();
        library.updateBookDetails(bookId, newAvailabilityStatus);
    }

    private static void deleteBook(Library library, Scanner scanner) {
        System.out.print("Enter Book ID to delete: ");
        String bookId = scanner.nextLine();
        library.deleteBook(bookId);
    }
}
