package com.java_lms_group_20.Model;


public class Course {

    private int courseID;
    private String courseCode;
    private String courseName;
    private int credits;

    public Course() {}

    public Course(int courseID, String courseCode, String courseName, int credits) {
        this.courseID = courseID;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}