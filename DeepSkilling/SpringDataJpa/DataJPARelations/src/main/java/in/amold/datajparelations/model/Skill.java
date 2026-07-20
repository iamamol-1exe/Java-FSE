package in.amold.datajparelations.model;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "skilledList")
    private Set<Employee> employees;

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
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

    @Override
    public String toString() {
        return "Skill{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
