package com.java_lms_group_20.Repository;

import com.java_lms_group_20.Model.Course;
import com.java_lms_group_20.Util.DBConnection;

import java.sql.*;

public class CourseRepository {

    public boolean save(Course course) throws SQLException {

        String sql = "INSERT INTO course (courseCode, courseName, credits) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, course.getCourseCode());
            stmt.setString(2, course.getCourseName());
            stmt.setInt(3, course.getCredits());

            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    }
}