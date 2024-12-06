package com.example.week8project4;

/*
Spencer Renfro Project4: Time Interval Checker
Date: 12-5-2024
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class ViewController {
    @FXML
    private TextField timeIntervalTextFieldStart1;
    @FXML
    private TextField timeIntervalTextFieldStart2;
    @FXML
    private TextField timeIntervalTextFieldEnd1;
    @FXML
    private TextField timeIntervalTextFieldEnd2;
    @FXML
    private Button compareIntervalsButton;
    @FXML
    private Button checkTimeButton;


    @FXML
    protected void compareIntervalsButton(ActionEvent event) {

        String interval1Start = timeIntervalTextFieldStart1.getText();
        String interval1End = timeIntervalTextFieldEnd1.getText();
        String interval2Start = timeIntervalTextFieldStart2.getText();
        String interval2End = timeIntervalTextFieldEnd2.getText();

        String[] interval1StartHoursMinutes = interval1Start.split(":");
        String[] interval1EndHoursMinutes = interval2Start.split(":");
        String[] interval2StartHoursMinutes = interval1End.split(":");
        String[] interval2EndHoursMinutes = interval2End.split(":");

        System.out.println("button clicked");
        System.out.println(interval1Start + " " + interval1End);
        System.out.println(interval2Start + " " + interval2End);

        //Check user input for HH:MM AM/PM format

        // Split by colon or whitespace

        String[] parts = interval1Start.split("[:\\s]+");
        // parts[0] is the hour
        // parts[1] is the minute
        // parts[2] is the AM/PM
        String interval1StartHours = parts[0];
        String interval1StartMinutes = parts[1];
        String interval1StartMeridian = parts[2];
        String interval1EndHours = parts[0];
        String interval1EndMinutes = parts[1];
        String interval1EndMeridian = parts[2];

        String interval2StartHours = parts[0];
        String interval2StartMinutes = parts[1];
        String interval2StartMeridian = parts[2];
        String interval2EndHours = parts[0];
        String interval2EndMinutes = parts[1];
        String interval2EndMeridian = parts[2];

        // Validate the input

        try{
            int interval1StartIntHours = Integer.parseInt(interval1StartHours);
            int interval1StartIntMinutes = Integer.parseInt(interval1StartMinutes);

        } catch (NumberFormatException e) {
            System.out.println("Could not convert input to integer: please enter an integer");
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
//        Time interval1StartObject = new Time(interval1StartHours, interval1StartMinutes, interval1StartMeridian);


    }


}
