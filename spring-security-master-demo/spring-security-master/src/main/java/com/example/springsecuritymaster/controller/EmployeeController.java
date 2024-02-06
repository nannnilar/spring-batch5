package com.example.springsecuritymaster.controller;

import com.example.springsecuritymaster.dao.EmployeeDao;
import com.example.springsecuritymaster.model.Employee;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeDao employeeDao;
    @GetMapping("/list-employees")
    public ModelAndView listEmployee(){
        return new ModelAndView("employees",
                "employees",
                employeeDao.findAll());
    }
    @GetMapping("/employee-form")
    public ModelAndView employeeForm(){
        return new ModelAndView("employeeForm",
                "employee",new Employee());
    }
    @PostMapping("/save-employee")
    public String saveEmployee(@Valid Employee employee, BindingResult result,
                               RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "employeeForm";
        }
        employeeDao.save(employee);
        redirectAttributes.addFlashAttribute("success",true);
        return "redirect:/employee/list-employees";
    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id")int id){
        if(employeeDao.existsById(id)){
            employeeDao.deleteById(id);
        }
        else{
            throw new EntityNotFoundException(id + " Not Found");
        }
        return "redirect:/employee/list-employees";
    }

}
