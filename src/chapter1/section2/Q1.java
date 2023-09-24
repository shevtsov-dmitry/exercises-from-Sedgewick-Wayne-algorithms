package chapter1.section2;


import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* Write a Point2D client that takes an integer value N from the command line,
 generates N random points in the unit square, and computes the distance separating
the closest pair of points.
*/
public class Q1 {

    public static final int AMOUNT_OF_POINTS = 7;
    private static final int FIELD_LENGTH = 500;
    public static final List<Point2D> EACH_POINT_COORDINATES = new ArrayList<>();
    public static final double[][] XY = new double[2][2];
    private static double shortestPathLength = Double.MAX_VALUE;

    public static void main(String[] args) {
        createField();
        drawPoints();
        findShortestPathBetweenPoints();
        drawConnectingLineBetweenShortestWay();
    }

    private static void createField() {
        // set canvas
        StdDraw.setCanvasSize(FIELD_LENGTH, FIELD_LENGTH);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);

    }

    private static void drawConnectingLineBetweenShortestWay() {
        double x1 = XY[0][0],
                y1 = XY[0][1],
                x2 = XY[1][0],
                y2 = XY[1][1];

        StdDraw.setPenColor(Color.GREEN);
        StdDraw.line(x1,y1,x2,y2);

        writeTextBlockShortestPath(x2,y2);
    }

    private static void writeTextBlockShortestPath(double x2, double y2) {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(x2 + 3,y2 + 3, "%.3f".formatted(shortestPathLength));
    }

    private static void findShortestPathBetweenPoints() {

        for (int i = 0; i < EACH_POINT_COORDINATES.size(); i++) {
            for (int j = i + 1; j < EACH_POINT_COORDINATES.size(); j++) {
                double pathLength = EACH_POINT_COORDINATES.get(i).distanceTo(EACH_POINT_COORDINATES.get(j));
                if (pathLength <= shortestPathLength) {

                    shortestPathLength = pathLength;
                    assignXY(i, j);

                }
            }
        }
    }

    private static void assignXY(int i, int j) {
        XY[0][0] = EACH_POINT_COORDINATES.get(i).x();
        XY[0][1] = EACH_POINT_COORDINATES.get(i).y();
        XY[1][0] = EACH_POINT_COORDINATES.get(j).x();
        XY[1][1] = EACH_POINT_COORDINATES.get(j).y();
    }

    private static void drawPoints() {
        StdDraw.setPenColor(Color.BLACK);
        Random random = new Random();
        for (int i = 0; i < AMOUNT_OF_POINTS; i++) {
            Point2D coords = new Point2D(
                    random.nextDouble(100),
                    random.nextDouble(100)
            );
            StdDraw.filledCircle(coords.x(), coords.y(), 1);
            EACH_POINT_COORDINATES.add(coords);
        }
    }
}
