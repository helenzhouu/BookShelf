package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NextBookTest {
    private NextBook testNextBook1;

    @BeforeEach
    void setup() {
        testNextBook1 = new NextBook("The Giver", "set in future society");
    }

    @Test
    void testNextBookConstructor() {
        assertEquals("The Giver", testNextBook1.getNextBookTitle());
        assertEquals("set in future society", testNextBook1.getDescription());
    }

    @Test
    void testToString() {
        assertTrue(testNextBook1.toString().contains("Book Title = The Giver, Overview = set in future society"));
    }

}
