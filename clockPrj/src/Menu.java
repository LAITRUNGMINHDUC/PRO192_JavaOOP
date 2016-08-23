/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends ArrayList<String> implements I_Menu {

    ArrayList<String> list = new ArrayList<String>();

    public Menu() {
        super();
        list.add("");
    }

    @Override
    public void addItem(String s) {
        list.add(s);
    }

    @Override
    public int getChoice() {
        for (int i = 1; i < list.size(); i++) {
            System.out.println(i + ". " + list.get(i));
        }
        System.out.print("Your choice: ");
        Scanner sc = new Scanner(System.in);
        int n = 0;
        try {
            n = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Error input");
            return getChoice();
        }
        return n;
    }
}
