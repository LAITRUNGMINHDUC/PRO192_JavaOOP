/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

import java.util.Arrays;

/**
 *
 * @author Henry
 */
public class Generic_Arrray {

    public static void main(String args[]) {
        Integer a[] = {1, 2, 3, 4, 5};
        GenericArray obj1 = new GenericArray();
        obj1.output(a);
        System.out.println(GenericArray.get(3, a));

        Double b[] = {1.2, 3.4, 5.6, 3.7};
        GenericArray<Double> obj2 = new GenericArray<>();
        obj2.output(b);

        String list[] = {"hello", "World"};
        GenericArray<String> obj3 = new GenericArray<>();
        obj3.output(list);
        obj3.sort(list);
        obj3.output(a);
    }
}

class GenericArray<T> {

    public static <T> T get(int i, T[] ar) {
        return ar[i];
    }

    public static <T> void output(T[] ar) {
        for (T x : ar) {
            System.out.print(x + ", ");
        }
        System.out.println();
    }

    public static <T> void sort(T[] ar) {
        Arrays.sort(ar);
    }
}
