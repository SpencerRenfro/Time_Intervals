package com.example.week8project4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Project4 extends Application {

    @Override
    public void start(Stage stage) {

            // Create the GridPane layout
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(10));

            // Create labels
            Label startTimeLabel = new Label("Start Time");
            Label endTimeLabel = new Label("End Time");
            Label timeInterval1Label = new Label("Time Interval 1");
            Label timeInterval2Label = new Label("Time Interval 2");
            Label timeToCheckLabel = new Label("Time to Check");

            // Create text fields
            TextField timeIntervalTextFieldStart1 = new TextField();
            TextField timeIntervalTextFieldEnd1 = new TextField();
            TextField timeIntervalTextFieldStart2 = new TextField();
            TextField timeIntervalTextFieldEnd2 = new TextField();
            TextField timeIntervalTextField = new TextField();
            TextField resultLabel = new TextField();
            resultLabel.setEditable(false);

            // Create buttons
            Button compareIntervalsButton = new Button("Compare Intervals");
            Button checkTimeButton = new Button("Check Time");

            // Add components to the grid
            grid.add(startTimeLabel, 1, 0);
            grid.add(endTimeLabel, 2, 0);

            grid.add(timeInterval1Label, 0, 1);
            grid.add(timeIntervalTextFieldStart1, 1, 1);
            grid.add(timeIntervalTextFieldEnd1, 2, 1);

            grid.add(timeInterval2Label, 0, 2);
            grid.add(timeIntervalTextFieldStart2, 1, 2);
            grid.add(timeIntervalTextFieldEnd2, 2, 2);

            grid.add(compareIntervalsButton, 0, 3, 3, 1);

            grid.add(timeToCheckLabel, 0, 4);
            grid.add(timeIntervalTextField, 1, 4, 2, 1);

            grid.add(checkTimeButton, 0, 5, 3, 1);
            grid.add(resultLabel, 0, 6, 3, 1);


        // Add button actions
        compareIntervalsButton.setOnAction(event -> {
            try {
                // Parse input times
                int start1 = parseTimeToMinutes(timeIntervalTextFieldStart1.getText());
                int end1 = parseTimeToMinutes(timeIntervalTextFieldEnd1.getText());
                int start2 = parseTimeToMinutes(timeIntervalTextFieldStart2.getText());
                int end2 = parseTimeToMinutes(timeIntervalTextFieldEnd2.getText());

                // Create Interval objects
                Interval interval1 = new Interval(start1, end1);
                Interval interval2 = new Interval(start2, end2);

                // Compare intervals
                String result;
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
            } catch (InvalidTime e) {
                resultLabel.setText("Error: " + e.getMessage());
            }
        });

        checkTimeButton.setOnAction(event -> {
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
            } catch (InvalidTime e) {
                resultLabel.setText("Error: " + e.getMessage());
            }
        });

        // Create the scene and show the stage
        Scene scene = new Scene(grid, 600, 400);
        stage.setTitle("Time Interval Checker");
        stage.setScene(scene);
        stage.show();
    }

    private int parseTimeToMinutes(String timeText) throws InvalidTime {
        timeText = timeText.trim().toLowerCase();
        String[] parts = timeText.split("[:\\s]+");

        if (parts.length != 3) {
            throw new InvalidTime("Invalid time format. Use HH:MM AM/PM.");
        }
        try {
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            String meridian = parts[2];

            if (hours < 1 || hours > 12) {
                throw new InvalidTime("Hours must be between 1 and 12.");
            }
            if (minutes < 0 || minutes > 59) {
                throw new InvalidTime("Minutes must be between 0 and 59.");
            }
            if (!meridian.equals("am") && !meridian.equals("pm")) {
                throw new InvalidTime("Meridian must be 'AM' or 'PM'.");
            }

            if (meridian.equals("pm") && hours != 12) {
                hours += 12;
            } else if (meridian.equals("am") && hours == 12) {
                hours = 0;
            }

            return hours * 60 + minutes;
        } catch (NumberFormatException e) {
            throw new InvalidTime("Invalid time values.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
