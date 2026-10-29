package in.batch2.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column(nullable = false)
    private String projectName;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private double budget;

    @Column(nullable = false)
    private long maximumTeamSize;

    @Column(nullable = false)
    private String status;

    public Project(){

    }

    public Project(Long projectId, String projectName, String clientName, Date startDate, double budget, long maximumTeamSize, String status) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.clientName = clientName;
        this.startDate = startDate;
        this.budget = budget;
        this.maximumTeamSize = maximumTeamSize;
        this.status = status;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public long getMaximumTeamSize() {
        return maximumTeamSize;
    }

    public void setMaximumTeamSize(long maximumTeamSize) {
        this.maximumTeamSize = maximumTeamSize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", clientName='" + clientName + '\'' +
                ", startDate=" + startDate +
                ", budget=" + budget +
                ", maximumTeamSize=" + maximumTeamSize +
                ", status='" + status + '\'' +
                '}';
    }
}
