package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// unit tests for BooksReadList class
class BooksReadListTest {
    private Book testBookAlreadyRead;
    private Book testBook2;
    private BooksReadList testBooksReadList;

    @BeforeEach
    void setup() {
        testBooksReadList = new BooksReadList();
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
        testBookAlreadyRead = new Book("Pride and Prejudice", "classic", 10);
        testBook2 = new Book("Harry Potter", "good storyline", 6);
        testBooksReadList.addBookAlreadyRead(testBookAlreadyRead);
        testBooksReadList.addBookAlreadyRead(testBook2);
        assertEquals(2, testBooksReadList.booksReadLength());
        assertTrue(testBooksReadList.removeBookAlreadyRead(testBookAlreadyRead.getBookTitle()));
        assertEquals(1, testBooksReadList.booksReadLength());
    }

    @Test
    void testRemoveBookThatDoesntExist() {
        testBook2 = new Book("Harry Potter", "good storyline", 6);
        testBooksReadList.addBookAlreadyRead(testBook2);
        assertFalse(testBooksReadList.removeBookAlreadyRead("Hunger Games"));
    }

    @Test
    void testGetBook() {
        testBook2 = new Book("Harry Potter", "good storyline", 6);
        testBooksReadList.addBookAlreadyRead(testBook2);
        assertEquals(testBook2, testBooksReadList.getBook("Harry Potter"));
    }

    @Test
    void testGetBookThatDoesntExist() {
        testBookAlreadyRead = new Book("Pride and Prejudice", "classic", 10);
        testBooksReadList.addBookAlreadyRead(testBookAlreadyRead);
        assertNull(testBooksReadList.getBook("Harry Potter"));
    }

    @Test
    void testViewAllReadBooks() {
        testBookAlreadyRead = new Book("Pride and Prejudice", "classic", 10);
        testBook2 = new Book("Harry Potter", "good storyline", 6);
        testBooksReadList.addBookAlreadyRead(testBookAlreadyRead);
        testBooksReadList.addBookAlreadyRead(testBook2);
        assertEquals(2, testBooksReadList.booksReadLength());
        assertTrue(testBooksReadList.getAllReadBooks().contains(testBookAlreadyRead));
        assertTrue(testBooksReadList.getAllReadBooks().contains(testBook2));
    }
}