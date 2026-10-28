package in.batch2.Service;

import in.batch2.DAO.CourseDAO;
import in.batch2.model.Course;

import java.util.List;

public class CourseService {

    // Save a new course
    public void saveCourse(Course course) {
        CourseDAO.save(course);
    }

    // Find course by ID
    public Course getCourseById(int id) {
        return CourseDAO.findById(id);
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return CourseDAO.findAll();
    }

    // Update course details
    public void updateCourse(Course course) {
        CourseDAO.update(course);
    }

    // Delete course by ID
    public void deleteCourse(int id) {
        CourseDAO.delete(id);
    }
}