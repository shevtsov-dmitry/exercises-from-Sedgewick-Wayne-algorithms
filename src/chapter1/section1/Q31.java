package chapter1.section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Q31 {
    public static void main(String[] args) {
//        TODO take input from Scanner
        int N = 5;

        final int canvasSize = 500;
        // set canvas
        StdDraw.setCanvasSize(canvasSize, canvasSize);
        StdDraw.setXscale(0,100);
        StdDraw.setYscale(0,100);

        // choose paint color
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        // draw circle
        double circleRadius = 30;
        double circleSideLength = 50;
        StdDraw.filledCircle(circleSideLength,circleSideLength, circleRadius);

        // draw lines
        StdDraw.setPenColor(StdDraw.GREEN);
        double center = 50D;
        double pointRadius = 0.5D;

        double x = center + 15, y = center;
        double val = 21.2 / N;

        for (int i = 0; i < N; i++) {
            // declare random value between 0 and 1
            double p = Math.random();
            // connect points 50% chance
            double invertX = 100-x, invertY = 100-y;
            if(p > 0.5){
                StdDraw.line(x,y,invertX,invertY);
            }
            // draw points
            StdDraw.filledCircle(x,y,pointRadius);
            x-= val;
            y-= val;
            StdDraw.filledCircle(invertX,invertY,pointRadius);

        }
    }

}
