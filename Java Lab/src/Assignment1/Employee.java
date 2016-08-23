/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

/**
 *
 * @author Henry
 */
public class Employee {

    private String ID;
    private String name;
    private String address;
    private double salary;
    private double allowance;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        String regex = "[E][0-9]{3}";
        if (ID.matches(regex)) {
            this.ID = ID;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!ID.isEmpty()) {
            this.name = name;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (!ID.isEmpty()) {
            this.address = address;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (!ID.isEmpty()) {
            this.salary = salary;
        }
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        if (!ID.isEmpty()) {
            this.allowance = allowance;
        }
    }

    public void printEmployee() {
        System.out.println();
        System.out.println("ID: " + this.ID);
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Salary: " + this.salary);
        System.out.println("Allowance: " + this.allowance);
    }
    
}
