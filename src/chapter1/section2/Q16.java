package chapter1.section2;

import static java.util.FormatProcessor.FMT;

public class Q16 {
    public static void main(String[] args) {
//        Rational n1 = new Rational(3, 11);
//        Rational n2 = new Rational(11, 9);

        Rational n1 = new Rational(1, 33);
        Rational n2 = new Rational(11, 3);
        Rational n3 = n1.plus(n2);

        String log = STR. "\{ n1 } + \{ n2 } = \{ n3 }\n";
        log +=STR. "\{ n1.getFraction() } + \{ n2.getFraction() } = \{ n3.getFraction() }" ;
        if(Double.parseDouble(n3.toString()) >= 1) {
            log += STR."\{n3.getIntAndFraction()}";

            // TODO finish with parsing EX: 1(1/3)
        }
        log+= STR."\n";
        System.out.println(log);
    }
}

class Rational {

    private final long enumerator;
    private final long denominator;

    public Rational(long enumerator) {
        this.enumerator = enumerator;
        this.denominator = 1;
    }

    public Rational(long enumerator, long denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("You can't divide by 0");
        }
        this.enumerator = enumerator;
        this.denominator = denominator;
    }

    public Rational plus(Rational b) {
        long commonDeno = lcd(this.denominator, b.denominator);
        long en = ((commonDeno / this.denominator) * this.enumerator) +
                ((commonDeno / b.denominator) * b.enumerator);
        return new Rational(en, commonDeno);
    }

    public String getFraction() {
        return FMT. "\{ this.enumerator }/\{ this.denominator }" ;
    }

    public String getIntAndFraction(){
        long partEnumerator = this.enumerator % this.denominator;
        return STR."\{this.enumerator/this.denominator}(\{partEnumerator}/\{this.denominator})";
    }

    public long getEnumerator() {
        return enumerator;
    }

    public long getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return FMT. "%.2f\{ (double) this.enumerator / this.denominator }" ;
    }

    public static long gcd(long p, long q) {
        if (q == 0) return p;
        long r = p % q;
        return gcd(q, r);
    }

    public static long lcd(long a, long b) {
        for (long i = 1; i <= a / 2; i++) {
            if ((double) a / i == b)
                return i;
        }
        return a * b;
    }
}
