package com.deloitte.employee.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="employment_history")
@Data
public class EmploymentHistory {
    
    @Id
    private Long id;
    
    private Long emp_id;
    
    
    private String organization_name;
    
    private Date from_date;
    
    private Date until_date;
    
    private String locaiton;
    
    private String country;
    
    private String post;
    
    private String skill_used;
    
    

}
