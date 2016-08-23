/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

import java.util.Collection;
import java.util.Vector;

/**
 *
 * @author Henry
 */
public class Generic_Wildcard {

    public Generic_Wildcard() {
    }

    static public void print1(Collection<?> col) {
        for (Object o : col) {
            System.out.print(o + " ,");
        }
    }

    static public void print2(Collection<? extends A> col) {
        for (Object o : col) {
            System.out.print(o + " ,");
        }
    }

    static public void print3(Collection<? super B> col) {
        for (Object o : col) {
            System.out.print(o + " ,");
        }
    }

    public static void main(String args[]) {
        Vector VA = new Vector();
        VA.add(new A());
        VA.add(new A());
        VA.add(new A());

        Vector VB = new Vector();
        VB.add(new B());
        VB.add(new B());
        VB.add(new B());

        Vector VC = new Vector();
        VC.add(new C());
        VC.add(new C());
        VC.add(new C());

        Generic_Wildcard.print1(VC);
        System.out.println();
        Generic_Wildcard.print2(VB);
        System.out.println();
        Generic_Wildcard.print3(VA);
        System.out.println();
        Generic_Wildcard.print2(VC);
        System.out.println();
    }

}

class A {

    int a = 3;

    public String toString() {
        return "" + a;
    }
}

class B extends A {

    int b = 5;

    public String toString() {
        int b = 5;
        return "" + (a + b);
    }
}

class C {

    int c = 10;

    public String toString() {
        return "" + c;
    }
}
