package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// represents a list of books that user has already read
public class BooksReadList implements Writable {
    private ArrayList<Book> booksRead;  // list of read books

    // EFFECT: constructs an empty books list
    public BooksReadList() {
        booksRead = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a book to a list of books that have been read
    public void addBookAlreadyRead(Book book) {
        booksRead.add(book);
        EventLog.getInstance().logEvent(new Event("Added book: " + book.getBookTitle()));
    }

    // REQUIRES: non-empty list of books
    // MODIFIES: this
    // EFFECTS: if given book name exists in list,
    //             - removes book from list of books already read and returns true
    //         otherwise, return false
    public Boolean removeBookAlreadyRead(String title) {
        for (Book bk : booksRead) {
            if (title.equals(bk.getBookTitle())) {
                booksRead.remove(bk);
                EventLog.getInstance().logEvent(new Event("Removed book: " + bk.getBookTitle()));
                return true;
            }
        }
        return false;
    }

    // EFFECTS: if book title matches a book in the list,
    //             - return book
    //          otherwise, return error
    public Book getBook(String title) {
        for (Book bk : booksRead) {
            if (title.equals(bk.getBookTitle())) {
                EventLog.getInstance().logEvent(new Event("Found book: " + bk.getBookTitle()));
                return bk;
            }
        }
        return null;
    }

    // EFFECTS: returns the amount of books in the list
    public int booksReadLength() {
        EventLog.getInstance().logEvent(new Event("Returned bookshelf size: " + booksRead.size()));
        return booksRead.size();
    }

    // EFFECTS: returns all the books in the list
    public ArrayList<Book> getAllReadBooks() {
        EventLog.getInstance().logEvent(new Event("Returned all books in books read list"));
        return booksRead;
    }

    // EFFECTS: converts to json
    // CODE SOURCE: Json Serialization Demo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("booksread", booksToJson());
        return json;
    }

    // EFFECTS: returns books in this BooksReadList as a JSON array
    // CODE SOURCE: Json Serialization Demo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
    private JSONArray booksToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Book bk : booksRead) {
            jsonArray.put(bk.toJson());
        }

        return jsonArray;
    }

}
