package com.example.springsecuritymaster.controller;

import com.example.springsecuritymaster.annotation.department.DepartmentCreate;
import com.example.springsecuritymaster.annotation.department.DepartmentDelete;
import com.example.springsecuritymaster.annotation.department.DepartmentRead;
import com.example.springsecuritymaster.dao.DepartmentDao;
import com.example.springsecuritymaster.model.Department;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentDao departmentDao;

    @DepartmentRead
    @GetMapping("/departments")
    public ModelAndView index() {
        return new ModelAndView("departments", "departments", departmentDao.findAll());
    }

    @DepartmentCreate
    @GetMapping("/departments/create")
    public ModelAndView create() {
        return new ModelAndView("department-create", "department", new Department());
    }
    @DepartmentCreate
    @PostMapping("/departments/save")
    public String create(@ModelAttribute @Valid Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "department-create";
        } else {
            departmentDao.save(department);

            return "redirect:/department/departments";
        }
    }

    @PreAuthorize("#id <= 2 || hasRole('SUPER_ADMIN')")
//    @DepartmentDelete
    @GetMapping("/departments/delete/{id}")
    public String delete(@PathVariable Integer id) {
        departmentDao.deleteById(id);

        return "redirect:/department/departments";
    }

}
