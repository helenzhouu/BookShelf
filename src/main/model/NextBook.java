package model;

import org.json.JSONObject;
import persistence.Writable;

// represents a book that user wants to read with a title and brief description
public class NextBook implements Writable {
    private String nextBookTitle;   // title of the book user wants to read
    private String description;     // description of the book

    // EFFECTS: constructs a book with title and brief overview
    public NextBook(String nextBookTitle, String description) {
        this.nextBookTitle = nextBookTitle;
        this.description = description;
    }

    // EFFECTS: returns the book title
    public String getNextBookTitle() {
        return nextBookTitle;
    }

    // EFFECTS: returns the description of the book
    public String getDescription() {
        return description;
    }

    // EFFECTS: returns a string representation of book
    // CODE SOURCE: Teller App
    @Override
    public String toString() {
        return "Book Title = " + nextBookTitle + ", Overview = " + description + "";
    }

    // EFFECTS: maps name to object
    // CODE SOURCE: JSON SERILIZATION DEMO
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", nextBookTitle);
        json.put("description", description);
        return json;
    }
}
