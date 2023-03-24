package ui;

import model.Book;
import model.BooksReadList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// represents BookApp's main frame
public class BookShelfUI extends JFrame implements ActionListener {
    private DefaultListModel bookListModel;
    private JList bookListing;
    private JPanel bookPanel;
    private JPanel buttonPanel;

    // EFFECTS: constructs a bookshelf UI
    public BookShelfUI() {
        JFrame bookFrame = new JFrame("My List Of Books I Want to Read");
        bookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bookFrame.setSize(700, 700);
        bookFrame.setLayout(new BorderLayout());

        bookFrame.add(bookMenu(), BorderLayout.NORTH);
        bookFrame.add(bookList(), BorderLayout.CENTER);
        bookFrame.add(bookPanel(), BorderLayout.SOUTH);
        bookFrame.add(buttonPanel(), BorderLayout.WEST);

        bookFrame.pack();
        bookFrame.setVisible(true);
    }

    // EFFECTS: constructs a book list
    private Component bookList() {
        bookListModel = new DefaultListModel<>();

        bookListing = new JList<>(bookListModel);
        JScrollPane bookScroll = new JScrollPane(bookListing);
        return bookListing;
    }

    // EFFECTS: constructs a book panel
    private Component bookPanel() {
        bookPanel = new JPanel();
        JLabel bookLabel = new JLabel("Enter Book Title");
        JTextField bookTitle = new JTextField(20);
        JLabel bookLabel2 = new JLabel("Enter Brief Overview");
        JTextField bookReview = new JTextField(50);

        bookPanel.add(bookLabel);
        bookPanel.add(bookTitle);
        bookPanel.add(bookLabel2);
        bookPanel.add(bookReview);
        return bookPanel;
    }

    private Component bookMenu() {
        JMenuBar bm = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem save = new JMenuItem("Save Books");
        JMenuItem load = new JMenuItem("Load Books");

        bm.add(file);
        file.add(save);
        file.add(load);
        return bm;
    }

    // EFFECTS: constructs a button panel
    private Component buttonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));

        Button addButton = new Button("Add Book");
        addButton.setActionCommand("Add");
        Button removeButton = new Button("Remove Book");
        removeButton.setActionCommand("Remove");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        return buttonPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
