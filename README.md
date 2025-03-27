# Library Management System

This is a simple library management system built using Java. It allows librarians to efficiently manage books by adding, updating, searching, and deleting books. The system also keeps track of each book's availability status.

## Features
- **Add Book**: Add a book with ID, title, author, genre, and availability status.
- **View All Books**: Display a list of all books.
- **Search Book**: Search a book by ID or Title.
- **Update Book**: Update the availability status of a book.
- **Delete Book**: Remove a book from the system.

## Run Instructions
 javac -d bin src/com/library/*.java 
 
java -cp bin com.library.LibraryManagementSystem

### Clone the Repository:
```bash
git clone https://github.com/aayushi-jain-5/LibraryManagementSystem.git

##### Challenges Faced
Input validation and exception handling were crucial aspects of the project, ensuring valid book data and handling errors like missing books.

The console-based interface, while functional, could be enhanced with a graphical user interface (GUI) for a better user experience.

##### Improvements
GUI: Could be added to make the system more user-friendly.

Database Integration: A database can be integrated to persist the book data beyond application restarts.

Unit Testing: Adding unit tests using JUnit to ensure system reliability.
