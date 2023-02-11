package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextBookTest {
    private NextBook testNextBook1;

    @BeforeEach
    void setup() {
        testNextBook1 = new NextBook("The Giver", "set in a dystopian society");
    }

    @Test
    void testNextBookConstructor() {
        assertEquals("The Giver", testNextBook1.getNextBookTitle());
        assertEquals("set in a dystopian society", testNextBook1.getDescription());
    }

}
