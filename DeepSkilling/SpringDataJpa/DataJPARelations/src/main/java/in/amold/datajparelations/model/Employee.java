package in.amold.datajparelations.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Lazy;

import java.util.Date;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    private Integer Salary;
    private boolean isPermanent;
    private Date dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "em_dp_id")
    private Department department;

    @ManyToMany()
    @JoinTable(name = "employee_skill",
            joinColumns = @JoinColumn(name = "es_em_id"),
            inverseJoinColumns = @JoinColumn(name = "es_sk_id"))

    private Set<Skill>skilledList;

    public Set<Skill> getSkilledList() {
        return skilledList;
    }

    public void setSkilledList(Set<Skill> skilledList) {
        this.skilledList = skilledList;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer salary) {
        Salary = salary;
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public void setPermanent(boolean permanent) {
        isPermanent = permanent;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Salary=" + Salary +
                ", isPermanent=" + isPermanent +
                ", dateOfBirth=" + dateOfBirth +
                ", department=" + department +
                ", skilledList=" + skilledList +
                '}';
    }
}
