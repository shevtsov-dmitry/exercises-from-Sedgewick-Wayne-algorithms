package chapter1.section2;

import edu.princeton.cs.algs4.Counter;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q10 {

    public static void main(String[] args) {
        VisualCounter visualCounter = new VisualCounter(32,22);
        while(visualCounter.notViolatingCondition()){
            visualCounter.increment();
            visualCounter.print();
        }

    }


}

class VisualCounter {
    final private int N; // amount of maximum possible operations.
    final private int max; // maximum allowed number.
    private int currentNumber = 0;
    private int currentAmountOfOperations = 0;
    public VisualCounter(int n, int max) {
        N = n;
        this.max = max;
    }

    public int increment() {
        currentAmountOfOperations++;
        return ++currentNumber;
    }

    public int decrement() {
        currentAmountOfOperations++;
        return ++currentNumber;
    }

    public void print(){
        System.out.println("N = " + N);
    }
    public boolean notViolatingCondition() {
        if (currentAmountOfOperations >= N) {
            System.out.println(STR. "counter cannot count more than max value: \{ currentAmountOfOperations }" );
            return false;
        }
        if(currentNumber >= max){
            System.out.println(STR."counter reached maximum possible number: \{currentNumber}");
        }

        return true;
    }

}
