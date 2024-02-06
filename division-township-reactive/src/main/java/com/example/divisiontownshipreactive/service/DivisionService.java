package com.example.divisiontownshipreactive.service;

import com.example.divisiontownshipreactive.exceptions.LocationAppException;
import com.example.divisiontownshipreactive.model.DivisionForm;
import com.example.divisiontownshipreactive.repo.DivisionRepo;
import com.example.divisiontownshipreactive.entity.Division;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DivisionService {

    private final DivisionRepo divisionRepo;
    public List<Division> listAllDivision(){
        return divisionRepo.findAll();
    }

    public Division  findById(int id){
        return divisionRepo.findById(id).orElseThrow(() -> new LocationAppException());
    }

    public Division searchDivision(Optional<String> name,Optional<String> region){
        Specification<Division> whichRegion = region.isEmpty() ? Specification.where(null) :
                (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("region"),region.get());
        Specification<Division> whichName = name.isEmpty() ? Specification.where(null) :
                (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"),name.get().toLowerCase().concat(""));
        return divisionRepo.findAll(whichRegion,whichName);
    }
    public Division createDivision( DivisionForm form){
        return divisionRepo.save(form.entity());
    }
    @Transactional
    public Division updateDivision(int id, DivisionForm form){
       return divisionRepo.findById(id).map(entity -> {
           entity.setName(form.name());
           entity.setRegion(form.region());
           return entity;
       }).orElseThrow(() -> new LocationAppException());
    }


}
