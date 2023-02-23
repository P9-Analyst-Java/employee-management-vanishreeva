package com.deloitte.employee.dao;
 
import java.util.List;
 
import com.deloitte.employee.model.Employee;
import com.deloitte.employee.model.EmploymentHistory;
 
public interface EmployeeDao {
 
   
    List<EmploymentHistory> findHistory(Long emp_id);



}

