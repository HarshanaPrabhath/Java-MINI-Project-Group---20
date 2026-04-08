package com.java_lms_group_20.Controller;

import com.java_lms_group_20.Model.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import java.io.IOException;

public class AdminDashboardController {

    @FXML
    private Label welcomeLabel;
    @FXML
    private StackPane contentArea;
    @FXML
    private Button btnRegisterUndergrad;
    @FXML
    private Button btnRegisterLecturer;
    @FXML
    private Button btnRegisterTO;
    @FXML
    private Button btnRegisterCourse;

    private User currentUser;

    public void initUser(User user) {
        this.currentUser = user;
        Platform.runLater(() -> {
            if (welcomeLabel != null) {
                welcomeLabel.setText("Welcome, " + user.getFirstName());
            }
        });
    }

    public void showDashboard() {
        resetButtonStyles();

        btnRegisterUndergrad.setStyle("-fx-background-color: #6366f1; -fx-text-fill: white; -fx-padding: 12; -fx-background-radius: 8;");


        switchView("/View/admin_dashboard_home.fxml");
    }

    @FXML
    private void showUndergradRegister() {

        resetButtonStyles();

        btnRegisterUndergrad.setStyle("-fx-background-color: #6366f1; -fx-text-fill: white; -fx-padding: 12; -fx-background-radius: 8;");


        switchView("/View/undergraduate_registration.fxml");
    }

    @FXML
    public void showLecturerRegister() {
        resetButtonStyles();

        btnRegisterLecturer.setStyle("-fx-background-color: #6366f1; -fx-text-fill: white; -fx-padding: 12; -fx-background-radius: 8;");

        switchView("/View/lecturer_registration.fxml");
    }


    @FXML
    public void showTORegister() {
        resetButtonStyles();

        btnRegisterTO.setStyle("-fx-background-color: #6366f1; -fx-text-fill: white; -fx-padding: 12; -fx-background-radius: 8;");

        switchView("/View/technical_officer_registration.fxml");

    }

    @FXML
    public void showCourseRegister() {
        resetButtonStyles();

        btnRegisterCourse.setStyle("-fx-background-color: #6366f1; -fx-text-fill: white; -fx-padding: 12; -fx-background-radius: 8;");

        switchView("/View/course_registration.fxml");
    }



    private void resetButtonStyles() {
        btnRegisterUndergrad.setStyle("-fx-background-color: transparent; -fx-text-fill: #94a3b8; -fx-padding: 12;");
        btnRegisterLecturer.setStyle("-fx-background-color: transparent; -fx-text-fill: #94a3b8; -fx-padding: 12;");
        btnRegisterTO.setStyle("-fx-background-color: transparent; -fx-text-fill: #94a3b8; -fx-padding: 12;");
        btnRegisterCourse.setStyle("-fx-background-color: transparent; -fx-text-fill: #94a3b8; -fx-padding: 12;");
    }

    private void switchView(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent view = loader.load();
            contentArea.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        // Add Hover Effect via Code (Simple way without external CSS)
        btnRegisterUndergrad.setOnMouseEntered(e -> {
            if (!btnRegisterUndergrad.getStyle().contains("#6366f1")) { // Only hover if not active
                btnRegisterUndergrad.setStyle("-fx-background-color: #1e293b; -fx-text-fill: white; -fx-padding: 12; -fx-background-radius: 8;");
            }
        });

        btnRegisterUndergrad.setOnMouseExited(e -> {
            if (!btnRegisterUndergrad.getStyle().contains("#6366f1")) { // Only reset if not active
                resetButtonStyles();
            }
        });
    }


}

