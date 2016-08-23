/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import java.util.Scanner;

/**
 *
 * @author Henry
 */
public class MainApp {

    static int Menu() {
        int choice = 0;
        System.out.println();
        System.out.println("0. Add sample data");
        System.out.println("1. Add a softdrink");
        System.out.println("2. Update the price of a softdrink using it's code");
        System.out.println("3. Find softdrinks of a manufacturer");
        System.out.println("4. Delete all softdrinks of a manufacturer");
        System.out.println("5. List all products using ascending order of manufacturers and ascending order of prices");
        System.out.println("6. Exit");
        System.out.print("Your choice: ");
        Scanner sc = new Scanner(System.in);
        try {
            choice = Integer.parseInt(sc.nextLine());
            if (choice < 0 || choice > 6) {
                System.out.println("Error Input.");
                return Menu();
            }
        } catch (Exception e) {
            System.out.println("Error Input.");
            return Menu();
        }
        return choice;
    }

    public static void main(String args[]) {
        SoftdrinkList list = new SoftdrinkList(10);
        while (1 == 1) {
            int choice = Menu();
            switch (choice) {
                case 0:
                    list.addSoftdrinkTest();
                    break;
                case 1:
                    list.addSoftdrink();
                    break;
                case 2:
                    list.updateSoftdrinkByCode();
                    break;
                case 3:
                    list.findSoftdrinkByMake();
                    break;
                case 4:
                    list.deleteSoftdrinkByMake();
                    break;
                case 5:
                    list.listSoftdrink();
                    break;
                case 6:
                    System.out.println("Exit");
                    return;
            }
        }
    }
}
