package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// unit tests for WantToRead class
class WantToReadTest {
    private Book testNextBook;
    private Book testNextBook2;
    private WantToRead testNextBooks;

    @BeforeEach
    void setup() {
        testNextBooks = new WantToRead();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testNextBooks.booksReadLength());
    }

    @Test
    void testAddBookToNextBooks() {
        testNextBook = new Book("The Giver", "interesting storyline", 8);
        testNextBooks.addBookToRead(testNextBook);
        assertEquals(1, testNextBooks.booksReadLength());
    }

    @Test
    void testRemoveBooksFromNextBooks() {
        testNextBook2 = new Book("Snow White", "good book for kids", 9);
        testNextBooks.addBookToRead(testNextBook);
        testNextBooks.removeBookNotRead(testNextBook2);
        assertEquals(1, testNextBooks.booksReadLength());
    }

}