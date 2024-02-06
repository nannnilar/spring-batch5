package com.example.todolist.controller;

import com.example.todolist.dao.ToDoDao;
import com.example.todolist.entity.ToDo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToDoController {
    private final ToDoDao toDoDao;

    public ToDoController(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;
    }
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("todo",new ToDo());
        model.addAttribute("todoList",toDoDao.findAll());
        return "index";
    }
    @PostMapping("/save-todo")
    public String saveToDo(ToDo toDo, BindingResult result){
        if (result.hasErrors()){
            return "index";
        }
        toDoDao.save(toDo);
        return "redirect:/";
    }
}
