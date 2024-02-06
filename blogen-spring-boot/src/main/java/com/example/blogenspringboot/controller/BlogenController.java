package com.example.blogenspringboot.controller;

import com.example.blogenspringboot.entity.Category;
import com.example.blogenspringboot.entity.Customer;
import com.example.blogenspringboot.entity.Post;
import com.example.blogenspringboot.service.BlogenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogenController {

    private final BlogenService blogenService;

    public BlogenController(BlogenService blogenService) {
        this.blogenService = blogenService;
    }
    @GetMapping("/list-category")
    public String listCategories(Model model){
        model.addAttribute("categories",blogenService.findAllCategory());
        return "categories";
    }

    @GetMapping("/")
    public String test(Model model){
        model.addAttribute("customers",blogenService.findAllCustomers());
        model.addAttribute("categories",blogenService.findAllCategory());
        model.addAttribute("posts",new Post());
        model.addAttribute("customer",new Customer());
        model.addAttribute("category",new Category());
        model.addAttribute("posts",blogenService.findAllPost());
        return "dashboard";
    }
    @PostMapping("/save-customer")
    public String saveCustomer(Customer customer,BindingResult result){
//        System.out.println("================="+customer);
        if (result.hasErrors()){
            return "dashboard";
        }
        blogenService.saveCustomer(customer);
        return "redirect:/";
    }
    @PostMapping("/save-category")
   public String saveCategory(Category category, BindingResult result){
        if(result.hasErrors()){
            return "dashboard";
        }
        blogenService.saveCategory(category);
        return "redirect:/";
   }
   @GetMapping("/list-customer")
   public String listCustomers(Model model){
        model.addAttribute("customers",blogenService.findAllCustomers());
        return "customers";
   }
   @PostMapping("/save-post")
   public String savePost(Post post,BindingResult result){
        if (result.hasErrors()){
            return "dashboard";
        }
        blogenService.savePost(post);
        return "redirect:/";
   }
   @GetMapping("/list-post")
   public String listPosts(){

        return "posts";
   }
}
