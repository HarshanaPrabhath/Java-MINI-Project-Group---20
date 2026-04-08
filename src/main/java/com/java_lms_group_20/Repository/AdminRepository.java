package com.java_lms_group_20.Repository;

import com.java_lms_group_20.Model.*;
import com.java_lms_group_20.Util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository {

    // 1. Fetch all Lecturers
    public List<Lecturer> getAllLecturers() {
        List<Lecturer> list = new ArrayList<>();
        String query = "SELECT u.*, l.department, l.specialization FROM user u " +
                "JOIN lecturer l ON u.userID = l.userID";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Lecturer l = new Lecturer();
                l.setFirstName(rs.getString("firstName"));
                l.setLastName(rs.getString("lastName"));
                l.setEmail(rs.getString("email"));
                l.setDepartment(rs.getString("department"));
                l.setSpecialization(rs.getString("specialization"));
                list.add(l);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    // 2. Fetch all Technical Officers
    public List<TechnicalOfficer> getAllTechnicalOfficers() {
        List<TechnicalOfficer> list = new ArrayList<>();
        String query = "SELECT u.*, t.lab, t.shift FROM user u " +
                "JOIN technical_officer t ON u.userID = t.userID";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                TechnicalOfficer to = new TechnicalOfficer();
                to.setFirstName(rs.getString("firstName"));
                to.setLastName(rs.getString("lastName"));
                to.setLab(rs.getString("lab"));
                to.setShift(rs.getString("shift"));
                list.add(to);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    // 3. Fetch all Undergraduates
    public List<Undergraduate> getAllUndergraduates() {
        List<Undergraduate> list = new ArrayList<>();
        String query = "SELECT u.*, ug.studentID, ug.degreeProgram, ug.level, ug.gpa FROM user u " +
                "JOIN undergraduate ug ON u.userID = ug.userID";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Undergraduate ug = new Undergraduate();
                ug.setFirstName(rs.getString("firstName"));
                ug.setStudentID(rs.getString("studentID"));
                ug.setDegreeProgram(rs.getString("degreeProgram"));
                ug.setGpa(rs.getDouble("gpa"));
                list.add(ug);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    // 4. Fetch all Courses
    public List<Course> getAllCourses() {
        List<Course> list = new ArrayList<>();
        String query = "SELECT * FROM course";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Course c = new Course();
                c.setCourseCode(rs.getString("courseCode"));
                c.setCourseName(rs.getString("courseName"));
                c.setCredits(rs.getInt("credits"));
                list.add(c);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
}