/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab8;

import java.util.Scanner;

/**
 *
 * @author Henry
 */
public class ManageProgram {

    public static void main(String args[]) {
        String fName = "employee.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.add("Add new emp");
        menu.add("Remove emp");
        menu.add("Promote salary");
        menu.add("Print list");
        menu.add("Save file");
        menu.add("Quit");

        int choice;
        boolean changed = false;
        EmpList list = new EmpList();
        list.AddFromFile(fName);

        while (1 == 1) {
            System.out.println();
            menu.printMenu();
            System.out.print("Choice: ");
            choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    list.addNewEmp();
                    changed = true;
                    break;
                case 2:
                    list.removeEmp();
                    changed = true;
                    break;
                case 3:
                    list.promote();
                    changed = true;
                    break;
                case 4:
                    list.print();
                    break;
                case 5:
                    list.saveToFile(fName);
                    changed = false;
                    break;
                case 6:
                    return;
                default:
                    if (changed) {
                        System.out.println("Save changes Y/N: ");
                        String response = sc.nextLine().toUpperCase();
                        if (response.startsWith("Y")) {
                            list.saveToFile(fName);
                        }
                    }
            }
        }
    }
}
