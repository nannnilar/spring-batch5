package com.example.controllerparameter.controller;

import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.connector.ResponseFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import static com.example.controllerparameter.util.JoinUtil.*;

import java.io.IOException;

@RestController
public class NativeWebRequestDemo {

//    curl "http://localhost:8080/actionB?name=Wenddy&hobby=reading"
    @GetMapping("/actionB")
    public void nativeWebRequest(NativeWebRequest request) throws IOException {
        RequestFacade requestFacade = request.getNativeRequest(RequestFacade.class);
        ResponseFacade responseFacade = request.getNativeResponse(ResponseFacade.class);
        responseFacade.getOutputStream().println(String.format(
                "retrieved request with headers = [%s] ,parameters = [%s]",
                join(requestFacade.getHeaderNames()),
                join(requestFacade.getParameterNames())
        ));
    }
}
