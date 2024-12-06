/*
Spencer Renfro Project4: Time Interval Checker
Date: 12-5-2024
 */
package com.example.week8project4;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Project4 extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/week8project4/layout.fxml"));
        stage.setScene(new Scene(root, 400, 300));
        stage.setTitle("Time Interval Checker");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

