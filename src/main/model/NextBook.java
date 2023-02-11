package model;

public class NextBook {
    private String nextBookTitle;
    private String description;

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
}
