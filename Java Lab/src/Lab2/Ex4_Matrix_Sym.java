/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Henry
 */
public class Ex4_Matrix_Sym {

    static int matrix[][];
    static int n;

    public static void main(String args[]) {
        System.out.print("N = ");
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        matrix = new int[n][n];

        Data1();
        printMatrix();
        System.out.println("Vertical: " + Vertical());
        System.out.println("Horizontal: " + Horizontal());
        
        Data2();
        printMatrix();
        System.out.println("Vertical: " + Vertical());
        System.out.println("Horizontal: " + Horizontal());
    }

    static boolean Vertical() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                if (matrix[i][j] != matrix[i][n - j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean Horizontal() {
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[n - i - 1][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void printMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.format("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    static void Data1() {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                matrix[i][j] = matrix[i][n - j - 1] = rand.nextInt(9) + 1;
            }
        }
    }

    static void Data2() {
        Random rand = new Random();
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix[n - i - 1][j] = rand.nextInt(9) + 1;
            }
        }
    }
}
