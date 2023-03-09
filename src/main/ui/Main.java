package ui;

import java.io.FileNotFoundException;

// EFFECTS: runs book app
public class Main {
    public static void main(String[] args) {
        try {
            new BookApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
