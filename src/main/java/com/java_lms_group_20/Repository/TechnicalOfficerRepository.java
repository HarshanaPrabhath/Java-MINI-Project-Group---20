package com.java_lms_group_20.Repository;

import com.java_lms_group_20.Model.TechnicalOfficer;
import com.java_lms_group_20.Util.DBConnection;

import java.sql.*;

public class TechnicalOfficerRepository {

    public boolean save(TechnicalOfficer officer) throws SQLException {

        String userSql = "INSERT INTO user (username, password, firstName, lastName, email) VALUES (?, ?, ?, ?, ?)";
        String roleSql = "INSERT INTO user_roles (userID, roleID) VALUES (?, 4)"; // 4 = TO
        String officerSql = "INSERT INTO technical_officer (userID, lab, shift) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement uStmt = conn.prepareStatement(userSql, Statement.RETURN_GENERATED_KEYS)) {

                uStmt.setString(1, officer.getUsername());
                uStmt.setString(2, "1234"); // default password
                uStmt.setString(3, officer.getFirstName());
                uStmt.setString(4, officer.getLastName());
                uStmt.setString(5, officer.getEmail());

                uStmt.executeUpdate();

                ResultSet rs = uStmt.getGeneratedKeys();

                if (rs.next()) {
                    int newId = rs.getInt(1);


                    try (PreparedStatement rStmt = conn.prepareStatement(roleSql)) {
                        rStmt.setInt(1, newId);
                        rStmt.executeUpdate();
                    }


                    try (PreparedStatement tStmt = conn.prepareStatement(officerSql)) {
                        tStmt.setInt(1, newId);
                        tStmt.setString(2, officer.getLab());
                        tStmt.setString(3, officer.getShift());
                        tStmt.executeUpdate();
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