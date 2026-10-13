package in.batch2;

import in.batch2.dao.EmployeeDAO;
import in.batch2.model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args){
        EmployeeDAO employeeDAO = new EmployeeDAO();

        List<Employee> employees = employeeDAO.findAll();

        for(Employee employee : employees){
            System.out.println(employee);
        }

        System.out.println("/n");
    }
}
