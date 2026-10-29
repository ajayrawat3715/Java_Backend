package in.batch2.model;

import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static long employeeId;

    @Column(nullable = false,unique = true)
    private String employeeName;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String designation;

    @Column(nullable = false)
    private double salary;

    @Column(nullable = false)
    private String password;

    public Employee(){

    }

    public Employee(String employeeName, String email, String designation, double salary, String password) {
        this.employeeName = employeeName;
        this.email = email;
        this.designation = designation;
        this.salary = salary;
        this.password = password;
    }

    public static long getEmployeeId() {
        return employeeId;
    }

    public static void setEmployeeId(int employeeId) {
        Employee.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", password='" + password + '\'' +
                '}';
    }
}
