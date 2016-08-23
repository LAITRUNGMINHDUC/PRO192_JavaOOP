/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

import java.util.Scanner;

/**
 *
 * @author Henry
 */
public class PersonList {

    //Properties
    private Person[] list;
    private int count = 0;

    //Constructor
    public PersonList(int size) {
        if (size < 10) {
            size = 10;
        }
        list = new Person[size];
    }

    //Method
    int find(String aCode) {
        for (int i = 0; i < count; i++) {
            if (aCode.equals(list[i].getCode())) {
                return i;
            }
        }
        return -1;
    }

    public void add() {
        if (count == list.length) {
            System.out.println("List is full");
        } else {
            String newCode, newName;
            int newAge;

            Scanner sc = new Scanner(System.in);
            int pos;
            do {
                System.out.print("Enter the person's code: ");
                newCode = sc.nextLine().toUpperCase();
                pos = find(newCode);
                if (pos >= 0) {
                    System.out.println("\tThis code existed.");
                }
            } while (pos >= 0);

            System.out.print("Enter the person's name: ");
            newName = sc.nextLine().toUpperCase();
            System.out.print("Enter the person's age: ");
            newAge = Integer.parseInt(sc.nextLine());
            list[count++] = new Person(newCode, newName, newAge);
            System.out.println("Added");

        }
    }

    public int checkEmpty() {
        if (count == 0) {
            System.out.println("Empty");
            return 0;
        }
        return 1;
    }

    public void remove() {
        if (checkEmpty() == 0) {
            return;
        }
        String removedCode;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter code to remove: ");
        removedCode = sc.nextLine().toUpperCase();
        int pos = find(removedCode);
        if (pos < 0) {
            System.out.println("Doesn't exist");
        } else {
            for (int i = pos; i <= count - 1; i++) {
                list[i] = list[i + 1];                                
            }
            count--;
            System.out.println("Remove OK");
        }
    }

    public void update() {
        if (checkEmpty() == 0) {
            return;
        }
        String code;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the code of Updated person: ");
        code = sc.nextLine().toUpperCase();
        int pos = find(code);
        if (pos < 0) {
            System.out.println("This person does not exisit.");
        } else {
            String newName;
            int newAge;
            System.out.print("Name: ");
            newName = sc.nextLine().toUpperCase();
            System.out.print("Age: ");
            newAge = Integer.parseInt(sc.nextLine());
            list[pos].setName(newName);
            list[pos].setAge(newAge);
            System.out.println("Updated");
        }
    }

    public void print() {
        if (checkEmpty() == 0) {
            return;
        }
        System.out.println("List: ");
        for (int i = 0; i<count; i++) {
            System.out.println(list[i].toString());
        }
    }

    public void sort() {
        if (checkEmpty() == 0) {
            return;
        }
        for (int i = 0; i < count - 1; i++) {
            for (int j = count - 1; j > i; j--) {
                if (list[j].getAge() > list[i].getAge()) {
                    Person p = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = p;
                }
            }
        }
    }

}
