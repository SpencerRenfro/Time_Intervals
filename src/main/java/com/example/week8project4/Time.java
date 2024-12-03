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

    // the parameter for this constructor should take use the format:
    // hours, minutes, meridian and constructs a Time object
    public Time(int hours, int minutes, String meridian) throws InvalidTime {
        if (inputValidation(hours, minutes, meridian)) {
            this.hours = hours;
            this.minutes = minutes;
            this.meridian = meridian;
        } else {
            throw new InvalidTime("Invalid time format1");
        }
    }

    public Time(String stringFormatTime) {
        // the parameter for this constructor should take use the format:
        //HH:MM AM and constructs a Time object
        if (inputValidation(stringFormatTime)) {
            String[] timeArray = stringFormatTime.split(":");
            this.hours = Integer.parseInt(timeArray[0]);
            this.minutes = Integer.parseInt(timeArray[1]);
            this.meridian = timeArray[2];

        }
    }

    public Time(String interval1StartHours, String interval1StartMinutes, String interval1StartMeridian) {
    }

    //    A method compareTo that compares two times and returns what is required of all such
//    methods that implement the Comparable interface
    public static void compareTo() {

    }

    /*This method is for this requirement:
* When either constructor is called, several checks need to be made on the input. For both
constructors, a check is needed to ensure that the hours and minutes are within range and that
the meridian is AM or PM. For the constructor that accepts the string representation, additional
checks are needed to ensure that the hours and minutes are numeric values. Should any check
fail, an exception InvalidTime should be thrown that includes the reason.
* */
    public Boolean inputValidation(int hours, int minutes, String meridian) {
        boolean isValid = false;
        try {
            if (hours < 0 || hours > 12) {
                throw new InvalidTime("Hours must be between 0 and 12");
            }
            if (minutes < 0 || minutes > 59) {
                throw new InvalidTime("Minutes must be between 0 and 59");
            }
            if (!meridian.equalsIgnoreCase("AM") && !meridian.equalsIgnoreCase("PM")) {
                throw new InvalidTime("Meridian must be AM or PM");
            }
            isValid = true;
        } catch (InvalidTime e) {
            System.out.println(e.getMessage());
        }
        return isValid;
    }

    public Boolean inputValidation(String stringInput) {
        // call inputValidation() and then extend logic
        boolean isValid = false;
        try {

            String[] timeArray = stringInput.split(":");
            inputValidation(Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1]), timeArray[2]);
            isValid = true;
        } catch (Exception e) {
            System.out.println("Invalid time format_inboolean-string");
        }
        return isValid;
    }


    //A method toString that returns the string representation of the time in the format
    //HH:MM AM
    @Override
    public String toString() {
        String stringFormat = String.valueOf(hours) + ":" + String.valueOf(minutes) + " " + meridian;
        return stringFormat;
    }
}

/*
The second class Time should contain two integer instance variables that represent the hours and
minutes and one additional variable for the meridian, AM or PM. The class should implement
the Comparable interface and should be immutable, so it should have no setter methods. At a
minimum, it should contain the following public methods:
 A constructor that accepts the hours and minutes as integers and the meridian as a string
and constructs a Time object
 A constructor that accepts a string representation of a time in the format HH:MM AM
and constructs a Time object
 A method compareTo that compares two times and returns what is required of all such
methods that implement the Comparable interface
 A method toString that returns the string representation of the time in the format
HH:MM AM

When either constructor is called, several checks need to be made on the input. For both
constructors, a check is needed to ensure that the hours and minutes are within range and that
the meridian is AM or PM. For the constructor that accepts the string representation, additional
checks are needed to ensure that the hours and minutes are numeric values. Should any check
fail, an exception InvalidTime should be thrown that includes the reason.
*
*
* */
