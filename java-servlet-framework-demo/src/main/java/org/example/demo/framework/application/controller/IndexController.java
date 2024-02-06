package org.example.demo.framework.application.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.demo.framework.application.view.IndexView;
import org.example.demo.framework.controller.ControllerMapping;
import org.example.demo.framework.controller.IController;
import org.example.demo.framework.ds.ModelAndView;
import org.example.demo.framework.model.SampleModel;

@ControllerMapping("/")
public class IndexController implements IController {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {
        return new ModelAndView(new SampleModel(),new IndexView());
    }
}
