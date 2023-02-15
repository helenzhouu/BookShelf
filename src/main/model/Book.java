package model;

// represents a book that user has read with a title, review, and rating from 1-10
public class Book {
    private String bookTitle;  // book title
    private String review;     // review of the book
    private int rating;        // rating for the book in integers from 1-10

    // REQUIRES: rating must be an integer between 1-10
    // EFFECTS: Constructs a book with a title, brief review, and rating
    public Book(String bookTitle, String review, int rating) {
        this.bookTitle = bookTitle;
        this.review = review;
        this.rating = rating;
    }

    // EFFECTS: returns book title
    public String getBookTitle() {
        return bookTitle;
    }

    // EFFECTS: returns review of a book
    public String getReview() {
        return review;
    }

    // EFFECTS: returns rating of a book
    public int getRating() {
        return rating;
    }

    // EFFECTS: returns a string representation of book
    // CODE SOURCE: Teller App
    @Override
    public String toString() {
        return "Book Title = " + bookTitle + ", Review = " + review + ", " + "Rating = " + rating + "";
    }
}
