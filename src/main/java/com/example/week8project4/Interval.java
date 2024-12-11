/*
Spencer Renfro
12-7-2024
Project 4: Time Interval Checker
 */

package com.example.week8project4;

public class Interval {

    private final Comparable start;
    private final Comparable end;


    public Interval(Comparable start, Comparable end) throws InvalidTime {
        if(start.compareTo(end) >= 0) {
            throw new InvalidTime("Start time must be before end time.");
        }
        this.start = start;
        this.end = end;
    }

    public boolean within(Comparable obj) {
        return obj.compareTo(start) >= 0 && obj.compareTo(end) <= 0;
    }

    public boolean subinterval(Interval interval) {
        return interval.start.compareTo(start) >= 0 && interval.end.compareTo(end) <= 0;
    }

    public boolean overlaps(Interval interval) {
        return interval.start.compareTo(end) <= 0 && interval.end.compareTo(start) >= 0;
    }
}