package chapter1.section1;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Q32 {
    public static int amountOfElements = 15;
    public static int[] intervals = new int[5];

    static void addToInterval(double num) {
        if (num >= 0 && num < 0.2) intervals[0]++;
        else if (num >= 0.2 && num < 0.4) intervals[1]++;
        else if (num >= 0.4 && num < 0.6) intervals[2]++;
        else if (num >= 0.6 && num < 0.8) intervals[3]++;
        else intervals[4]++;
    }

    static void drawHistogram() {
        // draw field
        StdDraw.setCanvasSize(1000, 500);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        // draw blocks
        int x = 15;
        int iteratorForText1 = 0;
        int iteratorForText2 = 2;
        int sizeOfHalf = 7;
        double spaceBetween = sizeOfHalf * 2;
        for (int interval : intervals) {
            int matches = 0;
//             Set histogram columns titles
            StdDraw.text(x, 5, "%d-%d".formatted(iteratorForText1, iteratorForText2));
            iteratorForText1 += 2;
            iteratorForText2 += 2;
            // Set histogram row titles
            // Draw blocks
            int y = 15;
            for (int j = 0; j < interval; j++) {
                matches++;
                StdDraw.square(x, y, sizeOfHalf);
                y += spaceBetween;
            }
            // display matches above histogram
            StdDraw.text(x, y, "matches: %d".formatted(matches));
            x += spaceBetween;
        }
    }

    public static void main(String[] args) {
        double[] arrayOfRandomNumbers = new double[15];
        for (int i = 0; i < arrayOfRandomNumbers.length; i++) {
            arrayOfRandomNumbers[i] = Math.random();
        }
        Arrays.stream(arrayOfRandomNumbers).forEach(Q32::addToInterval);
        System.out.println("intervals = " + Arrays.toString(intervals));
        drawHistogram();
    }
}
