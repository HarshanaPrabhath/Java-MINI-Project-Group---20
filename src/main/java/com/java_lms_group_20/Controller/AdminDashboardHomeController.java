package com.java_lms_group_20.Controller;

import com.java_lms_group_20.Model.*;
import com.java_lms_group_20.Service.AdminService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminDashboardHomeController {

    private final AdminService adminService = new AdminService();

    @FXML private TableView<Undergraduate> studentTable;
    @FXML private TableColumn<Undergraduate, String> colStuID, colStuName, colStuDegree;

    @FXML private TableView<Lecturer> lecturerTable;
    @FXML private TableColumn<Lecturer, String> colLecName, colLecDept, colLecSpec;

    @FXML private TableView<TechnicalOfficer> toTable;
    @FXML private TableColumn<TechnicalOfficer, String> colTOName, colTOLab, colTOShift;

    @FXML private TableView<Course> courseTable;
    @FXML private TableColumn<Course, String> colCourseCode, colCourseName;
    @FXML private TableColumn<Course, Integer> colCourseCredits;



    @FXML
    public void initialize() {
        // Only setup if the elements were successfully injected from FXML
        if (studentTable != null) setupStudentTable();
        if (lecturerTable != null) setupLecturerTable();
        if (toTable != null) setupTOTable();
        if (courseTable != null) setupCourseTable();

        loadAllData();
    }

    private void setupStudentTable() {
        colStuID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colStuName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colStuDegree.setCellValueFactory(new PropertyValueFactory<>("degreeProgram"));
    }

    private void setupLecturerTable() {
        colLecName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLecDept.setCellValueFactory(new PropertyValueFactory<>("department"));
        // This was the cause of the previous error - now matched in FXML
        colLecSpec.setCellValueFactory(new PropertyValueFactory<>("specialization"));
    }

    private void setupTOTable() {
        colTOName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colTOLab.setCellValueFactory(new PropertyValueFactory<>("lab"));
        colTOShift.setCellValueFactory(new PropertyValueFactory<>("shift"));
    }

    private void setupCourseTable() {
        colCourseCode.setCellValueFactory(new PropertyValueFactory<>("courseCode"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        colCourseCredits.setCellValueFactory(new PropertyValueFactory<>("credits"));
    }

    @FXML private Label lblTotalStudents, lblTotalCourses, lblTotalFaculty;

    private void loadAllData() {
        var studentList = adminService.getStudentList();
        var lecturerList = adminService.getLecturerList();
        var courseList = adminService.getCourseList();

        studentTable.setItems(FXCollections.observableArrayList(studentList));
        lecturerTable.setItems(FXCollections.observableArrayList(lecturerList));
        courseTable.setItems(FXCollections.observableArrayList(courseList));

        // Update the modern status cards
        lblTotalStudents.setText(String.valueOf(studentList.size()));
        lblTotalCourses.setText(String.valueOf(courseList.size()));
        lblTotalFaculty.setText(String.valueOf(lecturerList.size()));
    }
}