import java.util.InputMismatchException;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator){
        if(denominator == 0){
            throw new IllegalArgumentException("denominator 0 is invalid");
        }
        else if (denominator < 0){
            this.denominator = denominator*(-1);
            this.numerator = numerator*(-1);
        }
        else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Fraction(int numerator){
        this(numerator,1);
    }

    public Fraction(){
        this(0);
    }

    public int getNumerator(){
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString(){
        return numerator + "/" + denominator;
    }

    public double toDouble(){
        return numerator/denominator;
    }

    private static int gcd (int numerator, int denominator){
        while (numerator!=0&&denominator!=0){
            int remainder = numerator%denominator;
            numerator = denominator;
            denominator = remainder;
        }
        return numerator;
    }

    private void toLowestTerms(){
        int gcd = gcd(this.numerator,this.denominator);
        numerator = this.numerator/gcd;
        denominator = this.denominator/gcd;
    }

    public Fraction add(Fraction other){
        Fraction newFraction = new Fraction((this.denominator*other.numerator)+this.numerator*other.denominator,(this.denominator*other.denominator));
        newFraction.toLowestTerms();
        return newFraction;
    }

    public Fraction subtract(Fraction other) {
        Fraction newFraction = new Fraction((this.denominator*other.numerator)-this.numerator*other.denominator,(this.denominator*other.denominator));
        newFraction.toLowestTerms();
        return newFraction;
    }

    public Fraction multiply(Fraction other) {
        Fraction newFraction = new Fraction((this.numerator*other.numerator),(this.denominator*other.denominator));
        newFraction.toLowestTerms();
        return newFraction;
    }

    public Fraction divide(Fraction other) {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }
        else {
            Fraction newFraction = new Fraction((this.numerator*other.denominator),(this.denominator*other.numerator));
            newFraction.toLowestTerms();
            return newFraction;
        }
    }

    public boolean equals (Object other) {
        if (other instanceof Fraction) {
            Fraction otherNew = (Fraction) other;
            otherNew.toLowestTerms();

            Fraction thisFraction = new Fraction(this.numerator,this.denominator);
            thisFraction.toLowestTerms();
            return (thisFraction.numerator == otherNew.numerator)&&(thisFraction.denominator == otherNew.denominator);
        }
        else {
            throw new InputMismatchException("Fraction expected");
        }
    }
}
