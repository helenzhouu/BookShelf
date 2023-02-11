package model;

import java.util.ArrayList;

public class WantToReadList {
    private ArrayList<NextBook> wantToRead;
    private Book bookNotRead;

    // EFFECT: constructs an empty books list
    public WantToReadList() {
        wantToRead = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a book to a list of books that user wants to read
    public void addBookToRead(NextBook futurebook) {
        wantToRead.add(futurebook);
    }

    public void removeBookNotRead(NextBook bookNotRead) {
        wantToRead.remove(bookNotRead);
    }

    // EFFECTS: if book title matches a book in list,
    //               - return that book with description
    //          otherwise, signal an error
    public NextBook getNextBook(String title) {
        for (NextBook nextbk : wantToRead) {
            if (title.equals(nextbk.getNextBookTitle())) {
                return nextbk;
            }
        }
        return null;
    }

    // EFFECTS: returns the amount of books in the list
    public int booksReadLength() {
        return wantToRead.size();
    }

    // EFFECTS: returns all the books in the list
    public ArrayList<NextBook> getAllNextBooks() {
        return wantToRead;
    }
}
