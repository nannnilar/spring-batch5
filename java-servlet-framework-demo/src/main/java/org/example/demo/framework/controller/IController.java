package org.example.demo.framework.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.demo.framework.ds.ModelAndView;

public interface IController {
    ModelAndView handleRequest(HttpServletRequest request);
}
