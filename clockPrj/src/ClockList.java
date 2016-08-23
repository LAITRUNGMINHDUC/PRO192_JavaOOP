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
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ClockList extends ArrayList implements I_List {

    ArrayList<Clock> list = new ArrayList<Clock>();
    Scanner sc = new Scanner(System.in);

    @Override
    public int find(String code) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add() {
        Clock obj = new Clock();
        System.out.println();
        System.out.print("Code: ");
        obj.setCode(sc.nextLine());
        System.out.print("Make: ");
        obj.setMake(sc.nextLine());
        try {
            System.out.print("Size: ");
            obj.setSize(Integer.parseInt(sc.nextLine()));
            System.out.print("Price: ");
            obj.setPrice(Integer.parseInt(sc.nextLine()));
            if (obj.getSize() < 0 || obj.getPrice() < 0) {
                System.out.println("Input Error");
                return;
            }
        } catch (Exception e) {
            System.out.println("Input Error");
            return;
        }

        if (find(obj.getCode()) == -1) {
            list.add(obj);
            System.out.println("Added");
        } else {
            System.out.println("Duplicate Code");
            return;
        }
    }

    @Override
    public void remove() {
        System.out.print("Enter code to Remove: ");
        String code = sc.nextLine();
        if (find(code) == -1) {
            System.out.println("No item with that code to remove");
            return;
        } else {
            int i = find(code);
            list.remove(i);
            System.out.println("Removed");
        }
    }

    @Override
    public void update() {
        System.out.print("Enter code to Update: ");
        String code = sc.nextLine();
        if (find(code) == -1) {
            System.out.println("No item with that code to update");
            return;
        } else {
            int i = find(code);
            Clock obj = new Clock();
            obj.setCode(list.get(i).getCode());
            System.out.print("Make: ");
            obj.setMake(sc.nextLine());
            try {
                System.out.print("Size: ");
                obj.setSize(Integer.parseInt(sc.nextLine()));
                System.out.print("Price: ");
                obj.setPrice(Integer.parseInt(sc.nextLine()));
                if (obj.getSize() < 0 || obj.getPrice() < 0) {
                    System.out.println("Input Error");
                    return;
                }

            } catch (Exception e) {
                System.out.println("Input Error");
                return;
            }
            list.set(i, obj);
            System.out.println("Updated");
        }
    }

    @Override
    public void sort() {
        Collections.sort(list, new ClockComparator());
    }

    @Override
    public void output() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).printClock();
        }
        if (list.isEmpty()) {
            System.out.println("No clock inside");
        }
    }

}

class ClockComparator implements Comparator<Clock> {

    @Override
    public int compare(Clock t, Clock t1) {
        int price = t.getPrice();
        int price1 = t1.getPrice();

        if (price > price1) {
            return 1;
        }
        if (price < price1) {
            return -1;
        }
        return 0;
    }
}
