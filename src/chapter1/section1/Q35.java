package chapter1.section1;

import java.util.Arrays;

public class Q35 {
    public static void main(String[] args) {
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;
        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;

        for (double v : dist) {
            var s = String.format("v = %f",v);
            System.out.println(s);
        }
    }
}
