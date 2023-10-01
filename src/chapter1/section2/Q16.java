package chapter1.section2;

import java.util.Objects;

import static java.util.FormatProcessor.FMT;

public class Q16 {

    private static Rational n1 = new Rational(1, 1);
    private static Rational n2 = new Rational(1, 1);
    private static Rational n3 = new Rational(1, 1);

    public static void main(String[] args) {

        // testing code. To make test available assertions should be available.
        // It can be achieved by adding -ea or --enable-assertions to VM options
        log();
    }

    //    TESTS
    private static void checkPreparedInstances() {
        String plusResult = "";
        String minusResult = "";
        String multiplyResult = "";
        String divideResult = "";
        String[] allResults = new String[4];
        allResults[0] = plusResult;
        allResults[1] = minusResult;
        allResults[2] = multiplyResult;
        allResults[3] = divideResult;

        n1 = new Rational(1, 3);
        n2 = new Rational(2, 3);
        n3 = n1.plus(n2);
        plusResult = "6/6";

        n1 = new Rational(534, 230);
        n2 = new Rational(409232, 2582);
        n3 = n1.plus(n2);
        plusResult = "23875537/148465";

        n1 = new Rational(0, 1);
        n2 = new Rational(3, 10);
        n3 = n1.plus(n2);
        plusResult = "0/1";

        n1 = new Rational(-23, 423);
        n2 = new Rational(32, 1);
        n3 = n1.plus(n2);
        plusResult = "135123/423";

    }

    // test cases based on assertions.
    public void testExpression(String result, OperationType operationType) {
        switch (operationType) {
            case PLUS -> {
                assert Objects.equals(n3.getFraction(), result) :
                        STR. "\{ n1.getFraction() } + \{ n2.getFraction() } = \{ n3.getFraction() } (\{ n3 }), but should be equal to \{ result }" ;
            }
            case MINUS -> {
                assert Objects.equals(n3.getFraction(), result) :
                        STR. "\{ n1.getFraction() } - \{ n2.getFraction() } = \{ n3.getFraction() } (\{ n3 }), but should be equal to \{ result }" ;
            }
            case DIVIDE -> {
                assert Objects.equals(n3.getFraction(), result) :
                        STR. "\{ n1.getFraction() } / \{ n2.getFraction() } = \{ n3.getFraction() } (\{ n3 }), but should be equal to \{ result }" ;
            }
            case MULTIPLY -> {
                assert Objects.equals(n3.getFraction(), result) :
                        STR. "\{ n1.getFraction() } * \{ n2.getFraction() } = \{ n3.getFraction() } (\{ n3 }), but should be equal to \{ result }" ;
            }
        }
    }

    private static void log() {
        String log = STR. "\{ n1 } + \{ n2 } = \{ n3 }\n" ;
        log += STR. "\{ n1.getFraction() } + \{ n2.getFraction() } = \{ n3.getFraction() }" ;
        if (Double.parseDouble(n3.toString()) >= 1) {
            log += STR. "\{ n3.getIntAndFraction() }" ;

            // TODO finish with parsing EX: 1(1/3)
        }
        log += STR."\n";
        System.out.println(log);
    }
}

enum OperationType {
    PLUS,
    MINUS,
    DIVIDE,
    MULTIPLY
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
        System.out.println(en);
        return new Rational(en, commonDeno);
    }

    public String getFraction() {
        return FMT. "\{ this.enumerator }/\{ this.denominator }" ;
    }

    public String getIntAndFraction() {
        long partEnumerator = this.enumerator % this.denominator;
        return STR. "\{ this.enumerator / this.denominator }(\{ partEnumerator }/\{ this.denominator })" ;
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
        if (a == b) return a * 2;
        for (long i = 1; i <= a / 2; i++) {
            if ((double) a / i == b)
                return i;
        }
        return a * b;
    }


}
