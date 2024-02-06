package com.example.springsecuritymaster.controller;

import com.example.springsecuritymaster.dao.DepartmentDao;
import com.example.springsecuritymaster.model.Customer;
import com.example.springsecuritymaster.model.Department;
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

@Controller
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentDao departmentDao;

    @GetMapping("/list-departments")
    public ModelAndView listDepartment(){
        return new ModelAndView("departments",
                "departments",
                departmentDao.findAll());
    }

    @PostMapping("/save-department")
    public String saveCustomer(@Valid Department department, BindingResult result,
                               RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "departmentForm";
        }
        departmentDao.save(department);
        redirectAttributes.addFlashAttribute("success",true);
        return "redirect:/department/list-departments";
    }

    @GetMapping("/delete-department")
    public String deleteCustomer(@RequestParam("id")int id){
        if(departmentDao.existsById(id)){
            departmentDao.deleteById(id);
        }
        else{
            throw new EntityNotFoundException(id + " Not Found");
        }
        return "redirect:/department/list-departments";
    }

    @GetMapping("/department-form")
    public ModelAndView customerForm(){
        return new ModelAndView("departmentForm",
                "department",new Department());
    }

}
