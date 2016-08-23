/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2;

import java.util.Scanner;

/**
 *
 * @author Henry
 */
public class Ex1_Fibo_Prime {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int n = Integer.parseInt(sc.nextLine());

        System.out.print("Primes: ");
        for (int i = 2; i <= n; i++) {
            if (Prime(i) == true) {
                System.out.format("%3d", i);
            }
        }

        System.out.println();

        System.out.print("Fibo: ");
        for (int i = 1; i <= n; i++) {
            System.out.format("%3d", Fibo(i));
        }
    }

    static int Fibo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return Fibo(n - 1) + Fibo(n - 2);
        }
    }

    static boolean Prime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
