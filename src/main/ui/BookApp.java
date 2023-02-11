package ui;


import model.Book;
import model.BooksReadList;
import model.NextBook;
import model.WantToReadList;

import java.util.Scanner;

public class BookApp {
    private Scanner input;
    private Book bookRead;
    private NextBook bookToRead;
    private BooksReadList finishedBooks;
    private WantToReadList nextBooks;

    public BookApp() {
        runBookApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // CODE SOURCE: TellarApp
    private void runBookApp() {
        boolean keepGoing = true;
        String command = null;

        Scanner input = new Scanner(System.in);

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

        System.out.println("\nGoodbye!");
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
            viewOneReadBook();
        } else if (command.equals("4")) {
            viewOneWantToReadBook();
        } else if (command.equals("5")) {
            viewAllReadBooks();
        } else if (command.equals("6")) {
            viewAllWantToReadBooks();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: display initial menu with options
    public void displayMenu() {
        System.out.println("Welcome to your bookshelf! What would you like to do? ");
        System.out.println("1 -> Add a book to my read bookshelf");
        System.out.println("2 -> Add a book to my want to read bookshelf");
        System.out.println("3 -> View one specific book from my read bookshelf");
        System.out.println("4 -> View one specific book from my want to read bookshelf");
        System.out.println("5 -> View my entire read bookshelf");
        System.out.println("6 -> View my entire want to read bookshelf");
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

        // thank you and give user option to return to menu
    }

    // MODIFIES: this
    // EFFECTS: adds book to list of next books that user wants to read
    public void doAddBookToNextBooks() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of your book: ");
        String readNextBookTitle = input.nextLine();
        System.out.println("Give a brief overview of the book: ");
        String bookDescription = input.nextLine();

        // method call
    }

    // EFFECTS: returns only the book that the user wants to see from read list
    public void viewOneReadBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of the book you want to view: ");
        String title = input.nextLine();
        finishedBooks.getBook(title);
    }

    // EFFECTS: returns only the book that the user wants to see from want to read list
    public void viewOneWantToReadBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of the book you want to view: ");
        String booktitle = input.nextLine();
        nextBooks.getNextBook(booktitle);
    }

    // EFFECTS: returns the list of all books in the read list
    public void viewAllReadBooks() {
        finishedBooks.getAllReadBooks();
    }

    // EFFECTS: returns the list of all books in the want to read list
    public void viewAllWantToReadBooks() {
        nextBooks.getAllNextBooks();
    }
}
