package persistence;

import model.NextBook;
import model.WantToReadList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads WantToReadBook list from JSON data stored in file
// CODE SOURCE: Json Serialization Demo
public class JsonReaderForWantToRead {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReaderForWantToRead(String source) {
        this.source = source;
    }

    // EFFECTS: reads book from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WantToReadList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWantToReadList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses booksReadList from JSON object and returns it
    private WantToReadList parseWantToReadList(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        WantToReadList wtr = new WantToReadList();
        addBooks(wtr, jsonObject);
        return wtr;
    }

    // MODIFIES: wtr
    // EFFECTS: parses books from JSON object and adds them to workroom
    private void addBooks(WantToReadList wtr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("books");
        for (Object json : jsonArray) {
            JSONObject nextBook = (JSONObject) json;
            addBook(wtr, nextBook);
        }
    }

    // MODIFIES: wtr
    // EFFECTS: parses book from JSON object and adds it to workroom
    private void addBook(WantToReadList wtr, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String description = jsonObject.getString("description");
        NextBook book = new NextBook(title, description);
        wtr.addBookToRead(book);
    }
}
