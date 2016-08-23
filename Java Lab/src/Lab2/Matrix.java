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
public class Matrix {

    public static void main(String args[]) {
        int nRow;
        int nCollumn;
        int matArray[][];
        int Sum = 0;
        double Avg = 0.0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows:");
        nRow = Integer.parseInt(sc.nextLine());
        System.out.print("Enter number of collumns:");
        nCollumn = Integer.parseInt(sc.nextLine());

        matArray = new int[nRow][nCollumn];

        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCollumn; j++) {
                System.out.print("mArray[" + i + "][" + j + "] = ");
                matArray[i][j] = Integer.parseInt(sc.nextLine());
                Sum = Sum + matArray[i][j];                
            }
        }

        System.out.println("Matrix inputted:");
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCollumn; j++) {
                System.out.format("%3d", matArray[i][j]);
            }
            System.out.println();
        }

        System.out.println("Sum: " + Sum);
        Avg = (double) Sum / (nRow * nCollumn);
        System.out.println("Average: " + Avg);
    }
}
