package persistence;

import model.Book;
import model.BooksReadList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads BooksRead list from JSON data stored in file
// CODE SOURCE: Json Serialization Demo
public class JsonReaderForBooksRead {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReaderForBooksRead(String source) {
        this.source = source;
    }

    // EFFECTS: reads book from file and returns it;
    // throws IOException if an error occurs reading data from file
    public BooksReadList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseBooksReadList(jsonObject);
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
    private BooksReadList parseBooksReadList(JSONObject jsonObject) {
        BooksReadList brl = new BooksReadList();
        addBooks(brl, jsonObject);
        return brl;
    }

    // MODIFIES: brl
    // EFFECTS: parses books from JSON object and adds them to book list
    private void addBooks(BooksReadList brl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("booksread");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addBook(brl, nextThingy);
        }
    }

    // MODIFIES: brl
    // EFFECTS: parses book from JSON object and adds it to book list
    private void addBook(BooksReadList brl, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String review = jsonObject.getString("review");
        int rating = jsonObject.getInt("rating");
        Book book = new Book(title, review, rating);
        brl.addBookAlreadyRead(book);
    }
}
