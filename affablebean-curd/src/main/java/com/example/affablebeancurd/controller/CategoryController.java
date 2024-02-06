package com.example.affablebeancurd.controller;

import com.example.affablebeancurd.entity.Category;
import com.example.affablebeancurd.entity.Product;
import com.example.affablebeancurd.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    private final ProductService productService;

    public CategoryController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("product-form")
    public String productForm(Model model){
        model.addAttribute("categories",productService.findAllCategory());
        model.addAttribute("product",new Product());
        return "productForm";
    }
    @PostMapping("/save-product")
    public String saveProduct(Product product,BindingResult result){
        if (result.hasErrors()){
            return "productForm";
        }
        productService.saveProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products",productService.findAllProducts());
       return "products";
    }
    @GetMapping("/remove/{id}")
    public String removeProduct(@PathVariable int id){
        productService.removeProduct(id);
        return "redirect:/products";
    }
    @GetMapping("/update/product/{id}")
    public String updateProduct(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findProductIById(id));
        model.addAttribute("categories",productService.findAllCategory());
        this.id= id;
        return "updateProduct";
    }
    @GetMapping("/product/detail")
    public String productDetails(@RequestParam("id") int id,Model model){
        model.addAttribute("product",productService.findProductIById(id));
        return "product-detail";
    }
    int id;
    @PostMapping("/update-product")
    public String saveUpdateProduct(Product product,BindingResult result){
        if (result.hasErrors()){
            return "updateProduct";
        }
        product.setId(id);
        productService.updateProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/category-form")
    public ModelAndView categoryForm(){
       return new ModelAndView("categoryForm","category",new Category());
    }
    @PostMapping("save-category")
    public String saveCategory(@Valid Category category, BindingResult result){
        if (result.hasErrors()){
            return "categoryForm";
        }
        productService.saveCategory(category);
        return "redirect:/list-category";
    }
    @GetMapping("/list-category")
    public String listCategory(Model model){
        model.addAttribute("categories",productService.findAllCategory());
        return "categories";
    }
    @GetMapping({"/","/home"})
    public String home(Model model){
        model.addAttribute("products",productService.findAllProducts());
        return "home";

    }
}

