/*
Spencer Renfro
12-7-2024
Project 4: Time Interval Checker
 */
package com.example.week8project4;

public class Time implements Comparable<Time>{
    private int hours;
    private int minutes;
    private String meridian;

    public Time(int hours, int minutes, String meridian) throws InvalidTime {

        if(validateHoursMinutesFormat(hours, minutes) && validateMeridian(meridian)) {
            this.hours = hours;
            this.minutes = minutes;
            this.meridian = meridian.toUpperCase();
        }
    }

    public Time(String stringFormatTime) throws InvalidTime {

        String[] parts = stringFormatTime.split("[:\\s]+");

        if(parts.length != 3) {
            throw new InvalidTime("Invalid time format. Expected format: HH:MM AM.");
        }


        try {
            // Parse hours and minutes
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            String meridian = parts[2].toUpperCase();

            // Validate hours, minutes, and meridian
            if (validateHoursMinutesFormat(h, m) && validateMeridian(meridian)) {
                this.hours = h;
                this.minutes = m;
                this.meridian = meridian;
            }
        } catch (NumberFormatException e) {
            throw new InvalidTime("Invalid time format. Hours and minutes must be integers.");
        }
    }


    public boolean validateHoursMinutesFormat(int h, int m) throws InvalidTime {
        if (h < 1 || h > 12) {
            throw new InvalidTime("Hours must be between 1 and 12.");
        }
        if (m < 0 || m > 59) {
            throw new InvalidTime("Minutes must be between 0 and 59.");
        }

        return true;
    }
    public boolean validateMeridian(String meridian) throws InvalidTime {
        if (!meridian.equalsIgnoreCase("AM") && !meridian.equalsIgnoreCase("PM")) {
            throw new InvalidTime("Meridian must be AM or PM.");
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(hours) + ":" + String.valueOf(minutes) + " " + meridian;
    }

    @Override
    public int compareTo(Time other) {
        int thisTotalMinutes = (this.hours % 12) * 60 + this.minutes + (this.meridian.equals("PM") ? 720 : 0);
        int otherTotalMinutes = (other.hours % 12) * 60 + other.minutes + (other.meridian.equals("PM") ? 720 : 0);
        return Integer.compare(thisTotalMinutes, otherTotalMinutes);
    }
}
