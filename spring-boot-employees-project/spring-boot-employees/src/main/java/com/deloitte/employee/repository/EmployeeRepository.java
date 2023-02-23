package com.deloitte.employee.repository;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import com.deloitte.employee.model.Employee;
 
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
 
List<Employee> findAll();
List<Employee> findByfirstName(String name);
 
}
