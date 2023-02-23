package com.deloitte.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.employee.model.Employee;
import com.deloitte.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        if(employeeRepository.findById(id).isPresent()) {
            return employeeRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
            employeeRepository.deleteById(id);
        
        
    }
    
    @Override
    public List<Employee> search(Long id, String name) {
    List<Employee> employees = new ArrayList<>();
    if(id==null)
    employees = employeeRepository.findByfirstName(name);
    else {
    Optional<Employee> optEmp = employeeRepository.findById(id);
    if(optEmp.isPresent())
    employees.add(optEmp.get());
    }
    return employees;
    }


}
