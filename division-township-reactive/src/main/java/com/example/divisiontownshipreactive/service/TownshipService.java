package com.example.divisiontownshipreactive.service;

import com.example.divisiontownshipreactive.entity.Township;
import com.example.divisiontownshipreactive.model.TownshipForm;
import com.example.divisiontownshipreactive.repo.TownshipRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TownshipService {

    private final TownshipRepo townshipRepo;

    public List<Township> findAll(){
        return townshipRepo.findAll();
    }
    public Township findById(int id){
        return townshipRepo.findById(id).get();
    }
    public Township createTownship(TownshipForm form){
        return townshipRepo.save(
                new Township(form.name())
        );
    }
    public Township updateTownship(int id,TownshipForm form){
        return townshipRepo.saveAndFlush(
                new Township(id,form.name())
        );
    }

}
