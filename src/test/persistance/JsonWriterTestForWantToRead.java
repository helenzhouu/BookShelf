package persistance;

import model.NextBook;
import model.WantToReadList;
import org.junit.jupiter.api.Test;
import persistence.JsonReaderForWantToRead;
import persistence.JsonWriterForBooksRead;
import persistence.JsonWriterForWantToRead;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// CODE SOURCE: Json Serialization Demo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
public class JsonWriterTestForWantToRead {
    NextBook book1 = new NextBook("Lord of the Rings", "fantasy");
    NextBook book2 = new NextBook("The Giver", "dystopian");

    @Test
    void testWriterInvalidFile() {
        try {
            WantToReadList wtr = new WantToReadList();
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
            WantToReadList wtr = new WantToReadList();
            JsonWriterForWantToRead write = new JsonWriterForWantToRead(
                    "./data/testWriterEmptyWantToReadList.json");
            write.open();
            write.write(wtr);
            write.close();

            JsonReaderForWantToRead reader = new JsonReaderForWantToRead(
                    "./data/testWriterEmptyWantToReadList.json");
            wtr = reader.read();
            assertEquals(0, wtr.booksReadLength());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralBooksRead() {
        try {
            WantToReadList wtr = new WantToReadList();
            wtr.addBookToRead(book1);
            wtr.addBookToRead(book2);
            JsonWriterForWantToRead write = new JsonWriterForWantToRead(
                    "./data/testWriterGeneralWantToReadList.json");
            write.open();
            write.write(wtr);
            write.close();

            JsonReaderForWantToRead reader = new JsonReaderForWantToRead(
                    "./data/testWriterGeneralWantToReadList.json");
            wtr = reader.read();
            ArrayList<NextBook> nextbooks = wtr.getAllNextBooks();
            assertEquals(2, nextbooks.size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
