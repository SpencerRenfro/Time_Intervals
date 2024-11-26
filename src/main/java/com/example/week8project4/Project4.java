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

            // Compare intervals logic
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
