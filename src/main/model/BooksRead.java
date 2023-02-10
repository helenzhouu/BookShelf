package model;

import java.util.ArrayList;

public class BooksRead {
    private ArrayList<Book> booksRead;

    // EFFECT: constructs an empty books list
    public BooksRead() {
        booksRead = new ArrayList<Book>();
    }

    // MODIFIES: this
    // EFFECTS: adds a book to a list of books that have been read
    public void addBookAlreadyRead(Book book) {
        booksRead.add(book);
    }

    // REQUIRES: non-empty list of books
    // MODIFIES: this
    // EFFECTS: removes book from list of books already read
    public void removeBookAlreadyRead(Book book) {
        booksRead.remove(book);
    }

    // EFFECTS: if book title matches a book in the list,
    //             - return book
    //          otherwise, return false
    public Book getBook(String title) {
        if (booksRead.contains(title)) {
            return getBook(title);
        }
        return null;
    }

    // EFFECTS: returns the amount of books in the list
    public int booksReadLength() {
        return booksRead.size();
    }

}
