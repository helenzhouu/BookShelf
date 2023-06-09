package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// represents a list of books that the user wants to read
public class WantToReadList implements Writable {
    private ArrayList<NextBook> wantToRead;  // list of books that user wants to read
    private Book bookNotRead;   // book that user wants to read

    // EFFECT: constructs an empty books list
    public WantToReadList() {
        wantToRead = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a book to a list of books that user wants to read
    public void addBookToRead(NextBook futurebook) {
        wantToRead.add(futurebook);
        EventLog.getInstance().logEvent(new Event("Added book: " + futurebook.getNextBookTitle()
                + " with description: " + futurebook.getDescription()));
    }

    // REQUIRES: non-empty list
    // MODIFIES: this
    // EFFECTS: if given book name exists in list,
    //            - remove book from list of books that user wants to read and return true
    //          otherwise, return false
    public Boolean removeBookNotRead(String title) {
        for (NextBook bk : wantToRead) {
            if (title.equals(bk.getNextBookTitle())) {
                wantToRead.remove(bk);
                EventLog.getInstance().logEvent(new Event("Removed book: " + bk.getNextBookTitle()
                        + " with description: " + bk.getDescription()));
                return true;
            }
        }
        return false;
    }


    // EFFECTS: if book title matches a book in list,
    //               - return that book with description
    //          otherwise, signal an error
    public NextBook getNextBook(String title) {
        for (NextBook nextbk : wantToRead) {
            if (title.equals(nextbk.getNextBookTitle())) {
                EventLog.getInstance().logEvent(new Event("Found book: " + nextbk.getNextBookTitle()));
                return nextbk;
            }
        }
        return null;
    }

    // EFFECTS: returns the amount of books in the list
    public int booksReadLength() {
        EventLog.getInstance().logEvent(new Event("Returned bookshelf size: " + wantToRead.size()));
        return wantToRead.size();
    }

    // EFFECTS: returns all the books in the list
    public ArrayList<NextBook> getAllNextBooks() {
        EventLog.getInstance().logEvent(new Event("Returned all books in want to read list"));
        return wantToRead;
    }

    // EFFECTS: converts to json
    // CODE SOURCE: Json Serialization Demo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("nextbooks", nextBooksToJson());
        return json;
    }

    // EFFECTS: returns books in this BooksReadList as a JSON array
    // CODE SOURCE: Json Serialization Demo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
    private JSONArray nextBooksToJson() {
        JSONArray jsonArray = new JSONArray();

        for (NextBook bk : wantToRead) {
            jsonArray.put(bk.toJson());
        }

        return jsonArray;
    }
}
