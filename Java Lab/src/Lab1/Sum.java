/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

/**
 *
 * @author Henry
 */
public class Sum {
    public static void main (String args[])
    {
        double Sum = 0;
        for (String x : args)
        {
            Sum = Sum + Double.parseDouble(x);
        }
        System.out.println(Sum);
    }
}