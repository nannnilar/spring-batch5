package com.example.mvcscoped.controller;

import com.example.mvcscoped.beans.ApplicationScopedBean;
import com.example.mvcscoped.beans.RequestScopedBean;
import com.example.mvcscoped.beans.SessionScopedBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

@Controller
public class IndexController {
    private RequestScopedBean requestScopedBean;
    private SessionScopedBean sessionScopedBean;
    private ApplicationScopedBean applicationScopedBean;
    private WebApplicationContext webApplicationContext;

    public IndexController(RequestScopedBean requestScopedBean, SessionScopedBean sessionScopedBean,
                           ApplicationScopedBean applicationScopedBean, WebApplicationContext webApplicationContext) {
        this.requestScopedBean = requestScopedBean;
        this.sessionScopedBean = sessionScopedBean;
        this.applicationScopedBean = applicationScopedBean;
        this.webApplicationContext = webApplicationContext;
    }
    @RequestMapping(value = {"/"},method = {RequestMethod.GET,RequestMethod.POST})
    public String index(Model model){
        model.addAttribute("webContext",webApplicationContext.getServletContext());
        model.addAttribute("requestValue",requestScopedBean.getValue());
        model.addAttribute("sessionValue",sessionScopedBean.getValue());
        model.addAttribute("applicationValue",applicationScopedBean.getValue());

        return "index";
    }
    @PostMapping("/save-request-value")
    public String saveRequestScopedValue(@RequestParam("num")int num){
        requestScopedBean.setValue(num);
        return "forward:/";
    }
    @PostMapping("/save-session-value")
    public String saveSessionScopedValue(@RequestParam("num") int num){
        sessionScopedBean.setValue(num);
        return "redirect:/";
    }
    @PostMapping("/save-application-value")
    public String saveApplicationScopedValue(@RequestParam("num") int num){
        applicationScopedBean.setValue(num);
        return "redirect:/";
    }
}
