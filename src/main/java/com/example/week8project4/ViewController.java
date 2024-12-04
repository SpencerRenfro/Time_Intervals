package com.example.week8project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ViewController {

    public TextField timeIntervalTextFieldStart1;
    public TextField timeIntervalTextFieldStart2;
    public TextField timeIntervalTextFieldEnd1;
    public TextField timeIntervalTextFieldEnd2;
    public Button compareIntervalsButton;
    public Button checkTimeButton;


    @FXML protected void handleSubmitButtonAction(ActionEvent event) {

        System.out.println("button clicked");
        System.out.println(timeIntervalTextFieldStart1.getText() + " " + timeIntervalTextFieldEnd1.getText());
        System.out.println(timeIntervalTextFieldStart2.getText() + " " + timeIntervalTextFieldEnd2.getText());



    }

}
