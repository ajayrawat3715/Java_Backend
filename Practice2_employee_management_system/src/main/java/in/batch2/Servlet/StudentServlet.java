package in.batch2.Servlet;

import in.batch2.Service.StudentService;
import in.batch2.Service.DepartmentService;
import in.batch2.model.Student;
import in.batch2.model.Department;
import in.batch2.Config.ThymeleafConfig;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.thymeleaf.context.WebContext;

import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    private StudentService studentService;
    private DepartmentService departmentService;

    @Override
    public void init() {
        studentService = new StudentService();
        departmentService = new DepartmentService();
    }

    // Show student list
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> students = studentService.getAllStudents();

        request.setAttribute("students", students);

        // Edit student
        String id = request.getParameter("id");

        if (id != null) {
            Student student = studentService.getStudentById(
                    Integer.parseInt(id)
            );
            request.setAttribute("student", student);
        }

        request.getRequestDispatcher(
                "/WEB-INF/templates/student-list.html"
        ).forward(request, response);
    }

    // Add, update or delete student
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        try {
            if ("delete".equals(action)) {

                int id = Integer.parseInt(request.getParameter("id"));
                studentService.deleteStudent(id);

            } else {

                String name = request.getParameter("name");
                String email = request.getParameter("email");
                int age = Integer.parseInt(request.getParameter("age"));
                int departmentId = Integer.parseInt(
                        request.getParameter("departmentId")
                );

                Department department =
                        departmentService.getDepartmentById(departmentId);

                if (department == null) {
                    response.sendError(400, "Department not found");
                    return;
                }

                Student student = new Student();
                student.setName(name);
                student.setEmail(email);
                student.setAge(age);
                student.setDepartment(department);

                if ("update".equals(action)) {
                    student.setId(
                            Integer.parseInt(request.getParameter("id"))
                    );
                    studentService.updateStudent(student);
                } else {
                    studentService.saveStudent(student);
                }
            }

            response.sendRedirect(request.getContextPath() + "/students");

        } catch (NumberFormatException e) {
            response.sendError(400, "Invalid input");
        }
    }
}