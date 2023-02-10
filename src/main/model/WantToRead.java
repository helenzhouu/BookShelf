package model;

import java.util.ArrayList;

public class WantToRead {
    private ArrayList<Book> wantToRead;
    private Book bookNotRead;

    // EFFECT: constructs an empty books list
    public WantToRead() {
        wantToRead = new ArrayList<Book>();
    }

    // MODIFIES: this
    // EFFECTS: adds a book to a list of books that user wants to read
    public void addBookToRead(Book futurebook) {
        wantToRead.add(futurebook);
    }

    public void removeBookNotRead(Book bookNotRead) {
        wantToRead.remove(bookNotRead);
    }

    // EFFECTS: returns the amount of books in the list
    public int booksReadLength() {
        return wantToRead.size();
    }
}
