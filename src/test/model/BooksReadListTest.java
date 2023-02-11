package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// unit tests for BooksRead class
// Use abstract classes? supertype?

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
        testBooksReadList.addBookAlreadyRead(testBookAlreadyRead);
        testBooksReadList.addBookAlreadyRead(testBook2);
        assertEquals(2, testBooksReadList.booksReadLength());
        testBooksReadList.removeBookAlreadyRead(testBookAlreadyRead);
        assertEquals(1, testBooksReadList.booksReadLength());
    }

    @Test
    void testGetBook() {
        testBook2 = new Book("Harry Potter", "good storyline", 6);
        testBooksReadList.addBookAlreadyRead(testBook2);
        assertEquals(testBook2, testBooksReadList.getBook("Harry Potter"));
    }

//    @Test
//    void testViewAllReadBooks() {
//        testBookAlreadyRead = new Book("Pride and Prejudice", "classic", 10);
//        testBook2 = new Book("Harry Potter", "good storyline", 6);
//        testBooksReadList.addBookAlreadyRead(testBookAlreadyRead);
//        testBooksReadList.addBookAlreadyRead(testBook2);
//        assertEquals(testBooksReadList ,testBooksReadList.viewAllReadBooks());
//    }
}