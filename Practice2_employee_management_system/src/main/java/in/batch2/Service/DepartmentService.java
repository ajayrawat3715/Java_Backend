package in.batch2.Service;

import in.batch2.DAO.DepartmentDAO;
import in.batch2.model.Department;

public class DepartmentService {

    // Save department
    public void saveDepartment(Department department) {
        DepartmentDAO.save(department);
    }

    // Find department by ID
    public Department getDepartmentById(int id) {
        return DepartmentDAO.findById(id);
    }

    // Update department
    public void updateDepartment(Department department) {
        DepartmentDAO.update(department);
    }

    // Delete department by ID
    public void deleteDepartment(int id) {
        DepartmentDAO.delete(id);
    }
}