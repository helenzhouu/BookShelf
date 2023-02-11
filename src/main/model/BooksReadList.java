package model;

import java.util.ArrayList;

public class BooksReadList {
    private ArrayList<Book> booksRead;

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
    // EFFECTS: removes book from list of books already read
    public void removeBookAlreadyRead(Book book) {
        booksRead.remove(book);
    }

    // EFFECTS: if book title matches a book in the list,
    //             - return book
    //          otherwise, return error (exception handling?)
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

}
