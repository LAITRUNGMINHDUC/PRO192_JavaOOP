/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import java.util.Scanner;

/**
 *
 * @author Henry
 */
public class MainApp {

    static int Menu() {
        int n;
        System.out.println();
        System.out.println("1 - Add an employee (Code: Exxx)");
        System.out.println("2 - Search employee details using his/her code");
        System.out.println("3 - Remove an employee  using his/her code");
        System.out.println("4 - Update information of an employee using his/her code");
        System.out.println("5 - Print out all the list");
        System.out.println("6 - Print out employees whose incomes (salary+allowance) are in the range r1, r2 (r1, r2 are inputted)");
        System.out.println("7 - Save and Exit");
        System.out.println("Your choice: ");
        try {
            Scanner sc = new Scanner(System.in);
            n = Integer.parseInt(sc.nextLine());
            if (n < 0 || n > 7) {
                System.out.println("Error Input");
                return Menu();
            }
        } catch (Exception e) {
            System.out.println("Error Input");
            return Menu();
        }
        return n;
    }

    public static void main(String args[]) {
        EmployeeList list = new EmployeeList(100);
        list.readFile();
        while (1 == 1) {
            int n = Menu();
            switch (n) {
                case 1:
                    list.addEmployee();
                    break;
                case 2:
                    list.searchEmployee();
                    break;
                case 3:
                    list.deleteEmployee();
                    break;
                case 4:
                    list.updateEmployee();
                    break;
                case 5:
                    list.printList();
                    break;
                case 6:
                    list.printListByIncomes();
                    break;
                case 7:
                    list.exportFile();
                    return;
            }
        }
    }
}
