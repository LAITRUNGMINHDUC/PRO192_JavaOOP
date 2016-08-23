/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab9;

import java.util.Scanner;

/**
 *
 * @author Henry
 */
public class ItemManager {

    public static void main(String args[]) {
        String fName = "items.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.add("Add new item");
        menu.add("Remove an item");
        menu.add("Update item's price");
        menu.add("Print list");
        menu.add("Save file");
        menu.add("Quit");

        int choice;
        boolean changed = false;
        NewItems list = new NewItems();
        list.loadStoredCode(fName);

        while (1 == 1) {
            System.out.println();
            menu.printMenu();
            System.out.print("Choice: ");
            choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    list.addNewItem();
                    break;
                case 2:
                    list.remove();
                    break;
                case 3:
                    list.updatePrice();
                    break;
                case 4:
                    list.print();
                    break;
                case 5:
                    list.appendToFile(fName);
                    break;
                case 6:
                    return;
                default:
                    if (changed) {
                        System.out.println("Save changes Y/N: ");
                        String response = sc.nextLine().toUpperCase();
                        if (response.startsWith("Y")) {
                            list.appendToFile(fName);
                        }
                    }
            }
        }
    }
}
