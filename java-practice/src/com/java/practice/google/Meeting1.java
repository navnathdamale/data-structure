package com.java.practice.google;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [s1, e1], [s2, e2], ... ,
 * determine if a person could attend all meetings.
 * <p>
 * For example,
 * Given [ [0, 30], [5, 10], [15, 20] ],
 * return false.
 */
public class Meeting1 {

    public static void main(String[] args) {
        //Interval[] intervals = {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        Interval[] intervals = {new Interval(2, 4), new Interval(1, 14), new Interval(4, 20)};
        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return false;
        }

        Arrays.sort(intervals, Comparator.comparingInt(e -> e.start));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1].start < intervals[i].end) {
                return false;
            }
        }
        return true;
    }
}

class Interval {
    public int start;
    public int end;

    public Interval() {
        this.start = 0;
        this.end = 0;
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
