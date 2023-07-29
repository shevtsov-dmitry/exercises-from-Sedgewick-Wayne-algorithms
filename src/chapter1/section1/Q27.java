package chapter1.section1;

public class Q27 {
    /*
        1.1.27 Binomial distribution. Estimate the number of recursive calls that would be
        used by the code
        public static double binomial(int N, int k, double p)
        {
            if ((N == 0) || (k < 0)) return 1.0;
            return (1.0 - p)*binomial(N-1, k) + p*binomial(N-1, k-1);
        }
        to compute binomial(100, 50). Develop a better implementation that is based on
        saving computed values in an array.
    */
    public static double binomial(int N, int k, double p) {
        if ((N == 0) && (k == 0)) return 1.0;
        if ((N < 0) || (k < 0)) return 0.0;
        return (1 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    public static void main(String[] args) {
        binomial(100, 50, 0.25);


    }
}
