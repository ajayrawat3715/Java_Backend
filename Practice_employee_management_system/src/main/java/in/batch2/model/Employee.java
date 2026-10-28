package in.batch2.model;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
//    Iska kaam hai employee ki id ko database se automatically generate karwana, taaki tujhe har employee ki ID manually set na karni pade.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable=false,length=100)
    private String name;

    @Column(name="branch",nullable=false,length=100)
    private String branch;

    @Column(name = "salary",nullable=false,precision=10,scale=2)
    private double salary;

    public Employee(){

    }

    public Employee(String name, String branch, double salary){
        this.name = name;
        this.branch = branch;
        this.salary = salary;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBranch(String branch){
        this.branch = branch;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public String getBranch(){
        return branch;
    }

    public double getSalary(){
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", salary=" + salary +
                '}';
    }

}
