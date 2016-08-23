/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Henry
 */
public class EmployeeList {

    private Employee list[];
    private int count = 0;
    static Scanner sc = new Scanner(System.in);

    public EmployeeList(int size) {
        if (size < 1) {
            size = 100;
        }
        list = new Employee[size];
    }

    void readFile() {
        try {
            File f = new File("Employees.txt");
            if (!f.exists()) {
                return;
            }

            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String details = "";

            while ((details = br.readLine()) != null) {
                String Temp[] = details.split(";");
                Employee obj = new Employee();
                obj.setID(Temp[0]);
                obj.setName(Temp[1]);
                obj.setAddress(Temp[2]);
                obj.setSalary(Double.parseDouble(Temp[3]));
                obj.setAllowance(Double.parseDouble(Temp[4]));
                if (!(obj.getID().isEmpty())) {
                    list[count++] = obj;
                }
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Error input file.");
            //e.printStackTrace();
            return;
        }
    }

    void addEmployee() {
        Employee obj = new Employee();
        System.out.println();
        try {
            System.out.print("ID: ");
            String ID = sc.nextLine().trim().toUpperCase();
            obj = inputEmploy(ID);
        } catch (Exception e) {
            System.out.println("Error input.");
            return;
        }

        if (obj.getID().isEmpty()) {
            System.out.println("Error input.");
            return;
        }

        if (findID(obj.getID()) > -1) {
            System.out.println("Duplicate ID");
            return;
        }

        list[count++] = obj;
        System.out.println("Added");

    }

    int findID(String ID) {
        for (int i = 0; i < count; i++) {
            if (list[i].getID().equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    void searchEmployee() {
        System.out.println();
        System.out.print("Enter ID to search: ");
        String ID = sc.nextLine().trim().toUpperCase();
        int pos = findID(ID);
        if (pos > -1) {
            list[pos].printEmployee();
        } else {
            System.out.println("No employee with that code");
        }
    }

    void deleteEmployee() {
        System.out.println();
        System.out.print("Enter ID to delete: ");
        String ID = sc.nextLine().trim().toUpperCase();
        int pos = findID(ID);
        if (pos > -1) {
            for (int i = pos; i < count; i++) {
                list[pos] = list[pos + 1];
            }
            System.out.println("Deleted");
            count = count - 1;
        } else {
            System.out.println("No employee with that code");
        }
    }

    static Employee inputEmploy(String ID) {
        Employee obj = new Employee();
        obj.setID(ID);
        System.out.print("Name: ");
        obj.setName(sc.nextLine().trim().toUpperCase());
        System.out.print("Address: ");
        obj.setAddress(sc.nextLine().trim().toUpperCase());
        System.out.print("Salary: ");
        obj.setSalary(Double.parseDouble(sc.nextLine()));
        System.out.print("Allowance: ");
        obj.setAllowance(Double.parseDouble(sc.nextLine()));
        return obj;
    }

    void updateEmployee() {
        System.out.println();
        System.out.print("Enter ID to update: ");
        String ID = sc.nextLine().trim().toUpperCase();
        int pos = findID(ID);
        if (pos > -1) {
            Employee obj = new Employee();
            obj = inputEmploy(ID);
            list[pos] = obj;
            System.out.println("Updated");
        } else {
            System.out.println("No employee with that code");
        }
    }

    void printList() {
        System.out.println();
        for (int i = 0; i < count; i++) {
            list[i].printEmployee();
        }
    }

    void printListByIncomes() {
        System.out.println();
        System.out.println("Enter range (R1 R2) for exporting Incomes: ");
        String Temp[] = sc.nextLine().split(" ");
        if (Temp.length != 2) {
            System.out.println("Error Input");
            return;
        }

        double R1, R2;
        try {
            R1 = Double.parseDouble(Temp[0]);
            R2 = Double.parseDouble(Temp[1]);
        } catch (Exception e) {
            System.out.println("Error Input");
            return;
        }

        for (int i = 0; i < count; i++) {
            double incomes = list[i].getAllowance() + list[i].getSalary();
            if (incomes >= R1 && incomes <= R2) {
                list[i].printEmployee();
            }
        }
    }

    void exportFile() {
        System.out.println("Exit");
        try {
            File f = new File("Employees.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
                        
            for (int i = 0; i<count; i++) {
                Employee x = list[i];
                pw.println(x.getID() + ";" + x.getName() + ";" + x.getAddress() + ";" + x.getSalary() + ";" + x.getAllowance());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Can't write file.");
            e.printStackTrace();
            return;
        }
    }
}
