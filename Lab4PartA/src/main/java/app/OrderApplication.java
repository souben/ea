package app;


import app.dao.DepartmentRepository;
import app.dao.EmployeeRepository;
import app.domain.Department;
import app.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@EnableJpaRepositories
@EntityScan("app.domain")
@SpringBootApplication
public class OrderApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}


	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Employee employee = new Employee("Ali");
		Department department = new Department("IT");
		Department department1 = departmentRepository.save(department);
		employee.setDepartment(department1);
		System.out.println("department: " + department1);
		department.addEmployee(employee);
		Employee employee1 = employeeRepository.save(employee);
		System.out.println(employee1.getEmployeeNumber());
		Optional<Employee> employee2 = employeeRepository.findById(employee1.getEmployeeNumber());
		System.out.println(employee2);
	}
}