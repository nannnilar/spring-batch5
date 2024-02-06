package org.example.demo.framework.util;

import org.example.demo.framework.controller.ControllerMapping;
import org.example.demo.framework.controller.IController;
import org.reflections.Reflections;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ApplicationControllerFinder {

    public Map<String,IController> findContrllers(){
        return new Reflections()
                .getTypesAnnotatedWith(ControllerMapping.class)
                .stream()
                .map(this::getAsIControllerClass)
                .map(this::getControlletInstance)
                .collect(Collectors.toMap(this::getUri, Function.identity()));
    }

    private Class<IController> getAsIControllerClass(Class<?> controller){
        return (Class<IController>) controller;
    }

    private IController getControlletInstance(Class<IController> iControllerClass){
        try {
            return iControllerClass.getConstructor().newInstance();
        } catch (Exception e){
            throw new RuntimeException("Creating Object in Controller!");
        }
    }

    private String getUri(IController controller){
        return controller.getClass().getAnnotation(ControllerMapping.class).value();
    }
}
