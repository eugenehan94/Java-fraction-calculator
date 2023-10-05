import java.util.Scanner;

class Fraction {

    private int num;
    private int den;

    static Scanner sc = new Scanner(System.in);

    public Fraction() {
        // Create an object representing 0/1.
        num = 0;
        den = 1;
    }

    public Fraction(int num, int den) {
        // Create an object whose value is n/d.
        this.num = num;
        this.den = den;
    }

    public Fraction(Fraction f) {
        // Create an object identical to the parameter f
        num = f.num;
        den = f.den;
    }

    public Fraction plus(Fraction other) {
        // Create and return a Fraction object with value: this + other
        Fraction result = new Fraction(num * other.den + den * other.num, den * other.den);
        result.reduce();
        return result;
    }

    public Fraction minus(Fraction other) {
        // Create and return a Fraction object with value: this - other
        Fraction result = new Fraction(num * other.den - den * other.num, den * other.den);
        result.reduce();
        return result;
    }

    public Fraction times(Fraction other) {
        // Create and return a Fraction object with value: this * other
        Fraction result = new Fraction(num * other.num, den * other.den);
        result.reduce();
        return result;
    }

    public Fraction dividedBy(Fraction other) {
        // Create and return a Fraction object with value: this / other
        Fraction result = new Fraction(num * other.den, den * other.num);
        result.reduce();
        return result;
    }

    public static Fraction getFraction(String prompt) {
        // Prompt the use for the fields of a fraction and
        // return a new Fraction object (in reduced form).

        Fraction result = new Fraction();
        System.out.println(prompt);
        System.out.println("numerator: ");
        result.num = sc.nextInt();
        System.out.println("denominator: ");
        result.den = sc.nextInt();
        return result;
    }

    public String toString() {
        // Return a string representing the implicit Fraction object.
        // If the object represents an undefined or indeterminate value,
        // return an appropriate string.

        if (den != 0) {
            return num + "/" + den;
        } else if (num == 0) {
            return "NaN";
        } else if (num > 0) {
            return "Infinity";
        } else {
            return "-Infinity";
        }
    }

    public int getNumerator() {
        // An accessor method for the numerator field
        return num;
    }

    public int getDenominator() {
        // An accessor method for the denominator field
        return den;
    }

    public boolean equals(Fraction other) {
        // Return true if and only if the fields of the implicit
        // Fraction object are identical to those of other

        return other != null && num == other.num && den == other.den;
    }

    public double size() {
        // Return the magnitude of a Fraction object
        return Math.abs((double) num / den);
    }

    private void reduce() {
        // Reduce the implicit Fraction object to lowest terms and ensures
        // that the denominator is not negative.

        // eliminates negative denominator
        if (den < 0) {
            den *= -1;
            num *= -1;
        }

        // store zero as 0/1
        if (num == 0 && den != 0) {
            den = 1;
        }

        // store infinities as 1/0 or -1/0
        if (den == 0 && num != 0)
            if (num > 0)
                num = 1;
            else
                num = -1;

        // eliminate any common factors in num and den fields
        for (int i = Math.min(Math.abs(num), den); i >= 2; i--)
            if (num % i == 0 && den % i == 0) {
                num /= i;
                den /= i;
            }
    }

}
