
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP
 */
public class BookManager {

    public static void main(String[] args) {
        String filename = "books.dat";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.add("View books");
        menu.add("Add new book");
        menu.add("Save to file");
        menu.add("Quit");
        int uC;
        BookList list = new BookList();
        list.loadBookFromFile(filename);
        do {
            System.out.println("\nBOOK MANAGER");
            uC = menu.getUserChoice();
            switch (uC) {
                case 1:
                    list.print();
                    break;
                case 2:
                    list.addNewBook();
                    break;
                case 3:
                    list.saveToFile(filename);
                    break;
            }
        } while (uC > 0 && uC < menu.size());
    }
}
