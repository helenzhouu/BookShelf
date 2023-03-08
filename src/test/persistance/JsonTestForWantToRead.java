package persistance;

import model.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTestForWantToRead {
    protected void checkBook(String title, String review, Integer rating, Book book) {
        assertEquals(title, book.getBookTitle());
        assertEquals(review, book.getReview());
        assertEquals(title, book.getRating());
    }
}
