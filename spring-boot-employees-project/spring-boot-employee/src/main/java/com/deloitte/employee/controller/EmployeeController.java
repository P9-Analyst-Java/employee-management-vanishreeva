package com.deloitte.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.employee.model.Employee;
import com.deloitte.employee.service.EmployeeService;

 
 
@Controller
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    
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
}
