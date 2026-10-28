
package in.batch2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private double fee;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Course() {
    }

    public Course(int id, String courseName,
                  int duration, double fee) {
        this.id = id;
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }

    public double getFee() {
        return fee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", fee=" + fee +
                ", department=" +
                (department != null ? department.getName() : null) +
                '}';
    }
}
