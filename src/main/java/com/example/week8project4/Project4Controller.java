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

    private Time[] getTimeIntervals(boolean timeIntervalFields, boolean timeToCheckField) throws InvalidTime {
        Time start1 = null, start2 = null, end1 = null, end2 = null;

        if (timeIntervalFields) {
            start1 = new Time(timeIntervalTextFieldStart1.getText());
            start2 = new Time(timeIntervalTextFieldStart2.getText());
            end1 = new Time(timeIntervalTextFieldEnd1.getText());
            end2 = new Time(timeIntervalTextFieldEnd2.getText());
            return new Time[]{start1, start2, end1, end2};
        }

        if (timeToCheckField) {
            Time timeToCheck = new Time(timeIntervalTextField.getText());
            return new Time[]{timeToCheck};
        }

        throw new InvalidTime("No valid fields provided for parsing.");
    }

    private void validateInput(Time start1, Time start2, Time end1, Time end2) throws InvalidTime {

        if (start1.compareTo(end1) >= 0) {
            throw new InvalidTime("In Interval 1: Start time must be before end time.");
        }
        if (start2.compareTo(end2) >= 0) {
            throw new InvalidTime("In Interval 2: Start time must be before end time.");
        }


    }

    @FXML
    private void handleCompareIntervals(ActionEvent event) {
        try {
            // Get and validate time intervals
            Time[] times = getTimeIntervals(true, false);
            validateInput(times[0], times[1], times[2], times[3]);

            // Compare intervals
            String result;
            if (times[0].compareTo(times[1]) >= 0 && times[2].compareTo(times[3]) <= 0) {
                result = "Interval 1 is a sub-interval of Interval 2";
            } else if (times[1].compareTo(times[0]) >= 0 && times[3].compareTo(times[2]) <= 0) {
                result = "Interval 2 is a sub-interval of Interval 1";
            } else if (times[0].compareTo(times[3]) <= 0 && times[2].compareTo(times[1]) >= 0) {
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
            // Get time intervals and time to check
            Time[] times = getTimeIntervals(true, true);
            validateInput(times[0], times[1], times[2], times[3]);

            Time timeToCheck = new Time(timeIntervalTextField.getText());

            // Check if time is within intervals
            String result;
            boolean inInterval1 = timeToCheck.compareTo(times[0]) >= 0 && timeToCheck.compareTo(times[2]) <= 0;
            boolean inInterval2 = timeToCheck.compareTo(times[1]) >= 0 && timeToCheck.compareTo(times[3]) <= 0;

            if (inInterval1 && inInterval2) {
                result = "Both intervals contain the time " + timeToCheck.toString();
            } else if (inInterval1) {
                result = "Only interval 1 contains the time " + timeToCheck.toString();
            } else if (inInterval2) {
                result = "Only interval 2 contains the time " + timeToCheck.toString();
            } else {
                result = "Neither interval contains the time " + timeToCheck.toString();
            }
            /*
            *
            *  Both intervals contains the time HH:MM AM
 Only interval 1 contains the time HH:MM AM
 Only interval 2 contains the time HH:MM AM
 Neither interval contains the time HH:MM AM*/

            resultLabel.setText(result);
            System.out.println(result);
        } catch (InvalidTime e) {
            resultLabel.setText("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
