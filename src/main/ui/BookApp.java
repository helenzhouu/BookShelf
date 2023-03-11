package ui;


import model.Book;
import model.BooksReadList;
import model.NextBook;
import model.WantToReadList;
import persistence.JsonReaderForBooksRead;
import persistence.JsonReaderForWantToRead;
import persistence.JsonWriterForBooksRead;
import persistence.JsonWriterForWantToRead;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// BookShelf application
public class BookApp {
    private Scanner input;
    private Book bookRead;
    private NextBook bookToRead;
    private BooksReadList finishedBooks;
    private WantToReadList nextBooks;
    private static final String JSON_STORE = "./data/booksread.json";
    private static final String JSON_STORE2 = "./data/nextbooks.json";
    private JsonWriterForBooksRead jsonWriterForBooksRead;
    private JsonReaderForBooksRead jsonReaderForBooksRead;
    private JsonWriterForWantToRead jsonWriterForWantToRead;
    private JsonReaderForWantToRead jsonReaderForWantToRead;

    // EFFECTS: runs the bookshelf app
    // CODE SOURCE: Json Serialization Demo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
    public BookApp() throws FileNotFoundException {
        jsonWriterForBooksRead = new JsonWriterForBooksRead(JSON_STORE);
        jsonReaderForBooksRead = new JsonReaderForBooksRead(JSON_STORE);
        jsonWriterForWantToRead = new JsonWriterForWantToRead(JSON_STORE2);
        jsonReaderForWantToRead = new JsonReaderForWantToRead(JSON_STORE2);
        runBookApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // CODE SOURCE: Teller App (https://github.students.cs.ubc.ca/CPSC210/TellerApp.git)
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
    // CODE SOURCE: TellerApp (https://github.students.cs.ubc.ca/CPSC210/TellerApp.git)
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
            viewAllReadBooks();
        } else if (command.equals("6")) {
            viewAllWantToReadBooks();
        } else if (command.equals("7")) {
            saveBooksReadList();
        } else if (command.equals("8")) {
            loadBooksReadList();
        } else if (command.equals("9")) {
            saveWantToReadList();
        } else if (command.equals("10")) {
            loadWantToReadList();
        } else {
            System.out.println("Selection not valid... please try again");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes book lists
    // CODE SOURCE: Teller App (https://github.students.cs.ubc.ca/CPSC210/TellerApp.git)
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
        System.out.println("5 -> View my entire read bookshelf");
        System.out.println("6 -> View my entire want to read bookshelf");
        System.out.println("7 -> Save books read list to file");
        System.out.println("8 -> Load books read list from file");
        System.out.println("9 -> Save want to read list to file");
        System.out.println("10 -> Load want to read list from file");
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

        if (finishedBooks.removeBookAlreadyRead(deleteBook)) {
            finishedBooks.removeBookAlreadyRead(deleteBook);
            System.out.println("You have removed " + deleteBook + " from your read bookshelf");
        } else {
            System.out.println("Cannot find book, please try again");
        }
    }

    // REQUIRES: non-empty list
    // MODIFIES: this
    // EFFECTS: removes book from list of next books that user wants to read
    public void removeBookFromNextBooks() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of the book you want to remove: ");
        String deleteNextBook = input.nextLine();

        if (nextBooks.removeBookNotRead(deleteNextBook)) {
            nextBooks.removeBookNotRead(deleteNextBook);
            System.out.println("You have removed " + deleteNextBook + " from your bookshelf");
        } else {
            System.out.println("Cannot find book, please try again");
        }
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

    // EFFECTS: saves the BooksReadList to file
    // CODE SOURCE: Json Serialization Demo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
    private void saveBooksReadList() {
        try {
            jsonWriterForBooksRead.open();
            jsonWriterForBooksRead.write(finishedBooks);
            jsonWriterForBooksRead.close();
            System.out.println("Saved your books read list to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads BooksReadList from file
    // CODE SOURCE: Json Serialization Demo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
    private void loadBooksReadList() {
        try {
            finishedBooks = jsonReaderForBooksRead.read();
            System.out.println("Loaded your books read list from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // EFFECTS: saves the WantToReadList to file
    // CODE SOURCE: Json Serialization Demo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
    private void saveWantToReadList() {
        try {
            jsonWriterForWantToRead.open();
            jsonWriterForWantToRead.write(nextBooks);
            jsonWriterForWantToRead.close();
            System.out.println("Saved your want to read books list to " + JSON_STORE2);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE2);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads WantToReadList from file
    // CODE SOURCE: Json Serialization Demo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
    private void loadWantToReadList() {
        try {
            nextBooks = jsonReaderForWantToRead.read();
            System.out.println("Loaded your want to read books read list from " + JSON_STORE2);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE2);
        }
    }
}
