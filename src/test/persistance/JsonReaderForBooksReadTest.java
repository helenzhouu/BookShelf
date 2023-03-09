package persistance;

import model.Book;
import model.BooksReadList;
import org.junit.jupiter.api.Test;
import persistence.JsonReaderForBooksRead;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// CODE SOURCE: Json Serialization Demo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
public class JsonReaderForBooksReadTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReaderForBooksRead reader = new JsonReaderForBooksRead("./data/noSuchFile.json");
        try {
            BooksReadList brl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyBooksReadList() {
        JsonReaderForBooksRead reader = new JsonReaderForBooksRead("./data/testReaderEmptyBooksReadList.json");
        try {
            BooksReadList brl = reader.read();
            assertEquals(0, brl.booksReadLength());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralBooksReadList() {
        JsonReaderForBooksRead reader = new JsonReaderForBooksRead("./data/testReaderGeneralBooksReadList.json");
        try {
            BooksReadList brl = reader.read();
            ArrayList<Book> books = brl.getAllReadBooks();
            assertEquals(2, books.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
