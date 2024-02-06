package com.example.controllerparameter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.TimeZone;

@RestController
public class LocaleDemo {
    @GetMapping("/actionH")
    public String actionH(Locale locale){
        return String.format("Locale Name: [%s]",locale.getDisplayName());
    }

    @GetMapping("/actionI")
    public String actionI(TimeZone timeZone){
        return String.format("Timezone : [%s], ZoneId : [%s]",
                timeZone.getDisplayName(),
                timeZone.getID());
    }
}
