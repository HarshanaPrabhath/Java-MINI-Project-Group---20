package com.java_lms_group_20.Controller;

import com.java_lms_group_20.Model.TechnicalOfficer;
import com.java_lms_group_20.Service.TechnicalOfficerService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TechnicalOfficerRegistrationController {

    @FXML private TextField txtFirstName, txtLastName, txtUsername, txtEmail;
    @FXML private TextField txtLab, txtShift;
    @FXML private Label statusLabel;

    private final TechnicalOfficerService service = new TechnicalOfficerService();

    @FXML
    private void handleSaveTO() {
        try {
            TechnicalOfficer officer = new TechnicalOfficer();

            officer.setFirstName(txtFirstName.getText().trim());
            officer.setLastName(txtLastName.getText().trim());
            officer.setUsername(txtUsername.getText().trim());
            officer.setEmail(txtEmail.getText().trim());
            officer.setLab(txtLab.getText().trim());
            officer.setShift(txtShift.getText().trim());

            service.registerTechnicalOfficer(officer);

            statusLabel.setText("Technical Officer Registered Successfully!");
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
        txtLab.clear();
        txtShift.clear();

        txtFirstName.requestFocus();
    }
}