package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// unit tests for WantToReadList class
class WantToReadListTest {
    private NextBook testNextBook;
    private NextBook testNextBook2;
    private NextBook testNextBook3;
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
    void testRemoveBookFromNextBooks() {
        testNextBook = new NextBook("The Giver", "dystopian setting");
        testNextBook2 = new NextBook("Snow White", "good book for kids");
        testNextBooks.addBookToRead(testNextBook);
        testNextBooks.addBookToRead(testNextBook2);
        assertEquals(2, testNextBooks.booksReadLength());
        assertTrue(testNextBooks.removeBookNotRead(testNextBook2.getNextBookTitle()));
        assertEquals(1, testNextBooks.booksReadLength());
    }

    @Test
    void testRemoveNonExistentBook() {
        testNextBook = new NextBook("The Giver", "dystopian setting");
        testNextBooks.addBookToRead(testNextBook);
        assertFalse(testNextBooks.removeBookNotRead("Lord Of The Rings"));
    }

    @Test
    void testGetNextBook() {
        testNextBook = new NextBook("The Giver", "dystopian setting");
        testNextBooks.addBookToRead(testNextBook);
        assertEquals(testNextBook, testNextBooks.getNextBook("The Giver"));
    }


    @Test
    void testGetNextBookThatDoesntExist() {
        testNextBook2 = new NextBook("Pride and Prejudice", "classic");
        testNextBooks.addBookToRead(testNextBook2);
        assertNull(testNextBooks.getNextBook("Harry Potter"));
    }

    @Test
    void testViewAllNextBooks() {
        testNextBook = new NextBook("The Giver", "dystopian setting");
        testNextBook2 = new NextBook("Pride and Prejudice", "classic");
        testNextBook3 = new NextBook("Lord of the Rings", "fantasy adventure");
        testNextBooks.addBookToRead(testNextBook);
        testNextBooks.addBookToRead(testNextBook2);
        testNextBooks.addBookToRead(testNextBook3);
        assertEquals(3, testNextBooks.booksReadLength());
        assertTrue(testNextBooks.getAllNextBooks().contains(testNextBook));
        assertTrue(testNextBooks.getAllNextBooks().contains(testNextBook2));
        assertTrue(testNextBooks.getAllNextBooks().contains(testNextBook3));
    }

}