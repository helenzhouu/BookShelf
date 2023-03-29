package ui;

import java.io.FileNotFoundException;

// EFFECTS: runs book app with GUI
public class MainUI {
    public static void main(String[] args) {
        try {
            new BookShelfUI();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
