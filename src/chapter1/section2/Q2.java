package chapter1.section2;

import edu.princeton.cs.algs4.Interval1D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Q2 {

    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        final int N = 5;
        final int maxGeneratedValue = 20;
        // generate @N pairs of similar
        List<Interval1D> intervals = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            Interval1D interval = generateInterval(maxGeneratedValue);
            intervals.add(interval);
        }

        int foundOccurencies = 0;
        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval1D currentInterval = intervals.get(i);
            for (int j = i + 1; j < intervals.size(); j++) {
                Interval1D nextInterval = intervals.get(j);

                if(currentInterval.intersects(nextInterval)){
                    foundOccurencies++;
                    System.out.printf("%d. introspected pair %s and %s%n",
                            foundOccurencies, currentInterval.toString(), nextInterval.toString());

                }
            }
        }

    }

    private static Interval1D generateInterval(int maxGeneratedValue) {
        double startValue = RANDOM.nextDouble(maxGeneratedValue);
        double endValue = RANDOM.nextDouble(maxGeneratedValue);
        // swap generated values if beginning > end
        if (startValue > endValue) {
            double storedOldValue = startValue;
            startValue = endValue;
            endValue = storedOldValue;
        }
        return new Interval1D(startValue, endValue);

    }
}
