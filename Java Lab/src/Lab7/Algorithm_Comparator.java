/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Henry
 */
public class Algorithm_Comparator {

    public static void main(String args[]) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("01", "ABC", 52230));
        list.add(new Employee("02", "def", 98235));
        list.add(new Employee("05", "KKK", 25246));

        System.out.println("Sort ID ASC: ");
        Collections.sort(list);

    }
}

class Employee implements Comparable {

    String ID = "";
    String Name = "";
    int Salary = 0;

    public Employee(String id, String n, int s) {
        ID = id;
        Name = n;
        Salary = s;
    }

    @Override
    public String toString() {
        return ID + ", " + Name + ", " + Salary;
    }

    @Override
    public int compareTo(Object emp) {
        return ID.compareTo(((Employee) emp).ID);
    }

    public static Comparator compareObj = new Comparator() {
        @Override
        public int compare(Object t, Object t1) {
            Employee emp1 = (Employee) t;
            Employee emp2 = (Employee) t1;

            int d = emp1.Salary - emp2.Salary;
            if (d > 0) {
                return -1;
            }
            if (d == 0) {
                return emp1.ID.compareTo(emp2.ID);
            }

            return 1;
        }
    };
}
