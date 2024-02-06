package com.example.divisiontownshipreactive.model;

import com.example.divisiontownshipreactive.entity.Division;

public record DivisionForm(
        String name,
        String region
) {
    public Division entity(){
        var entity = new Division();
        entity.setName(name);
        entity.setRegion(region);
        return entity;
    }
}
