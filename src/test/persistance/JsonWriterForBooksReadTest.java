package persistance;

import model.Book;
import model.BooksReadList;
import org.junit.jupiter.api.Test;
import persistence.JsonReaderForBooksRead;
import persistence.JsonWriterForBooksRead;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// CODE SOURCE: Json Serialization Demo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
public class JsonWriterForBooksReadTest {

    @Test
    void testWriterInvalidFile() {
        try {
            BooksReadList brl = new BooksReadList();
            JsonWriterForBooksRead writer = new JsonWriterForBooksRead("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyBooksRead() {
        try {
            BooksReadList brl = new BooksReadList();
            JsonWriterForBooksRead wtr = new JsonWriterForBooksRead("./data/testWriterEmptyBookList.json");
            wtr.open();
            wtr.write(brl);
            wtr.close();

            JsonReaderForBooksRead reader = new JsonReaderForBooksRead("./data/testWriterEmptyBookList.json");
            brl = reader.read();
            assertEquals(0, brl.booksReadLength());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralBooksRead() {
        try {
            BooksReadList brl = new BooksReadList();
            brl.addBookAlreadyRead(new Book("Harry Potter", "good", 7));
            brl.addBookAlreadyRead(new Book("Hunger Games", "good", 8));
            JsonWriterForBooksRead wtr = new JsonWriterForBooksRead("./data/testWriterGeneralBookList.json");
            wtr.open();
            wtr.write(brl);
            wtr.close();

            JsonReaderForBooksRead reader = new JsonReaderForBooksRead("./data/testWriterGeneralBookList.json");
            brl = reader.read();
            ArrayList<Book> books = brl.getAllReadBooks();
            assertEquals(2, books.size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
