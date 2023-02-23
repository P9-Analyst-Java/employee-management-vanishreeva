package com.deloitte.employee.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.deloitte.employee.dao.EmployeeDao;
import com.deloitte.employee.model.Employee;
import com.deloitte.employee.model.EmploymentHistory;
import com.deloitte.employee.service.EmployeeService;

import jakarta.servlet.http.HttpServletResponse;

 
 
@Controller
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    EmployeeDao employeeDao;
    
    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mav= new ModelAndView("home");
        mav.addObject("message","List of Employees");
        List<Employee> employees= employeeService.findAll();
        mav.addObject("employees",employees);
        return mav;
    }
    
    @RequestMapping("/addemployee")
    public ModelAndView addEmployee() {
        ModelAndView mav= new ModelAndView("addemployee");
        mav.addObject("addemployee", new Employee());
        return mav;
    }
    
    @RequestMapping(value = "/exportUsers", method = RequestMethod.GET)
    public void exportToCSV(HttpServletResponse response) throws IOException {
    response.setContentType("text/csv");
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    String currentDateTime = dateFormatter.format(new Date());
     
    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename=Employee_" + currentDateTime + ".csv";
    response.setHeader(headerKey, headerValue);
     
    List<Employee> listUsers = employeeService.findAll();
     
    ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
    String[] csvHeader = { "Emp Id", "Name", "Doj", "Post", "Level", "Mobile", "Personal Mail", "Office Mail",
    "Dob", "Blood Group", "Pan no", "Aadhar no" };
    String[] nameMapping = {"emp_id", "firstName", "doj", "post_name", "emp_level","mobile_num","email_id","office_mail","dob",
    "blood_group","pan_num","aadhar_num"};
     
     
     
    csvWriter.writeHeader(csvHeader);
     
    for (Employee user : listUsers) {
    csvWriter.write(user, nameMapping);
    }
     
    csvWriter.close();
     
    }

    
    @RequestMapping(value="/addemployee", method=RequestMethod.POST)
    public String save(@ModelAttribute("addemployee")Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }
    @RequestMapping(value="/addemployee/{id}")
    public ModelAndView edit(@PathVariable("id")Long id) {
        ModelAndView mav= new ModelAndView("addemployee");
        Employee employee=employeeService.findById(id);
        mav.addObject("addemployee",employee);
        return mav;
        
    }
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public String delete(@PathVariable("id")Long id) {
        employeeService.delete(id);
        return "redirect:/";
}
    
    @RequestMapping(value="/search", method = RequestMethod.POST)
    public ModelAndView search(@Param("id") Long id, @Param("name") String name) {
    ModelAndView mav = new ModelAndView("home");
    List<Employee> employees;
    // if(id!=null) {
    // employees = employeeDao.search(id);
    // }
    // else {
    // employees= employeeDao.search(name);
    // }
    // mav.addObject("employees", employees);
    employees=employeeService.search(id, name);
    if(employees!=null) {
    mav.addObject("employees", employees);
    }
    System.out.println(employees);
    return mav;
    }
    
    @RequestMapping(value="/history/{emp_id}")
    public ModelAndView viewHistory(@PathVariable ("emp_id") Long emp_id) {
    ModelAndView mav= new ModelAndView("history");
    List<EmploymentHistory> employees=employeeDao.findHistory(emp_id);
    Employee employee1=employeeService.findById(emp_id);
     
    mav.addObject("employees",employees);
    mav.addObject("name",employee1);
     
    return mav;
     
     
    }


}
