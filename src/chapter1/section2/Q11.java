package chapter1.section2;

import edu.princeton.cs.algs4.Date;

public class Q11 {
    // develop illegal date
    public static void main(String[] args) {
        SmartDate date = new SmartDate(28, 5, 2002);
        System.out.println(date.toString());
    }

}

class SmartDate extends Date {

    private int day;
    private int month;
    private int year;

    public SmartDate(int day, int month, int year) {
        super(month, day, year);

        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        String dayString = String.valueOf(day);
        String monthString = String.valueOf(month);
        String yearString = String.valueOf(year);

        if(day < 10){
            dayString = STR."0\{dayString}";
        }
        if(month < 10) {
            monthString = STR."0\{monthString}";
        }

        return STR."\{dayString}.\{monthString}.\{yearString}";
    }
}