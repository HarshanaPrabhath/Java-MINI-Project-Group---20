package com.example.model;

public class Marks {

    private int markId;
    private String courseCode;
    private int caMarks;
    private int examMarks;
    private double finalMarks;
    private String grade;

    public Marks() {}

    public Marks(int markId, String courseCode, int caMarks, int examMarks) {
        this.markId = markId;
        this.courseCode = courseCode;
        this.caMarks = caMarks;
        this.examMarks = examMarks;
        calculateFinalMarks();
        calculateGrade();
    }

    public void calculateFinalMarks() {
        this.finalMarks = (caMarks * 0.4) + (examMarks * 0.6);
    }

    public void calculateGrade() {
        if (finalMarks >= 75) grade = "A";
        else if (finalMarks >= 65) grade = "B";
        else if (finalMarks >= 55) grade = "C";
        else if (finalMarks >= 45) grade = "S";
        else grade = "F";
    }

    // Getters & Setters

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCaMarks() {
        return caMarks;
    }

    public void setCaMarks(int caMarks) {
        this.caMarks = caMarks;
    }

    public int getExamMarks() {
        return examMarks;
    }

    public void setExamMarks(int examMarks) {
        this.examMarks = examMarks;
    }

    public double getFinalMarks() {
        return finalMarks;
    }

    public String getGrade() {
        return grade;
    }
}