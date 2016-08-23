
import java.util.Vector;
import java.io.*;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class BookList extends Vector <Book>{
    Scanner sc= new Scanner(System.in);
    public void loadBookFromFile(String fName) {
        if (this.size()>0) this.clear();
        try {
            File f= new File(fName);
            if (!f.exists()) return;
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            Book b;
            while ((b =(Book)(fo.readObject()))!= null) {
                this.add(b);
            }
            fo.close();fi.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void saveToFile(String fName) {
        if (this.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        try {
            FileOutputStream f = new FileOutputStream(fName);
            ObjectOutputStream fo = new ObjectOutputStream(f);
            for (Book x:this) fo.writeObject(x);
            fo.close();f.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void addNewBook() {
        String title; int price = 0;
        System.out.println("Enter new book details:");
        System.out.print("title: ");
        title = sc.nextLine();
        boolean check = false;
        do {
            try {
                System.out.print("price:");
                check = true;
                price = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(e);
                check = false;
            }
        } while (!check);
        this.add(new Book(title,price));
        System.out.println("Added new book");
    }
    
    public void print() {
        if (this.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        System.out.println("\nNEW ITEM LIST");
        System.out.println("---------------------------");
        for (Book x:this) x.print();
    }
    
    
}