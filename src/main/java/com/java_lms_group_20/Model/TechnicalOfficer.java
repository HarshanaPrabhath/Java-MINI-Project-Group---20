package com.java_lms_group_20.Model;

public class TechnicalOfficer extends User {

    private String lab;
    private String shift;

    public TechnicalOfficer() {
        super();
    }

    public TechnicalOfficer(int userID, String username, String password,
                            String firstName, String lastName,
                            String email, String contactNo,
                            String lab, String shift) {

        super(userID, username, password, firstName, lastName, email, contactNo);
        this.lab = lab;
        this.shift = shift;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }


    public void approveMedical() {
        System.out.println("Medical approved by TO...");
    }

    public void manageLab() {
        System.out.println("Managing lab resources...");
    }
}