package in.batch2.Service;

import in.batch2.DAO.StudentDAO;
import in.batch2.model.Student;

import java.util.List;

public class StudentService {

    private final StudentDAO studentDAO = new StudentDAO();

    public void saveStudent(Student student) {
        studentDAO.save(student);
    }

    public Student getStudentById(int id) {
        return studentDAO.findById(id);
    }

    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    public void updateStudent(Student student) {
        studentDAO.update(student);
    }

    public void deleteStudent(int id) {
        studentDAO.delete(id);
    }
}