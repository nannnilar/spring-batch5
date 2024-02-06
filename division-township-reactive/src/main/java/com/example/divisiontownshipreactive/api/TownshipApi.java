package com.example.divisiontownshipreactive.api;

import com.example.divisiontownshipreactive.entity.Township;
import com.example.divisiontownshipreactive.model.TownshipForm;
import com.example.divisiontownshipreactive.service.TownshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("townships")
public class TownshipApi {
    private final TownshipService service;

    @GetMapping()
    List<Township> search(@RequestParam Optional<Integer> division,@RequestParam Optional<String> name){
        return null;
    }
    @GetMapping("{id}")
    Township findById(@PathVariable int id){
        return service.findById(id);
    }
    @PostMapping
    Township create(@RequestBody TownshipForm form){
        return service.createTownship(
                new TownshipForm(form.name(),form.divisionId())
        );
    }
    @PutMapping("{id}")
    Township update(@PathVariable int id,@RequestBody TownshipForm form){
        return service.updateTownship(
                id,
                new TownshipForm(form.name(), form.divisionId())
        );
    }

}
