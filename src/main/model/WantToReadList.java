package model;

import java.util.ArrayList;

// represents a list of books that the user wants to read
public class WantToReadList {
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
