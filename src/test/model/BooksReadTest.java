package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

// unit tests for BooksRead class
// QUESTIONS: is it ok that im only using assertEquals for tests?
//            is it ok that my BooksRead and WantToRead classes are very similar?
//            how can i test getnextbook to return a book and also true?
//            need some help designing ui part of the project
//            review user stories: completed adding a book to list of books i want to read
//                                 completing adding a book to list of books i have already read
//                                 being able to add review and rating
//                                 being able to get and view book
//                                 being able to remove a book from the list


class BooksReadTest {
    private Book testBookAlreadyRead;
    private Book testBook2;
    private BooksRead testBooksReadList;

    @BeforeEach
    void setup() {
        testBooksReadList = new BooksRead();
    }

    @Test
    void testConstructor1() {
        assertEquals(0, testBooksReadList.booksReadLength());
    }

    @Test
    void testAddBook() {
        testBookAlreadyRead = new Book("Pride and Prejudice", "classic", 10);
        testBooksReadList.addBookAlreadyRead(testBookAlreadyRead);
        assertEquals(1, testBooksReadList.booksReadLength());
    }

    @Test
    void testAddMultipleBooks() {
        testBook2 = new Book("Harry Potter", "good storyline", 6);
        testBooksReadList.addBookAlreadyRead(testBookAlreadyRead);
        testBooksReadList.addBookAlreadyRead(testBook2);
        assertEquals(2, testBooksReadList.booksReadLength());
    }

    @Test
    void testRemoveBook() {
        testBooksReadList.addBookAlreadyRead(testBookAlreadyRead);
        testBooksReadList.addBookAlreadyRead(testBook2);
        assertEquals(2, testBooksReadList.booksReadLength());
        testBooksReadList.removeBookAlreadyRead(testBookAlreadyRead);
        assertEquals(1, testBooksReadList.booksReadLength());
    }

    @Test
    void testGetBook() {
        testBooksReadList.addBookAlreadyRead(testBook2);
        testBooksReadList.getBook("Harry Potter");
        assertEquals(testBook2, testBooksReadList.getBook("Harry Potter"));
    }

    @Test
    void testGetBookThatDoesntExist() {
        testBooksReadList.addBookAlreadyRead(testBookAlreadyRead);
        testBooksReadList.addBookAlreadyRead(testBook2);
        testBooksReadList.getBook("The Book Thief");
        assertEquals(null, testBooksReadList.getBook("The Book Thief"));
    }
}