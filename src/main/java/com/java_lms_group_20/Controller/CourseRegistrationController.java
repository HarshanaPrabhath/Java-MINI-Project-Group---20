package com.java_lms_group_20.Controller;

import com.java_lms_group_20.Model.Course;
import com.java_lms_group_20.Service.CourseService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CourseRegistrationController {

    @FXML private TextField txtCourseCode, txtCourseName, txtCredits;
    @FXML private Label statusLabel;

    private final CourseService service = new CourseService();

    @FXML
    private void handleSaveCourse() {
        try {
            Course course = new Course();

            course.setCourseCode(txtCourseCode.getText().trim());
            course.setCourseName(txtCourseName.getText().trim());

            if (txtCredits.getText().isEmpty()) {
                throw new Exception("Credits cannot be empty.");
            }

            course.setCredits(Integer.parseInt(txtCredits.getText().trim()));

            service.registerCourse(course);

            statusLabel.setText("Course Registered Successfully!");
            statusLabel.setStyle("-fx-text-fill: #10b981;");

            clearFields();

        } catch (NumberFormatException e) {
            statusLabel.setText("Credits must be a number.");
            statusLabel.setStyle("-fx-text-fill: #ef4444;");
        } catch (Exception e) {
            statusLabel.setText(e.getMessage());
            statusLabel.setStyle("-fx-text-fill: #ef4444;");
        }
    }

    private void clearFields() {
        txtCourseCode.clear();
        txtCourseName.clear();
        txtCredits.clear();
        txtCourseCode.requestFocus();
    }
}