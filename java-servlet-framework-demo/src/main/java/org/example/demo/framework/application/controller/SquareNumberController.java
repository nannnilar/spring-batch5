package org.example.demo.framework.application.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.demo.framework.application.view.SquareNumberView;
import org.example.demo.framework.controller.ControllerMapping;
import org.example.demo.framework.controller.IController;
import org.example.demo.framework.ds.ModelAndView;
import org.example.demo.framework.model.SampleModel;

@ControllerMapping("/square")
public class SquareNumberController implements IController {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {
        int num = Integer.parseInt(request.getParameter("num"));
        int squareNum = num * num;
        var model = new SampleModel();
        model.set("num",String.valueOf(num));
        model.set("result",String.valueOf(squareNum));

        return new ModelAndView(model,new SquareNumberView());
    }
}
