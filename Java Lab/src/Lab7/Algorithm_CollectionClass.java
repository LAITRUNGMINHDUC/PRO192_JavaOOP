/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Henry
 */
public class Algorithm_CollectionClass {

    public static void main(String args[]) {
        ArrayList ar = new ArrayList();
        Vector v = new Vector();
        Random rd = new Random();
        for (int i = 1; i <= 10; i++) {
            ar.add(rd.nextInt(30));
            v.add(rd.nextInt(30));
        }
        System.out.println("AR = " + ar);
        System.out.println("V = " + v);

        boolean dis = Collections.disjoint(ar, v);
        System.out.println("AR and V are disjoint: " + dis);

        Collections.addAll(v, ar.toArray());
        System.out.println("After adding, V = " + v);

        int minVal = (int) Collections.min(v);
        int maxVal = (int) Collections.max(v);
        System.out.println("Min = " + minVal + " - Max = " + maxVal);

        int fre = Collections.frequency(v, 8);
        System.out.println("Occurence of 8: " + fre);

        Collections.sort(v);
        System.out.println("After sort, V = " + v);

        int pos = Collections.binarySearch(v, 8);
        System.out.println("Position of 8: " + pos);

        Collections.shuffle(v);
        System.out.println("After suffling, V = " + v);
    }
}
