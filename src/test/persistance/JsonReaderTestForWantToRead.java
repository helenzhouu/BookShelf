package persistance;

import model.NextBook;
import model.WantToReadList;
import org.junit.jupiter.api.Test;
import persistence.JsonReaderForWantToRead;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// CODE SOURCE: Json Serialization Demo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
public class JsonReaderTestForWantToRead {

    @Test
    void testReaderNonExistentFile() {
        JsonReaderForWantToRead reader = new JsonReaderForWantToRead("./data/noSuchFile.json");
        try {
            WantToReadList wtr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWantReadList() {
        JsonReaderForWantToRead reader = new JsonReaderForWantToRead("./data/testReaderEmptyWantReadList.json");
        try {
            WantToReadList wtr = reader.read();
            assertEquals(0, wtr.booksReadLength());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWantToReadList() {
        JsonReaderForWantToRead reader = new JsonReaderForWantToRead(
                "./data/testReaderGeneralWantToReadList.json");
        try {
            WantToReadList wtr = reader.read();
            List<NextBook> books = wtr.getAllNextBooks();
            assertEquals(2, books.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
