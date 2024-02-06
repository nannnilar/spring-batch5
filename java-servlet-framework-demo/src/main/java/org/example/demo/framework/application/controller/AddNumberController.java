package org.example.demo.framework.application.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.demo.framework.application.view.AddNumberView;
import org.example.demo.framework.controller.ControllerMapping;
import org.example.demo.framework.controller.IController;
import org.example.demo.framework.ds.ModelAndView;
import org.example.demo.framework.model.Model;
import org.example.demo.framework.model.SampleModel;

@ControllerMapping("/addnumber")
public class AddNumberController implements IController {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {
        var model =new SampleModel();
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        model.set("num1",String.valueOf(num1));
        model.set("num2",String.valueOf(num2));
        model.set("result",String.valueOf(num1+num2));
        return new ModelAndView(
                model,new AddNumberView());
    }
}
