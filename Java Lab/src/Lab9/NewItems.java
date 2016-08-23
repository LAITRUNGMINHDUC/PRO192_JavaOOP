/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Henry
 */
public class NewItems extends ArrayList<Item> {

    Scanner sc = new Scanner(System.in);
    ArrayList<String> storedCodes = new ArrayList<>();

    public NewItems() {
        super();
    }

    public void loadStoredCode(String fName) {
        if (storedCodes.size() > 0) {
            storedCodes.clear();
        }

        try {
            File f = new File(fName);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);

            String code;
            while ((code = bf.readLine()) != null && (bf.readLine() != null) && (bf.readLine() != null)) {
                storedCodes.add(code);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private boolean valid(String aCode) {

        for (String x : storedCodes) {
            if (aCode.equals(x)) {
                return false;
            }
        }
        for (Item x : this) {
            if (aCode.equals(x.getCode())) {
                return false;
            }
        }
        return true;
    }

    private int find(String aCode) {
        for (Item x : this) {
            if (x.getCode().equals(aCode)) {
                return this.indexOf(x);
            }
        }
        return -1;
    }

    public void appendToFile(String fName) {
        if (this.size() == 0) {
            System.out.println("Empty List");
            return;
        }

        try {
            boolean append = true;
            File f = new File(fName);
            FileWriter fw = new FileWriter(f, append);
            PrintWriter pw = new PrintWriter(fw);

            for (Item x : this) {
                pw.println(x.getCode());
                pw.println(x.getName());
                pw.println(x.getPrice());
                pw.flush();
            }

            pw.close();
            fw.close();

            this.loadStoredCode(fName);
            this.clear();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addNewItem() {
        String newCode, newName;
        int price;

        boolean duplicated = false;
        boolean matched = true;

        System.out.println("Enter new item: ");
        do {
            System.out.print("Code (I***): ");
            newCode = sc.nextLine();
            matched = newCode.matches("^I\\d{3}$");
            duplicated = !valid(newCode);

            if (duplicated) {
                System.out.println("Duplicated");
            }
            if (!matched) {
                System.out.println("Wrong Format");
            }
        } while (duplicated || !(matched));

        System.out.print("Name: ");
        newName = sc.nextLine().toUpperCase();
        System.out.print("Price: ");
        price = Integer.parseInt(sc.nextLine());

        this.add(new Item(newCode, newName, price));
        System.out.println("Added");
    }

    public void remove() {
        String code;
        System.out.print("Enter code to remove Item: ");
        code = sc.nextLine().toUpperCase().trim();
        int pos = find(code);
        if (pos < 0) {
            System.out.println("No Item with that code");
            return;
        } else {
            this.remove(pos);
            System.out.println("Removed");
        }
    }

    public void updatePrice() {
        String code;
        System.out.print("Enter code to change price: ");
        code = sc.nextLine().trim().toUpperCase();

        int pos = find(code);
        if (pos < 0) {
            System.out.println("Doesn't exist");
        } else {
            int oldPrice = this.get(pos).getPrice();
            int newPrice;
            do {
                System.out.print("Old Price: " + oldPrice + ", new Price: ");
                try {
                    newPrice = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Error input.");
                    return;
                }
            } while (newPrice != oldPrice);
            this.get(pos).setPrice(newPrice);
            System.out.println("Price updated.");
        }
    }

    public void print() {
        if (this.isEmpty()) {
            System.out.println("Empty List");
            return;
        }
        
        Collections.sort(this, new compareItems());
        
        System.out.println("\nItem List: ");
        System.out.println("\n----------------");
        
        for (Item x : this) {
            x.print();
        }
    }

}

class compareItems implements Comparator{

    @Override
    public int compare(Object t, Object t1) {
        Item i = (Item) t;
        Item i1 = (Item) t1;
        return i.getCode().compareTo(i1.getCode());
    }

}
