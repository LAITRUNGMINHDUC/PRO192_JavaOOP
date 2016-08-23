/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Henry
 */
public class EmpList extends Vector<Employee> {

    Scanner sc = new Scanner(System.in);

    public EmpList() {
        super();
    }

    public void AddFromFile(String fName) {
        try {
            File f = new File(fName);
            if (!f.exists()) {
                return;
            }

            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);

            String details;

            while ((details = bf.readLine()) != null) {
                String[] split = details.split(",");
                String code = split[0].trim().toUpperCase();
                String name = split[1].trim().toUpperCase();
                int salary = Integer.parseInt(split[2].trim().toUpperCase());

                Employee emp = new Employee(code, name, salary);
                this.add(emp);
            }

            bf.close();
            fr.close();
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
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);

            for (Employee x : this) {
                pw.println(x.getCode() + ", " + x.getName() + ", " + x.getSalary());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private int find(String aCode) {
        for (Employee x : this) {
            if (x.getCode().equals(aCode)) {
                return this.indexOf(x);
            }
        }
        return -1;
    }

    public void addNewEmp() {
        String newCode, newName;
        int newSalary;
        int pos;
        boolean valid = true;

        System.out.println("Enter new Emp.");
        do {
            System.out.print("Code: ");
            newCode = sc.nextLine().toUpperCase();
            pos = find(newCode);
            valid = newCode.matches("^E\\d{3}$");
            if (pos >= 0) {
                System.out.println("Duplicate code.");
            }
            if (!valid) {
                System.out.println("Wrong format: E and 3 digits.");
            }
        } while (pos >= 0 || !valid);

        System.out.print("Name: ");
        newName = sc.nextLine().toUpperCase();
        System.out.print("Salary: ");
        try {
            newSalary = Integer.parseInt(sc.nextLine());
            if (newSalary < 0) {
                System.out.println("Error Input.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error Input.");
            return;
        }

        this.add(new Employee(newCode, newName, newSalary));
        System.out.println("Added.");

    }

    public void removeEmp() {
        String code;
        System.out.print("Enter code to remove Emp: ");
        code = sc.nextLine().toUpperCase().trim();
        int pos = find(code);
        if (pos < 0) {
            System.out.println("No Emp with that code");
            return;
        } else {
            this.remove(pos);
            System.out.println("Removed");
        }
    }

    public void promote() {
        String code;
        System.out.print("Enter code to promote salary: ");
        code = sc.nextLine().trim().toUpperCase();

        int pos = find(code);
        if (pos < 0) {
            System.out.println("Doesn't exist");
        } else {
            int oldSalary = this.get(pos).getSalary();
            int newSalary;
            do {
                System.out.print("Old salary: " + oldSalary + ", new Salary: ");
                try {
                    newSalary = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Error input.");
                    return;
                }
            } while (newSalary < oldSalary);
            this.get(pos).setSalary(newSalary);
            System.out.println("Salary updated.");
        }
    }

    public void print() {
        if (this.isEmpty()) {
            System.out.println("Empty");
            return;
        }

        Collections.sort(this);
        System.out.println("\nEmp List: ");
        System.out.println("\n----------------");
        for (Employee x : this) {
            x.print();
        }
    }
}
