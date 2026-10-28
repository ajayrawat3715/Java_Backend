package in.batch2.Service;

import in.batch2.DAO.EnrollmentDAO;
import in.batch2.model.Enrollment;

import java.util.List;

public class EnrollmentService {

    private final EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

    public void saveEnrollment(Enrollment enrollment) {
        enrollmentDAO.save(enrollment);
    }

    public Enrollment getEnrollmentById(int id) {
        return enrollmentDAO.getEnrollmentById(id);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentDAO.getAllEnrollments();
    }

    public void deleteEnrollment(int id) {
        enrollmentDAO.delete(id);
    }
}