package chapter1.section2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Q3 {

    public static final List<Interval2D> GENERATED_INTERVALS = new ArrayList<>();
    public static final List<Point2D> INTERVALS_COORDINATES = new ArrayList<>();
    public static final int AMOUNT_OF_GENERATED_2_D_INTERVALS = 5;

    public static void main(String[] args) {

        createField();

        drawIntervalsOnField(); // also adds generated intervals and its coordinates into lists

        checkTaskConditions(); // introspects and contains

    }

    private static void checkTaskConditions() {
        int pairsIntersects = 0;
        int pairsContains = 0;

        for (int i = 0; i < GENERATED_INTERVALS.size(); i++) {
            Interval2D cur = GENERATED_INTERVALS.get(i);
            for (int j = i + 1; j < GENERATED_INTERVALS.size(); j++) {
                Interval2D next = GENERATED_INTERVALS.get(j);
                if(cur.contains(INTERVALS_COORDINATES.get(j)))
                    pairsContains++;
                if(cur.intersects(next))
                    pairsIntersects++;
            }
        }

        printResult(pairsIntersects, pairsContains);
    }

    private static void printResult(int pairsIntersects, int pairsContains) {
        System.out.println("pairsIntersects = " + pairsIntersects);
        System.out.println("pairsContains = " + pairsContains);
    }

    private static void drawIntervalsOnField() {
        Random random = new Random();
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < AMOUNT_OF_GENERATED_2_D_INTERVALS; i++) {
            double min = random.nextDouble(74),
                    max = random.nextDouble(74);

            if (min > max) {
                double tempMin = min;
                min = max;
                max = tempMin;
            }
            Point2D point2D = new Point2D(min, max);
            INTERVALS_COORDINATES.add(point2D);

            Interval1D interval1D1 = new Interval1D(min, max);
            Interval1D interval1D2 = new Interval1D(min, max);
            Interval2D interval2D = new Interval2D(interval1D1, interval1D2);

            GENERATED_INTERVALS.add(interval2D);
            interval2D.draw();
        }
    }

    private static void createField() {
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
    }

}
