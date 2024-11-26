package com.example.week8project4;

public class Time {
    int hours;
    int minutes;
    String meridian;

//    When either constructor is called, several checks need to be made on the input. For both
//    constructors, a check is needed to ensure that the hours and minutes are within range and that
//    the meridian is AM or PM. For the constructor that accepts the string representation, additional
//    checks are needed to ensure that the hours and minutes are numeric values. Should any check
//    fail, an exception InvalidTime should be thrown that includes the reason.

    public Time(int hours, int minutes, String meridian) {
        this.hours = hours;
        this.minutes = minutes;
        this.meridian = meridian;
    }

    public Time(String stringFormatTime){
        // the parameter for this constructor should take use the format:
        //HH:MM AM and constructs a Time object
    }

//    A method compareTo that compares two times and returns what is required of all such
//    methods that implement the Comparable interface
    public static void compareTo(){

    }
    //A method toString that returns the string representation of the time in the format
    //HH:MM AM
    @Override
    public String toString(){
        String stringFormat = String.valueOf(hours) + ":" + String.valueOf(minutes) + " " + meridian;
        return stringFormat;
    }
}
