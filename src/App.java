public class App {
    public static void main(String[] args) throws Exception {
        Fraction first = Fraction.getFraction("Enter the first fraction");
        Fraction second = Fraction.getFraction("Enter the second fraction");

        System.out.println("First fraction is: " + first.getNumerator() + "/" + first.getDenominator());
        System.out.println("Second fraction is: " + second.getNumerator() + "/" + second.getDenominator());

        System.out.println("sum is " + first.plus(second));
        System.out.println("difference is " + first.minus(second));
        System.out.println("product is " + first.times(second));
        System.out.println("quotient is " + first.dividedBy(second));
    }
}
