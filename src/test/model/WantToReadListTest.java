package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// unit tests for WantToRead class
class WantToReadListTest {
    private NextBook testNextBook;
    private NextBook testNextBook2;
    private WantToReadList testNextBooks;

    @BeforeEach
    void setup() {
        testNextBooks = new WantToReadList();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testNextBooks.booksReadLength());
    }

    @Test
    void testAddBookToNextBooks() {
        testNextBook = new NextBook("The Giver", "dystopian setting");
        testNextBooks.addBookToRead(testNextBook);
        assertEquals(1, testNextBooks.booksReadLength());
    }

    @Test
    void testAddMultipleBooksToNextBooks() {
        testNextBook = new NextBook("The Giver", "dystopian setting");
        testNextBook2 = new NextBook("Snow White", "good book for kids");
        testNextBooks.addBookToRead(testNextBook);
        testNextBooks.addBookToRead(testNextBook2);
        assertEquals(2, testNextBooks.booksReadLength());
    }

    @Test
    void testGetNextBook() {
        testNextBook = new NextBook("The Giver", "dystopian setting");
        testNextBooks.addBookToRead(testNextBook);
        assertEquals(testNextBook, testNextBooks.getNextBook("The Giver"));
    }

    @Test
    void testRemoveBookFromNextBooks() {
        testNextBook2 = new NextBook("Snow White", "good book for kids");
        testNextBooks.addBookToRead(testNextBook);
        testNextBooks.addBookToRead(testNextBook2);
        assertEquals(2, testNextBooks.booksReadLength());
        testNextBooks.removeBookNotRead(testNextBook2);
        assertEquals(1, testNextBooks.booksReadLength());
    }

}