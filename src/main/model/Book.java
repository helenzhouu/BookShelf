package model;

public class Book {
    private String bookTitle;
    private String review;
    private int rating;

    // EFFECTS: Book has a title, brief review, and rating of the book
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
