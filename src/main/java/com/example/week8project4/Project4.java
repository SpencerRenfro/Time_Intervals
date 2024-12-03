package com.example.week8project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
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
        grid.setHgap(5); // Horizontal gap between columns
        grid.setVgap(5); // Vertical gap between rows
        grid.setPadding(new Insets(2, 2, 2, 2));

        // Components
        Label startTimeLabel = new Label("Start Time");
        grid.setHalignment(startTimeLabel, javafx.geometry.HPos.CENTER);
        Label endTimeLabel = new Label("End Time");
        grid.setHalignment(endTimeLabel, javafx.geometry.HPos.CENTER);
        endTimeLabel.setAlignment(Pos.CENTER);
        Label timeInterval1Label = new Label("Time Interval 1");
        Label timeInterval2Label = new Label("Time Interval 2");
        Label timeToCheckLabel = new Label("Time to Check");

        TextField timeInterval1Field1 = new TextField();
        timeInterval1Field1.setAlignment(Pos.CENTER);
        TextField timeInterval1Field2 = new TextField();
        timeInterval1Field2.setAlignment(Pos.CENTER);
        TextField timeInterval2Field1 = new TextField();
        timeInterval2Field1.setAlignment(Pos.CENTER);
        TextField timeInterval2Field2 = new TextField();
        timeInterval2Field2.setAlignment(Pos.CENTER);
        TextField timeToCheckField = new TextField();
        TextField displayField = new TextField();
        displayField.setEditable(false); // display only

        Button compareIntervalsButton = new Button("Compare Intervals");
        compareIntervalsButton.setPrefHeight(25);
        compareIntervalsButton.setMaxWidth(Double.MAX_VALUE);

        Button checkTimeButton = new Button("Check Time");
        checkTimeButton.setPrefHeight(25);
        checkTimeButton.setMaxWidth(Double.MAX_VALUE);

        // Place components in the grid
        // First Row
        grid.add(new Label(""), 0, 0); // Empty column for alignment
        grid.add(startTimeLabel, 1, 0);
        grid.add(endTimeLabel, 2, 0);

        // Second Row
        grid.add(timeInterval1Label, 0, 1);
        grid.add(timeInterval1Field1, 1, 1);
        grid.add(timeInterval1Field2, 2, 1);

        // Third Row
        grid.add(timeInterval2Label, 0, 2);
        grid.add(timeInterval2Field1, 1, 2);
        grid.add(timeInterval2Field2, 2, 2);

        // Fourth Row (Compare Intervals Button spanning 3 columns)
        grid.add(compareIntervalsButton, 0, 3);
        GridPane.setColumnSpan(compareIntervalsButton, 3);

        // Fifth Row
        grid.add(timeToCheckLabel, 0, 4);
        grid.add(timeToCheckField, 1, 4);
        GridPane.setColumnSpan(timeToCheckField, 2);

        // Sixth Row (Check Time Button spanning 3 columns)
        grid.add(checkTimeButton, 0, 5);
        GridPane.setColumnSpan(checkTimeButton, 3);

        // Seventh Row (Display-only field spanning 3 columns)
        grid.add(displayField, 0, 6);
        GridPane.setColumnSpan(displayField, 3);

        // Add button logic
        compareIntervalsButton.setOnAction(event -> {
            String interval1Start = timeInterval1Field1.getText();
            String interval1End = timeInterval1Field2.getText();
            String interval2Start = timeInterval2Field1.getText();
            String interval2End = timeInterval2Field2.getText();

//            String[] interval1StartHoursMinutes = interval1Start.split(":");
//            String[] interval1EndHoursMinutes = interval2Start.split(":");
//            String[] interval2StartHoursMinutes = interval1End.split(":");
//            String[] interval2EndHoursMinutes = interval2End.split(":");

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

            Time time1Start = new Time(interval1StartHours, interval1StartMinutes, interval1StartMeridian);
            Time time1End = new Time(interval1End);


            // Repeat for interval1End, interval2Start, interval2End
            // Convert to 24-hour
            // Compare intervals
            // Display result





            //print statements for testing:
            System.out.println(
                    "time1 Start:" + interval1Start + " time1 End: " + interval1End + "\n" +
                            "time2 Start:" + interval2Start + " time2 End:" + interval2End
            );



            // Compare intervals logic

//            try{
//                int interval1StartHours = Integer.parseInt(interval1StartHoursMinutes[0]);
//                int interval1StartMinutes = Integer.parseInt(interval1StartHoursMinutes[1]);
//                int interval1EndHours = Integer.parseInt(interval1EndHoursMinutes[0]);
//                int interval1EndMinutes = Integer.parseInt(interval1EndHoursMinutes[1]);
//            } catch (NumberFormatException e) {
//                displayField.setText("Please enter valid integers");
//            }
            // Placeholder: Implement actual comparison logic
            displayField.setText("Comparison result: Placeholder");
        });

        checkTimeButton.setOnAction(event -> {
            String timeToCheck = timeToCheckField.getText();
            String interval1Start = timeInterval1Field1.getText();
            String interval1End = timeInterval1Field2.getText();
            String interval2Start = timeInterval2Field1.getText();
            String interval2End = timeInterval2Field2.getText();

            // Check time logic
            // Placeholder: Implement actual time checking logic
            displayField.setText("Check time result: Placeholder");
        });

        // Create the Scene and Stage
//        Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
//        stage.setScene(new Scene(root, 500, 500));

        Scene scene = new Scene(grid, 400, 250);
        stage.setTitle("Time Interval Checker");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*
* The fourth class Project4 should implement a GUI interface that contains two buttons. The first
button CompareIntervals should compare the two intervals and output one of the following
messages depending upon how the intervals compare:
 Interval 1 is a sub-interval of interval 2
 Interval 2 is a sub-interval of interval 1
 The intervals overlap
 The intervals are disjoint
Shown below is an example of the output when the CompareIntervals button is clicked:
The second button CheckTime should check whether the time is within the intervals and output
one of the following messages depending upon which intervals it is within:
 Both intervals contains the time HH:MM AM
 Only interval 1 contains the time HH:MM AM
 Only interval 2 contains the time HH:MM AM
 Neither interval contains the time HH:MM AM
Shown below is an example of the output when the CheckTime button is clicked:
* */
/*
*
*
            try{
                //parse the strings to integers
                int time1Start = Integer.parseInt(interval1Start);
                int time1End = Integer.parseInt(interval1End);
                int time2Start = Integer.parseInt(interval2Start);
                int time2End = Integer.parseInt(interval2End);

                //check if the intervals overlap
                if(time1Start < time2End && time1End > time2Start){
                    displayField.setText("The intervals overlap");
                }
                //check if interval 1 is a sub-interval of interval 2
                else if(time1Start >= time2Start && time1End <= time2End){
                    displayField.setText("Interval 1 is a sub-interval of interval 2");
                }
                //check if interval 2 is a sub-interval of interval 1
                else if(time2Start >= time1Start && time2End <= time1End){
                    displayField.setText("Interval 2 is a sub-interval of interval 1");
                }
                //check if the intervals are disjoint
                else{
                    displayField.setText("The intervals are disjoint");
                }
            }
            catch(NumberFormatException e){
                displayField.setText("Please enter valid integers");
            }
* */