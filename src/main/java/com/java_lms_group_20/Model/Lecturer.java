package com.java_lms_group_20.Model;

public class Lecturer extends User {

    private String department;
    private String specialization;

    public Lecturer() {
        super();
    }

    public Lecturer(int userID, String username, String password,
                    String firstName, String lastName,
                    String email, String contactNo,
                    String department, String specialization) {

        super(userID, username, password, firstName, lastName, email, contactNo);
        this.department = department;
        this.specialization = specialization;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Behavior
    public void assignMarks() {
        System.out.println("Lecturer assigning marks...");
    }

    public void viewStudents() {
        System.out.println("Lecturer viewing students...");
    }
}