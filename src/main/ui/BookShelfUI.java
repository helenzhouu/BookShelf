package ui;

import model.Book;
import model.BooksReadList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// represents BookApp's main frame
public class BookShelfUI extends JFrame implements ActionListener {
    private JFrame bookFrame;
    private JPanel bookPanel;
    private JPanel buttonPanel;
    private JTextField bookTitle;
    private JTextField bookDesc;
    private String[] columnNames;
    private String[] data;
    private JTable books;
    private DefaultTableModel table;
    private JButton addButton;
    private JButton removeButton;

    // EFFECTS: constructs a bookshelf UI
    public BookShelfUI() {
        JFrame bookFrame = new JFrame("My List of Books I Want to Read");
        bookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bookFrame.setSize(700, 700);
        bookFrame.setLayout(new BorderLayout());
        String[] columnNames = {"Book Title", "Description"};
        String[][] data = {{"Harry Potter", "Fantasy"}};
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

    @SuppressWarnings({"method length", "checkstyle:SuppressWarnings", "checkstyle:MethodLength"})
    // EFFECTS: constructs a button panel
    private Component buttonPanel() {
        JPanel buttonPanel = new JPanel();

        addButton = new JButton("Add Book");
        addButton.setActionCommand("add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] data = {{bookTitle.getText()},
                        {bookDesc.getText()}};
                table.addRow(data);
                JOptionPane.showMessageDialog(bookFrame, "Book Successfully Added");
            }
        });

        removeButton = new JButton("Remove All Books");
        removeButton.setActionCommand("remove");
        addButton.addActionListener(this);

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        return buttonPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("remove".equals(e.getActionCommand())) {
            table.setRowCount(0);
        }
    }
}
