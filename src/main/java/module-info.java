module com.example.week8project4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.week8project4 to javafx.fxml;
    exports com.example.week8project4;
}