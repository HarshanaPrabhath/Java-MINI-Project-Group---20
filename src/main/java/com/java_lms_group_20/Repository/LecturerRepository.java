package com.java_lms_group_20.Repository;

import com.java_lms_group_20.Model.Lecturer;
import com.java_lms_group_20.Util.DBConnection;

import java.sql.*;

public class LecturerRepository {

    public boolean save(Lecturer lecturer) throws SQLException {

        String userSql = "INSERT INTO user (username, password, firstName, lastName, email) VALUES (?, ?, ?, ?, ?)";
        String roleSql = "INSERT INTO user_roles (userID, roleID) VALUES (?, 2)";
        String lecturerSql = "INSERT INTO lecturer (userID, department, specialization) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement uStmt = conn.prepareStatement(userSql, Statement.RETURN_GENERATED_KEYS)) {

                uStmt.setString(1, lecturer.getUsername());
                uStmt.setString(2, "1234");
                uStmt.setString(3, lecturer.getFirstName());
                uStmt.setString(4, lecturer.getLastName());
                uStmt.setString(5, lecturer.getEmail());

                uStmt.executeUpdate();

                ResultSet rs = uStmt.getGeneratedKeys();

                if (rs.next()) {
                    int newId = rs.getInt(1);


                    try (PreparedStatement rStmt = conn.prepareStatement(roleSql)) {
                        rStmt.setInt(1, newId);
                        rStmt.executeUpdate();
                    }


                    try (PreparedStatement lStmt = conn.prepareStatement(lecturerSql)) {
                        lStmt.setInt(1, newId);
                        lStmt.setString(2, lecturer.getDepartment());
                        lStmt.setString(3, lecturer.getSpecialization());
                        lStmt.executeUpdate();
                    }
                }

                conn.commit();
                return true;

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }
}