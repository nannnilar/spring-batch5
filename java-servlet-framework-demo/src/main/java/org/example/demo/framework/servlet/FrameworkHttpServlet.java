package org.example.demo.framework.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.framework.controller.IController;
import org.example.demo.framework.ds.ModelAndView;
import org.example.demo.framework.model.Model;
import org.example.demo.framework.util.ApplicationControllerFinder;
import org.example.demo.framework.view.View;

import javax.swing.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/*")
public class FrameworkHttpServlet extends HttpServlet {

    private Map<String , IController> controllers;

    @Override
    public void init() throws ServletException {
        controllers = new ApplicationControllerFinder().findContrllers();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestUri = req.getRequestURI(); // '/'
        IController iController = controllers.get(requestUri);
        if (iController != null){
            ModelAndView modelAndView= iController.handleRequest(req);
            Model model = modelAndView.getModel();
            View view = modelAndView.getView();

            String renderString = view.render(model);

            resp.setContentType("text/html");
            resp.getWriter().print(renderString);

        }else {
            throw new RuntimeException("not found in Controller for this URI");
        }
    }
}
