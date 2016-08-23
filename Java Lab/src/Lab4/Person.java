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
public class Person {

    //Properties
    private String code = "";
    private String name = "";
    private int age = 0;

    //Constructors
    public Person() {
    }

    public Person(String code, String name, int age) {
        this.code = code;
        this.name = name;
        this.age = age > 0 ? age : 0;
    }

    //Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //Input details of the person
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Person's code: ");
        this.code = sc.nextLine();
        System.out.print("Enter the Person's name: ");
        this.name = sc.nextLine();
        System.out.print("Enter the Person's age: ");
        this.age = Integer.parseInt(sc.nextLine());
    }

    //Method for output
    @Override
    public String toString() {
        return code + ", " + name + ", " + age;
    }
}
