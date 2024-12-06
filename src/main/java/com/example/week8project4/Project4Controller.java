/*
Spencer Renfro Project4: Time Interval Checker
Date: 12-5-2024
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
    private Button CompareIntervals;
    @FXML
    private Button CheckTime;
    @FXML
    private TextField resultLabel;



    @FXML
    private void handleCompareIntervals(ActionEvent event) throws InvalidTime {

        Time start1 = null, start2 = null, end1 = null, end2 = null;
        String result = "";

        try {
            start1 = new Time(timeIntervalTextFieldStart1.getText());
            start2 = new Time(timeIntervalTextFieldStart2.getText());
            end1 = new Time(timeIntervalTextFieldEnd1.getText());
            end2 = new Time(timeIntervalTextFieldEnd2.getText());
        } catch (InvalidTime e) {
            e.printStackTrace();
        }

        // validate start time is before end time
        if (start1 != null && end1 != null && start1.compareTo(end1) >= 0) {
            throw new InvalidTime("Error in TIme Interval 1 Start and End times: Start time must be before end time.");
        }
        if (start2 != null && end2 != null && start2.compareTo(end2) >= 0) {
            throw new InvalidTime("Error in TIme Interval 2 Start and End times: Start time must be before end time.");
        }

        if (start1.compareTo(start2) >= 0 && end1.compareTo(end2) <= 0) {
            result = "Interval 1 is a sub-interval of Interval 2";
        } else if (start2.compareTo(start1) >= 0 && end2.compareTo(end1) <= 0) {
            result = "Interval 2 is a sub-interval of Interval 1";
        } else if (start1.compareTo(end2) <= 0 && end1.compareTo(start2) >= 0) {
            result = "The intervals overlap";
        } else {
            result = "The intervals are disjoint";
        }
        resultLabel.setText(result);
        System.out.println(result);

    };
}
