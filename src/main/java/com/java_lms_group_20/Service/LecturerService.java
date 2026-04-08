package com.java_lms_group_20.Service;

import com.java_lms_group_20.Model.Lecturer;
import com.java_lms_group_20.Repository.LecturerRepository;

public class LecturerService {

    private final LecturerRepository repository = new LecturerRepository();

    public void registerLecturer(Lecturer lecturer) throws Exception {


        if (lecturer.getUsername() == null || lecturer.getUsername().length() < 4) {
            throw new Exception("Username must be at least 4 characters.");
        }

        if (lecturer.getDepartment() == null || lecturer.getDepartment().isEmpty()) {
            throw new Exception("Department is required.");
        }

        if (lecturer.getSpecialization() == null || lecturer.getSpecialization().isEmpty()) {
            throw new Exception("Specialization is required.");
        }


        boolean success = repository.save(lecturer);
        if (!success) {
            throw new Exception("Database error: Could not save lecturer.");
        }
    }
}