package app.domain;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int employeeNumber;
    private String name;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="department_id")
    private Department department;


    public Employee(){}

    public Employee(String name) {
        this.name = name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
