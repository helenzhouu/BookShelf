package model;

import java.util.ArrayList;

public class WantToRead {
    private ArrayList<Book> booksNotRead;
    private Book bookToRead;


    // MODIFIES: this
    // EFFECTS: adds a book to a list of books that user wants to read
    public void addBookToRead(Book book) {
        booksNotRead.add(bookToRead);
    }
}
