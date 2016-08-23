/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

/**
 *
 * @author Henry
 */
import java.util.Scanner;

public class Menu {

    String[] hints;
    int n = 0;

    public Menu(int size) {
        if (size < 1) {
            size = 10;
        }
        hints = new String[size];
    }

    public void add(String aHint) {
        if (n < hints.length) {
            hints[n++] = aHint;
        }
    }

    public int getChoice() {
        int result = 0;
        int i = 0;
        if (n > 0) {
            for (String x : hints) {
                System.out.println("" + ++i + " - " + x);
            }
            System.out.print("Please select an operation: ");
            Scanner sc = new Scanner(System.in);
            result = Integer.parseInt(sc.nextLine());
        }
        return result;
    }
}
