/*
Spencer Renfro
12-7-2024
Project 4: Time Interval Checker
 */

package com.example.week8project4;

/*
The first class should be a generic class Interval defined for any
type that implements the Comparable interface.
Objects of this type have a start and end of the generic type parameter that defines
the start and end of the interval.
The class should be immutable, so it should have no setter methods. At a minimum, it should
contain the following public methods:
* A constructor that accepts the start and end of an interval and constructs an Interval object
* A method within that is supplied an object of the generic type parameter and returns
    whether that object is inside the interval, including the endpoints
* A method subinterval that is passed an interval as a parameter and returns whether the
    interval parameter is a subinterval, completely within, the interval on which the method is invoked
*A method overlaps that is passed an interval as a parameter and returns whether the
    interval parameter overlaps the interval on which the method is invoked
*/
public class Interval {

    private final Comparable start;
    private final Comparable end;


    public Interval(Comparable start, Comparable end) throws InvalidTime {
        if(start.compareTo(end) > 0) {
            throw new InvalidTime("Start must be less than or equal to end.");
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
