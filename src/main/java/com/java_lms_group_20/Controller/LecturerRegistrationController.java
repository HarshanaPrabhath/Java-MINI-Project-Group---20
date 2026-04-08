package com.java_lms_group_20.Controller;

import com.java_lms_group_20.Model.Lecturer;
import com.java_lms_group_20.Service.LecturerService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LecturerRegistrationController {

    @FXML private TextField txtFirstName, txtLastName, txtUsername, txtEmail;
    @FXML private TextField txtDepartment, txtSpecialization;
    @FXML private Label statusLabel;

    private final LecturerService service = new LecturerService();

    @FXML
    private void handleSaveLecturer() {
        try {
            Lecturer lecturer = new Lecturer();

            lecturer.setFirstName(txtFirstName.getText().trim());
            lecturer.setLastName(txtLastName.getText().trim());
            lecturer.setUsername(txtUsername.getText().trim());
            lecturer.setEmail(txtEmail.getText().trim());
            lecturer.setDepartment(txtDepartment.getText().trim());
            lecturer.setSpecialization(txtSpecialization.getText().trim());

            service.registerLecturer(lecturer);

            statusLabel.setText("Lecturer Registered Successfully!");
            statusLabel.setStyle("-fx-text-fill: #10b981;");

            clearFields();

        } catch (Exception e) {
            statusLabel.setText(e.getMessage());
            statusLabel.setStyle("-fx-text-fill: #ef4444;");
        }
    }

    private void clearFields() {
        txtFirstName.clear();
        txtLastName.clear();
        txtUsername.clear();
        txtEmail.clear();
        txtDepartment.clear();
        txtSpecialization.clear();

        txtFirstName.requestFocus();
    }
}