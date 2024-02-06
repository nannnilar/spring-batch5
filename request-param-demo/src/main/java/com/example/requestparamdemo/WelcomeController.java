package com.example.requestparamdemo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class WelcomeController {
//    curl http://localhost:8080/show-info/v5/country/Myanmar/city/Yangon

    @GetMapping(value = {"/show-info/v5/country/{country}/city/{city}",
    "show-info/v5/country/{country}"})
    public String showInfoV5(@PathVariable("country")String country,
                             @PathVariable(value ="city")Optional <String> city){
        return String.format("Country:[%s],City:[%s]",
                country,city.orElse("Yangon"));
    }

    @GetMapping("/show-info/v1")
    public String showInfoV1(@RequestParam("name") String name,
                             @RequestParam("city") String city,
                             @RequestParam(value = "hobby", required = false) String hobby){

        return String.format(
                "Name:[%s],City:[%s],Hobby:[%s]",
                name,city,hobby
        );
    }
//    curl "http://localhost:8080/show-info/v2?name=Sofia&city=New+York&hobby=Fishing"
    @GetMapping("/show-info/v2")
    public String showInfoV2(@RequestParam("name") String name,
                             @RequestParam("city") String city,
                             @RequestParam(value = "hobby") Optional<String> hobby){

        return String.format(
                "Name:[%s],City:[%s],Hobby:[%s]",
                name,city,hobby.orElse("Swimming")
        );
    }
//    curl -X POST "http://localhost:8080/show-info/v3?numbers=1,2,3,4,5"
    @PostMapping("/show-info/v3")
    public String showInfoV3(@RequestParam ("numbers")List<String> numbers){
        return String.format(
                "Numbers: %s",numbers
        );
    }
//    curl "http://localhost:8080/show-info/v4?city=Ygn&name=MG&hobby=Swimming
    @GetMapping("/show-info/v4")
    public String showInfoV4(@RequestParam Map<String,String> parameters){
        return String.format(
                " %s",parameters
        );
    }
}
