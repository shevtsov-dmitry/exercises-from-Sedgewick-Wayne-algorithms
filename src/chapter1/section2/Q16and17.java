package chapter1.section2;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.FormatProcessor.FMT;

public class Q16and17 {
    private static Rational n1 = new Rational(1, 1);
    private static Rational n2 = new Rational(1, 1);
    private static Rational n3 = new Rational(1, 1);

    public static void main(String[] args) {
        // testing code. To make test available assertions should be available.
        // It can be achieved by adding -ea or --enable-assertions to VM options
        checkPreparedInstances();
    }

    //    TESTS
    private static void checkPreparedInstances() {
        String plusResult = "";
        String multiplyResult = "";
        String minusResult = "";
        String divideResult = "";

        // 1/3 2/3
        n1 = new Rational(1, 3);
        n2 = new Rational(2, 3);
        n3 = n1.plus(n2);

        plusResult = "1";
        multiplyResult = "2/9";
        minusResult = "-1/3";
        divideResult = "1/2";
        testOperations(plusResult, multiplyResult, minusResult, divideResult);

        // 34/4234 34
        n1 = new Rational(34, 4234);
        n2 = new Rational(34, 1);
        n3 = n1.plus(n2);

        plusResult = "71995/2117";
        multiplyResult = "578/2117";
        minusResult = "-71961/2117";
        divideResult = "1/4234";
        testOperations(plusResult, multiplyResult, minusResult, divideResult);

        // 0/1 3/10
        n1 = new Rational(0, 1);
        n2 = new Rational(3, 10);
        n3 = n1.plus(n2);

        plusResult = "1/5";
        multiplyResult = "0";
        minusResult = "-3/10";
        divideResult = "0";
        testOperations(plusResult, multiplyResult, minusResult, divideResult);

        // -23/423 32/1
        n1 = new Rational(-23, 423);
        n2 = new Rational(32, 1);
        n3 = n1.plus(n2);

        plusResult = "13513/423";
        multiplyResult = "-736/423";
        minusResult = "-13559/423";
        divideResult = "-23/13536";
        testOperations(plusResult, multiplyResult, minusResult, divideResult);

    }

    private static void testOperations(String plusResult, String multiplyResult, String minusResult, String divideResult) {
        testExpression(plusResult, OperationType.PLUS);
        testExpression(multiplyResult, OperationType.MULTIPLY);
        testExpression(minusResult, OperationType.MINUS);
        testExpression(divideResult,OperationType.DIVIDE);
    }

    // test cases based on assertions.
    private static void testExpression(String result, OperationType operationType) {
        switch (operationType) {
            case PLUS -> {
                assert Objects.equals(n3.getResult(), result) :
                        STR. "\{ n1.getResult() } + \{ n2.getResult() } = " +
                                STR. "\{ n3.getResult() } (\{ n3 }), but should be equal to \{ result }" ;
            }
            case MINUS -> {
                assert Objects.equals(n3.getResult(), result) :
                        STR. "\{ n1.getResult() } - \{ n2.getResult() } = " +
                                STR. "\{ n3.getResult() } (\{ n3 }), but should be equal to \{ result }" ;
            }
            case DIVIDE -> {
                assert Objects.equals(n3.getResult(), result) :
                        STR. "\{ n1.getResult() } / \{ n2.getResult() } = " +
                                STR. "\{ n3.getResult() } (\{ n3 }), but should be equal to \{ result }" ;
            }
            case MULTIPLY -> {
                assert Objects.equals(n3.getResult(), result) :
                        STR. "\{ n1.getResult() } * \{ n2.getResult() } = " +
                                STR. "\{ n3.getResult() } (\{ n3 }), but should be equal to \{ result }" ;
            }
        }
    }

    private static void log() {
        String log = STR. "\{ n1 } + \{ n2 } = \{ n3 }\n" ;
        log += STR. "\{ n1.getFraction() } + \{ n2.getFraction() } = \{ n3.getFraction() }" ;
        if (Double.parseDouble(n3.toString()) >= 1) {
            log += STR. "\{ n3.getMixedFraction() }" ;

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
    private static AtomicLong atomicDivisor;

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

    // * PLUS
    public Rational plus(Rational b) {
        long lcd = lcd(this.denominator, b.denominator);
        long en = (lcd / this.denominator) * this.enumerator +
                (lcd / b.denominator) * b.enumerator;
        return new Rational(en, lcd);
    }

    // * MULTIPLY
    public Rational multiply(Rational b) {
        return new Rational(this.enumerator * b.enumerator, this.denominator * b.denominator);
    }

    // * DIVIDE

    public String getFraction() {
        long en = this.enumerator;
        long de = this.denominator;
        // reduce fraction rules
        long commonDivisor = findCommonDivisorForBothNumbers(Math.min(en, de), Math.max(en, de), de);
        System.out.println("en = " + en);
        System.out.println("de = " + de);
        System.out.println("commonDivisor = " + commonDivisor);
        en /= commonDivisor;
        de /= commonDivisor;
        return STR. "\{ en }/\{ de }" ;
    }

     public String getResult(){
        if(this.enumerator == this.denominator)
            return "1";
        else if(this.enumerator == 0)
            return "0";
         return getFraction();
     }

    public String getMixedFraction() {
        if(this.enumerator > this.denominator){
            long partEnumerator = this.enumerator % this.denominator;
            long difference = this.enumerator * partEnumerator - this.denominator;
            return STR."\{partEnumerator} (\{difference}/\{this.denominator})";
        }
        else {
            return STR."Impossible to get mixed fraction with \{getFraction()}";
        }
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
        if (a < b) {
            long holdB = b;
            b = a;
            a = holdB;
        } else if (a == b)
            return a;

        final Optional<Long> commonDivisor = findCommonDivisor(a, b);
        if (commonDivisor.isPresent())
            return commonDivisor.get();
        else
            return a * b;
    }

    private static Optional<Long> findCommonDivisor(long a, long b) {
        for (long i = a / 2 + 1; i > 0; i--) { // backwards
            if ((double) a / i == b) {
                return Optional.of(i);
            } else if (i < b) {
                break;
            }
        }
        return Optional.empty();
    }


    private static long findCommonDivisorForBothNumbers(long min, long max, long de) {
//        System.out.println(STR. "\{max} and \{ de } and \{ min }" );
        if (min == 1) {
            return 1;
        } else if ((double) max / min % 2 == 1 && (double) de / min % 2 == 1) { // for example with 4 and 2 here is 2 / 2 % 2 != 1
            return min;
        } else {
            return findCommonDivisorForBothNumbers(min - 1, max, de);
        }
    }


}
