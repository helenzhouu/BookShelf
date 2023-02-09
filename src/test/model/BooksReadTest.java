package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

// unit tests for BooksRead class
class BooksReadTest {
    private Book testBookAlreadyRead;
    private Book testBook2;
    private BooksRead testBooksReadList;

    @BeforeEach
    void setup(){
        testBooksReadList = new BooksRead();
    }

    @Test
    void testConstructor1(){
        // stub
    }

    @Test
    void testAddBook(){
        testBookAlreadyRead = new Book("Pride and Prejudice", "classic", 10);
        testBooksReadList.addBookAlreadyRead(testBookAlreadyRead);
        assertEquals(1, testBooksReadList.booksReadLength());
    }

    @Test
    void testAddMultipleBooks(){
        testBook2 = new Book("Harry Potter", "good storyline", 6);
        testBooksReadList.addBookAlreadyRead(testBookAlreadyRead);
        testBooksReadList.addBookAlreadyRead(testBook2);
        assertEquals(2, testBooksReadList.booksReadLength());
    }
}