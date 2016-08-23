/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

/**
 *
 * @author Henry
 */
public class Fraction {

    int numerator;
    int denominator;

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator != 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        } else {
            this.numerator = 0;
            this.denominator = 1;
        }
    }

    Fraction add(Fraction f) {
        int newDenominator = this.denominator * f.denominator;
        int newNumerator = this.numerator * f.denominator + this.denominator * f.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    Fraction sub(Fraction f) {
        int newDenominator = this.denominator * f.denominator;
        int newNumerator = this.numerator * f.denominator - this.denominator * f.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    Fraction mul(Fraction f) {
        int newDenominator = this.denominator * f.denominator;
        int newNumerator = this.numerator * f.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    Fraction div(Fraction f) {
        int newDenominator = this.denominator * f.numerator;
        int newNumerator = this.numerator * f.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    int GCD(int a, int b) {
        if (a == 0) {
            return 1;
        }
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }

        while (a != b) {
            if (a > b) {
                a = a - b;
            }
            if (a < b) {
                b = b - a;
            }
        }
        return a;
    }

    void simplify() {
        int GCD = GCD(this.numerator, this.denominator);
        this.numerator = this.numerator / GCD;
        this.denominator = this.denominator / GCD;

        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }        
    }

    void optimize() {
        //this.simplify();
    }

    String printFraction(Fraction f) {
        String S;
        f.simplify();
        S = "" + f.numerator + "/" + f.denominator;
        return S;
    }

}
