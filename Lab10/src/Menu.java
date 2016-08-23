
import java.util.Scanner;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Menu extends Vector <String> {
    public Menu() {
        super();
    }
    
    int getUserChoice() {
        for (int i=0;i<this.size();i++) {
            System.out.println((i+1)+"-"+this.get(i));
        }
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        int choice=0;
        do {
            try {
                System.out.print("Enter choice:");
                check = true;
                choice = Integer.parseInt(sc.nextLine());
            } catch(Exception e) {
                check = false;
                System.out.println("Invalid Input");
            }
            if (choice < 1 || choice > this.size()) check = false;
        } while (!check);
        return choice;
    }
}
