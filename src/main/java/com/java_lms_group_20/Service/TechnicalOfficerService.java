package com.java_lms_group_20.Service;

import com.java_lms_group_20.Model.TechnicalOfficer;
import com.java_lms_group_20.Repository.TechnicalOfficerRepository;

public class TechnicalOfficerService {

    private final TechnicalOfficerRepository repository = new TechnicalOfficerRepository();

    public void registerTechnicalOfficer(TechnicalOfficer officer) throws Exception {

        // 🔹 Validation
        if (officer.getUsername() == null || officer.getUsername().length() < 4) {
            throw new Exception("Username must be at least 4 characters.");
        }

        if (officer.getLab() == null || officer.getLab().isEmpty()) {
            throw new Exception("Lab is required.");
        }

        if (officer.getShift() == null || officer.getShift().isEmpty()) {
            throw new Exception("Shift is required.");
        }

        // 🔹 Save
        boolean success = repository.save(officer);
        if (!success) {
            throw new Exception("Database error: Could not save technical officer.");
        }
    }
}