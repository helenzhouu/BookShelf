package persistance;

import model.Book;
import model.BooksReadList;
import model.WantToReadList;
import org.junit.jupiter.api.Test;
import persistence.JsonReaderForBooksRead;
import persistence.JsonWriterForBooksRead;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// CODE SOURCE: Json Serialization Demo
public class JsonWriterTestForBooksRead {

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
            JsonWriterForBooksRead wtr = new JsonWriterForBooksRead("./data/testWriterEmptyWorkroom.json");
            wtr.open();
            wtr.write(brl);
            wtr.close();

            JsonReaderForBooksRead reader = new JsonReaderForBooksRead("./data/testWriterEmptyWorkroom.json");
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
            JsonWriterForBooksRead wtr = new JsonWriterForBooksRead("./data/testWriterGeneralWorkroom.json");
            wtr.open();
            wtr.write(brl);
            wtr.close();

            JsonReaderForBooksRead reader = new JsonReaderForBooksRead("./data/testWriterGeneralWorkroom.json");
            brl = reader.read();
            List<Book> books = brl.getAllReadBooks();
            assertEquals(2, books.size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
