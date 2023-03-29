package ui;

import model.NextBook;
import model.WantToReadList;
import persistence.JsonReaderForWantToRead;
import persistence.JsonWriterForWantToRead;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// represents BookApp's main frame
public class BookShelfUI extends JFrame implements ActionListener {
    private JFrame bookFrame;
    private JPanel bookPanel;
    private JTextField bookTitle;
    private JTextField bookDesc;
    private JTable books;
    private DefaultTableModel table;
    private JMenuItem save;
    private JMenuItem load;
    private JButton addButton;
    private JButton removeButton;
    private NextBook nextBook;
    private WantToReadList wtr;
    private JsonWriterForWantToRead jsonWriter;
    private JsonReaderForWantToRead jsonReader;
    private static final String JSON_STORE3 = "./data/guiNextBooks.json";

    // EFFECTS: constructs a bookshelf UI
    public BookShelfUI() throws FileNotFoundException {
        JFrame bookFrame = new JFrame("My List of Books I Want to Read");
        bookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bookFrame.setSize(700, 700);
        bookFrame.setLayout(new BorderLayout());

        String[] columnNames = {"Book Title", "Description"};
        Object[][] data = {{}};
        table = new DefaultTableModel(data, columnNames);
        books = new JTable();
        books.setModel(table);

        JScrollPane scrollPane = new JScrollPane(books);

        bookFrame.add(bookMenu(), BorderLayout.NORTH);
        bookFrame.add(bookPanel(), BorderLayout.SOUTH);
        bookFrame.add(buttonPanel(), BorderLayout.WEST);
        bookFrame.add(scrollPane);

        bookFrame.pack();
        bookFrame.setVisible(true);

        wtr = new WantToReadList();
        jsonWriter = new JsonWriterForWantToRead(JSON_STORE3);
        jsonReader = new JsonReaderForWantToRead(JSON_STORE3);
    }


    // EFFECTS: constructs a book panel
    private Component bookPanel() {
        bookPanel = new JPanel();
        JLabel bookLabel = new JLabel("Enter Book Title");
        bookTitle = new JTextField(20);
        JLabel bookLabel2 = new JLabel("Enter Brief Overview");
        bookDesc = new JTextField(50);

        bookPanel.add(bookLabel);
        bookPanel.add(bookTitle);
        bookPanel.add(bookLabel2);
        bookPanel.add(bookDesc);
        return bookPanel;
    }

    // EFFECTS: creates a save and load option menu bar
    private Component bookMenu() {
        JMenuBar bm = new JMenuBar();
        JMenu file = new JMenu("File");

        save = new JMenuItem("Save Books");
        save.setActionCommand("save");
        save.addActionListener(this);

        load = new JMenuItem("Load Books");
        load.setActionCommand("load");
        load.addActionListener(this);

        bm.add(file);
        file.add(save);
        file.add(load);
        return bm;
    }

    // EFFECTS: constructs a button panel
    private Component buttonPanel() {
        JPanel buttonPanel = new JPanel();

        addButton = new JButton("Add Book");
        addButton.setActionCommand("add");
        addButton.addActionListener(this);

        removeButton = new JButton("Remove All Books");
        removeButton.setActionCommand("remove");
        removeButton.addActionListener(this);

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        return buttonPanel;
    }

    // MODIFIES: this
    // EFFECTS: adds book to a want to read list
    public void addBooks() {
        String title = bookTitle.getText();
        String desc = bookDesc.getText();
        nextBook = new NextBook(title, desc);
        wtr.addBookToRead(nextBook);
    }

    // EFFECTS: connects action function to buttons
    // IMAGE CITATION: https://pixabay.com/photos/a-book-books-bookshelf-read-67049/
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("add".equals(e.getActionCommand())) {
            String title = bookTitle.getText();
            String desc = bookDesc.getText();

            Object[] data = {title, desc};
            table.addRow(data);

            addBooks();

            ImageIcon bookshelf = new ImageIcon("books.jpg");
            JOptionPane.showMessageDialog(bookFrame,
                    "Book Successfully Added",
                    "Bookshelf", JOptionPane.INFORMATION_MESSAGE, bookshelf);
        } else if ("remove".equals(e.getActionCommand())) {
            DefaultTableModel model = (DefaultTableModel) books.getModel();
            model.setRowCount(0);
        } else if ("save".equals(e.getActionCommand())) {
            saveWantToReadList();
        } else if ("load".equals(e.getActionCommand())) {
            loadWantToReadList();
        }
    }

    // EFFECTS: saves the WantToReadList to file
    // CODE SOURCE: Json Serialization Demo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
    private void saveWantToReadList() {
        try {
            jsonWriter.open();
            jsonWriter.write(wtr);
            jsonWriter.close();
            System.out.println("Saved your want to read books list to " + JSON_STORE3);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE3);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads WantToReadList from file
    // CODE SOURCE: Json Serialization Demo (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git)
    private void loadWantToReadList() {
        try {
            wtr = jsonReader.read();
            for (NextBook bk : wtr.getAllNextBooks()) {
                Object[] data = {bk.getNextBookTitle(), bk.getDescription()};
                table.addRow(data);
            }
            System.out.println("Loaded your want to read books read list from " + JSON_STORE3);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE3);
        }
    }
}
