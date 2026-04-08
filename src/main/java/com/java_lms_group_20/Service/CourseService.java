package com.java_lms_group_20.Service;

import com.java_lms_group_20.Model.Course;
import com.java_lms_group_20.Repository.CourseRepository;

public class CourseService {

    private final CourseRepository repository = new CourseRepository();

    public void registerCourse(Course course) throws Exception {

        if (course.getCourseCode() == null || course.getCourseCode().isEmpty()) {
            throw new Exception("Course code is required.");
        }

        if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
            throw new Exception("Course name is required.");
        }

        if (course.getCredits() <= 0) {
            throw new Exception("Credits must be greater than 0.");
        }

        boolean success = repository.save(course);
        if (!success) {
            throw new Exception("Database error: Could not save course.");
        }
    }
}