package com.example.divisiontownshipreactive.api;

import com.example.divisiontownshipreactive.entity.Division;
import com.example.divisiontownshipreactive.model.DivisionForm;
import com.example.divisiontownshipreactive.service.DivisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/divisions")
public class DivisionApi {
    private final DivisionService service;
    @GetMapping("/search")
    List<Division> search(@RequestParam Optional<String> name, @RequestParam Optional<String> region){
        return null;
    }
    @GetMapping("{id}")
    Division findById(@PathVariable int id){
        return service.findById(id);
    }

    @PostMapping("/create")
    Division create(@RequestBody DivisionForm form){
        return  service.createDivision(form);

    }
    @PutMapping("update/{id}")
    Division update(@PathVariable int id,@RequestBody DivisionForm form){
        return  service.updateDivision(id,form);

    }
    @GetMapping("/all")
    List<Division> findAll(){
        return service.listAllDivision();
    }

}
