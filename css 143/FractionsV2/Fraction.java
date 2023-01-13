import java.util.*;
import java.io.*;
public class Fraction {
    private int numerator, denominator;

    public Fraction() {

    }

    public Fraction(int num, int den) {

    }


    public int getNumerator() {
        return this.numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Fraction))
            return false;
        Fraction fraction = (Fraction) o;
        return this.numerator == fraction.numerator && this.denominator == fraction.denominator;
    }
}