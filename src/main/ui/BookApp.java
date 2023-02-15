package ui;


import model.Book;
import model.BooksReadList;
import model.NextBook;
import model.WantToReadList;

import java.util.Scanner;

// BookShelf application
public class BookApp {
    private Scanner input;
    private Book bookRead;
    private NextBook bookToRead;
    private BooksReadList finishedBooks;
    private WantToReadList nextBooks;

    // EFFECTS: runs the bookshelf app
    public BookApp() {
        runBookApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // CODE SOURCE: Teller App
    private void runBookApp() {
        boolean keepGoing = true;
        String command = null;

        start();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nThank you, goodbye!");
    }


    // MODIFIES: this
    // EFFECTS: processes user command
    // CODE SOURCE: TellerApp
    private void processCommand(String command) {
        if (command.equals("1")) {
            doAddBookToRead();
        } else if (command.equals("2")) {
            doAddBookToNextBooks();
        } else if (command.equals("3")) {
            removeBookFromReadBooks();
        } else if (command.equals("4")) {
            removeBookFromNextBooks();
        } else if (command.equals("5")) {
            viewOneReadBook();
        } else if (command.equals("6")) {
            viewOneWantToReadBook();
        } else if (command.equals("7")) {
            viewAllReadBooks();
        } else if (command.equals("8")) {
            viewAllWantToReadBooks();
        } else {
            System.out.println("Selection not valid... please try again");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes book lists
    // CODE SOURCE: Teller App
    private void start() {
        finishedBooks = new BooksReadList();
        nextBooks = new WantToReadList();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: display initial menu with options
    public void displayMenu() {
        System.out.println("Welcome to your bookshelf! What would you like to do? ");
        System.out.println("1 -> Add a book to my read bookshelf");
        System.out.println("2 -> Add a book to my want to read bookshelf");
        System.out.println("3 -> Remove a book to my read bookshelf");
        System.out.println("4 -> Remove a book to my want to read bookshelf");
        System.out.println("5 -> View one specific book from my read bookshelf");
        System.out.println("6 -> View one specific book from my want to read bookshelf");
        System.out.println("7 -> View my entire read bookshelf");
        System.out.println("8 -> View my entire want to read bookshelf");
        System.out.println("q -> Quit");
    }

    // MODIFIES: this
    // EFFECTS: adds book to list of books read
    public void doAddBookToRead() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of your book: ");
        String readBookTitle = input.nextLine();
        System.out.println("Give a brief review of the book you read: ");
        String bookReview = input.nextLine();
        System.out.println("Rate the book on a scale from 1-10");
        int bookRating = input.nextInt();

        bookRead = new Book(readBookTitle, bookReview, bookRating);
        finishedBooks.addBookAlreadyRead(bookRead);
        System.out.println("You have added " + bookRead.getBookTitle() + " to your read bookshelf");
    }

    // MODIFIES: this
    // EFFECTS: adds book to list of next books that user wants to read
    public void doAddBookToNextBooks() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of your book: ");
        String readNextBookTitle = input.nextLine();
        System.out.println("Give a brief overview of the book: ");
        String bookDescription = input.nextLine();

        bookToRead = new NextBook(readNextBookTitle, bookDescription);
        nextBooks.addBookToRead(bookToRead);
        System.out.println("You have added " + bookToRead.getNextBookTitle() + " to your want to read bookshelf");

    }

    // REQUIRES: non-empty list
    // MODIFIES: this
    // EFFECTS: removes book from list of books that user has read
    public void removeBookFromReadBooks() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of the book you want to remove: ");
        String deleteBook = input.nextLine();

        finishedBooks.removeBookAlreadyRead(finishedBooks.getBook(deleteBook));
        System.out.println("You have removed " + deleteBook + " from your read bookshelf");
    }

    // REQUIRES: non-empty list and book must already exist in the list
    // MODIFIES: this
    // EFFECTS: removes book from list of next books that user wants to read
    public void removeBookFromNextBooks() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of the book you want to remove: ");
        String deleteNextBook = input.nextLine();

        nextBooks.removeBookNotRead(nextBooks.getNextBook(deleteNextBook));
        System.out.println("You have removed " + deleteNextBook + " from your bookshelf");
    }

    // EFFECTS: returns only the book that the user wants to see from read list
    public void viewOneReadBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of the book you want to view: ");
        String title = input.nextLine();
        System.out.println(finishedBooks.getBook(title));
    }

    // EFFECTS: returns only the book that the user wants to see from want to read list
    public void viewOneWantToReadBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of the book you want to view: ");
        String booktitle = input.nextLine();
        System.out.println(nextBooks.getNextBook(booktitle));
    }

    // EFFECTS: returns the list of all books in the read list
    public void viewAllReadBooks() {
        System.out.println(finishedBooks.getAllReadBooks());
    }

    // EFFECTS: returns the list of all books in the want to read list
    public void viewAllWantToReadBooks() {
        System.out.println(nextBooks.getAllNextBooks());
    }
}
