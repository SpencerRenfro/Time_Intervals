/*
Spencer Renfro
12-7-2024
Project 4: Time Interval Checker
 */

package com.example.week8project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Project4Controller {
    @FXML
    private TextField timeIntervalTextFieldStart1;
    @FXML
    private TextField timeIntervalTextFieldStart2;
    @FXML
    private TextField timeIntervalTextFieldEnd1;
    @FXML
    private TextField timeIntervalTextFieldEnd2;
    @FXML
    private TextField timeIntervalTextField;
    @FXML
    private Button compareIntervalsButton;
    @FXML
    private Button checkTimeButton;
    @FXML
    private TextField resultLabel;

    private int parseTimeToMinutes(String timeText) throws InvalidTime {
        timeText = timeText.trim().toLowerCase();
        String[] parts = timeText.split("[:\\s]+");

        if (parts.length != 3) {
            throw new InvalidTime("Invalid time format. Use HH:MM:AM.");
        }
        try {
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            String meridian = parts[2];

            // Validate hours and minutes
            if (hours < 1 || hours > 12) {
                throw new InvalidTime("Hours must be between 1 and 12 for AM/PM format.");
            }
            if (minutes < 0 || minutes > 59) {
                throw new InvalidTime("Minutes must be between 0 and 59.");
            }
            if (!meridian.equals("am") && !meridian.equals("pm")) {
                throw new InvalidTime("Meridian must be 'AM' or 'PM'.");
            }
            // Convert hours to 24-hour format
            if (meridian.equals("pm") && hours != 12) {
                hours += 12; // Add 12 for PM hours (except 12 PM, which remains the same)
            } else if (meridian.equals("am") && hours == 12) {
                hours = 0; // 12 AM is midnight
            }

            System.out.println("total minutes: " + (hours * 60 + minutes));
            return hours * 60 + minutes;
        } catch (NumberFormatException e) {
            throw new InvalidTime("Invalid time values. Use numbers for hours and minutes.");
        }
    }

    @FXML
    private void handleCompareIntervals(ActionEvent event) {
        try {
            // Parse input times
            int start1 = parseTimeToMinutes(timeIntervalTextFieldStart1.getText());
            int end1 = parseTimeToMinutes(timeIntervalTextFieldEnd1.getText());
            int start2 = parseTimeToMinutes(timeIntervalTextFieldStart2.getText());
            int end2 = parseTimeToMinutes(timeIntervalTextFieldEnd2.getText());



            // Create Interval objects
            Interval interval1 = new Interval(start1, end1);
            Interval interval2 = new Interval(start2, end2);

            String result;
            // Compare intervals using Interval methods

            if (interval1.subinterval(interval2)) {
                result = "Interval 1 is a subinterval of Interval 2";
            } else if (interval2.subinterval(interval1)) {
                result = "Interval 2 is a subinterval of Interval 1";
            } else if (interval1.overlaps(interval2)) {
                result = "The intervals overlap";
            } else {
                result = "The intervals are disjoint";
            }

            resultLabel.setText(result);
            System.out.println(result);
        } catch (InvalidTime e) {
            resultLabel.setText("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCheckTime(ActionEvent event) {
        try {
            // Parse input times
            int start1 = parseTimeToMinutes(timeIntervalTextFieldStart1.getText());
            int end1 = parseTimeToMinutes(timeIntervalTextFieldEnd1.getText());
            int start2 = parseTimeToMinutes(timeIntervalTextFieldStart2.getText());
            int end2 = parseTimeToMinutes(timeIntervalTextFieldEnd2.getText());
            int timeToCheck = parseTimeToMinutes(timeIntervalTextField.getText());

            // Create Interval objects
            Interval interval1 = new Interval(start1, end1);
            Interval interval2 = new Interval(start2, end2);

            // Check if the time is within the intervals
            String result;
            boolean inInterval1 = interval1.within(timeToCheck);
            boolean inInterval2 = interval2.within(timeToCheck);

            if (inInterval1 && inInterval2) {
                result = "Both intervals contain the time.";
            } else if (inInterval1) {
                result = "Only interval 1 contains the time.";
            } else if (inInterval2) {
                result = "Only interval 2 contains the time.";
            } else {
                result = "Neither interval contains the time.";
            }

            resultLabel.setText(result);
            System.out.println(result);
        } catch (InvalidTime e) {
            resultLabel.setText("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}



