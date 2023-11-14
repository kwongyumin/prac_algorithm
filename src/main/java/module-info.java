module com.example.prac_algorithm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prac_algorithm to javafx.fxml;
    exports com.example.prac_algorithm;
}