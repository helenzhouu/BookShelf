package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookClassTest {
    private Book testBook1;

    @BeforeEach
    public void setup() {
        testBook1 = new Book("The Hunger Games",
                "good plot and characters",
                7);
    }

    @Test
    public void testConstructor1() {
        assertEquals("The Hunger Games", testBook1.getBookTitle());
        assertEquals("good plot and characters", testBook1.getReview());
        assertEquals(7, testBook1.getRating());
    }
}