package chapter1.section2;

import edu.princeton.cs.algs4.Date;

import java.util.HashMap;
import java.util.Map;

public class Q11 {
    // develop illegal date
    public static void main(String[] args) {
        SmartDate smartDate = new SmartDate(26, 9, 2023);

        System.out.println(STR. "today is \{ smartDate.toString() } and it is \{ smartDate.dayOfWeek() }" );

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

    public String dayOfWeek(){
        Map<Integer, String> daysOfWeek = new HashMap<>();
        daysOfWeek.put(1,"Monday");
        daysOfWeek.put(2,"Tuesday");
        daysOfWeek.put(3,"Wednesday");
        daysOfWeek.put(4,"Thursday");
        daysOfWeek.put(5,"Friday");
        daysOfWeek.put(6,"Saturday");
        daysOfWeek.put(7,"Sunday");
//        день_недели = (год + (месяц - 1) * 12 + день) % 7
        int dayOfWeek = (year + (month - 1) * 12 + day) % 7;

        return  daysOfWeek.get(dayOfWeek);

    }
}