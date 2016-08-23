/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import java.util.Scanner;

/**
 *
 * @author Henry
 */
public class FractionDemo {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int numerator, denominator;
        
        System.out.print("Enter numerator of the first fraction: ");
        numerator = Integer.parseInt(sc.nextLine());
        System.out.print("Enter denominator of the first fraction: ");
        denominator = Integer.parseInt(sc.nextLine());
        Fraction A = new Fraction(numerator, denominator);
        
        System.out.print("Enter numerator of the second fraction: ");
        numerator = Integer.parseInt(sc.nextLine());
        System.out.print("Enter denominator of the second fraction: ");
        denominator = Integer.parseInt(sc.nextLine());
        Fraction B = new Fraction(numerator, denominator);
        
        System.out.println("Sum of them: " + A.printFraction(A.add(B)));
        System.out.println("Subtract of them: " + A.printFraction(A.sub(B)));
        System.out.println("Mul. of them: " + A.printFraction(A.mul(B)));
        System.out.println("Div. of them: " + A.printFraction(A.div(B)));
    }
}
