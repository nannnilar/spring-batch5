package com.example.inheritancerelationship.service;

import com.example.inheritancerelationship.dao.ExHouseVetDao;
import com.example.inheritancerelationship.dao.InHouseVetDao;
import com.example.inheritancerelationship.entity.ExHouseVet;
import com.example.inheritancerelationship.entity.InHouseVet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VetService {
    private final InHouseVetDao inHouseVetDao;
    private final ExHouseVetDao exHouseVetDao;

    public VetService(InHouseVetDao inHouseVetDao, ExHouseVetDao exHouseVetDao) {
        this.inHouseVetDao = inHouseVetDao;
        this.exHouseVetDao = exHouseVetDao;
    }
    @Transactional
    public void createDb(){
        ExHouseVet ex1 = new ExHouseVet("John Doe","PhD","England",5000);
        ExHouseVet ex2 = new ExHouseVet("Thomas Hardy","Msc","Thailand",5000);

        InHouseVet in1 = new InHouseVet("John Willaim","Bsc",2000);
        InHouseVet in2 = new InHouseVet("Richard Chan","Bsc",3000);

        inHouseVetDao.save(in1);
        inHouseVetDao.save(in2);

        exHouseVetDao.save(ex1);
        exHouseVetDao.save(ex2);
    }
}
