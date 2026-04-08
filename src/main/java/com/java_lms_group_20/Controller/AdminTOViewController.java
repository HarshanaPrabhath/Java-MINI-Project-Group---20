package com.java_lms_group_20.Controller;

import com.java_lms_group_20.Model.TechnicalOfficer;
import com.java_lms_group_20.Service.AdminService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminTOViewController {
    @FXML private TableView<TechnicalOfficer> toTable;
    @FXML private TableColumn<TechnicalOfficer, String> colName, colLab, colShift;

    private final AdminService adminService = new AdminService();

    @FXML
    public void initialize() {
        // firstName comes from the User parent class in your UML
        colName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLab.setCellValueFactory(new PropertyValueFactory<>("lab"));
        colShift.setCellValueFactory(new PropertyValueFactory<>("shift"));

        toTable.setItems(FXCollections.observableArrayList(adminService.getTOList()));
    }
}