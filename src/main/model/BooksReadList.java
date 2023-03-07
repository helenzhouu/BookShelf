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
                return bk;
            }
        }
        return null;
    }

    // EFFECTS: returns the amount of books in the list
    public int booksReadLength() {
        return booksRead.size();
    }

    // EFFECTS: returns all the books in the list
    public ArrayList<Book> getAllReadBooks() {
        return booksRead;
    }

    // EFFECTS:
    // CODE SOURCE: Json Serialization Demo
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("booksread", booksToJson());
        return json;
    }

    // EFFECTS: returns books in this BooksReadList as a JSON array
    // CODE SOURCE: Json Serialization Demo
    private JSONArray booksToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Book bk : booksRead) {
            jsonArray.put(bk.toJson());
        }

        return jsonArray;
    }

}
