package com.example.week8project4;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Layout {
    private final GridPane grid;

    public Layout() {
        grid = new GridPane();

        // Set alignment and spacing for the GridPane
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); // Horizontal gap between columns
        grid.setVgap(10); // Vertical gap between rows

        // Components
        Label startTimeLabel = new Label("Start Time");
        Label endTimeLabel = new Label("End Time");
        Label timeInterval1Label = new Label("Time Interval 1");
        Label timeInterval2Label = new Label("Time Interval 2");
        Label timeToCheckLabel = new Label("Time to Check");
        TextField timeInterval1Field1 = new TextField();
        TextField timeInterval1Field2 = new TextField();
        TextField timeInterval2Field1 = new TextField();
        TextField timeInterval2Field2 = new TextField();
        TextField timeToCheckField = new TextField();
        TextField displayField = new TextField();
        displayField.setEditable(false); // Make it display-only

        Button compareIntervalsButton = new Button("Compare Intervals");
        Button checkTimeButton = new Button("Check Time");

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

        // Fourth Row (Button spanning 3 rows)
        GridPane.setColumnSpan(compareIntervalsButton, 3); // Span 3 rows
        grid.add(compareIntervalsButton, 0, 3);

        // Fifth Row (Time to Check and its input)
        grid.add(timeToCheckLabel, 0, 4);
        GridPane.setColumnSpan(timeToCheckField, 2); // Span 2 columns
        grid.add(timeToCheckField, 1, 4);

        // Sixth Row (Secondary Button spanning 3 rows)
        GridPane.setColumnSpan(checkTimeButton, 3); // Span 3 rows
        grid.add(checkTimeButton, 0, 5);

        // Seventh Row (Display-only field spanning 3 columns)
        GridPane.setColumnSpan(displayField, 3); // Span all 3 columns
        grid.add(displayField, 0, 6);
    }

    public GridPane getLayout() {
        return grid;
    }
}
