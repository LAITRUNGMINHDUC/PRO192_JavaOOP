/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab8;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Henry
 */
public class Menu extends Vector<String> {

    public Menu() {
        super();
    }

    void addMenuItem(String S) {
        this.add(S);
    }

    void printMenu() {
        int i = 1;
        for (String x : this) {

            System.out.println(i + " - " + x);
            i++;
        }
    }

    int getUserChoice() {
        Scanner sc = new Scanner(System.in);
        int n;
        try {
            n = Integer.parseInt(sc.nextLine());
            if (n < 1 || n > this.size()) {
                System.out.println("Error Input");
                return getUserChoice();
            }
        } catch (Exception e) {
            System.out.println("Error Input");
            return getUserChoice();
        }
        return n;
    }

}
