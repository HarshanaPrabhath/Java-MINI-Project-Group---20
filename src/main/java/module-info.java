module com.example.java_lms_group_20 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires com.jfoenix;
    requires java.sql;


    opens com.java_lms_group_20.Controller to javafx.fxml;


    opens com.java_lms_group_20.Model to javafx.base, javafx.fxml;


    opens com.java_lms_group_20 to javafx.fxml;

    exports com.java_lms_group_20;
    exports com.java_lms_group_20.Controller;
    exports com.java_lms_group_20.Model;
}