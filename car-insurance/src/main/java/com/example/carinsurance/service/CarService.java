package com.example.carinsurance.service;

import com.example.carinsurance.dao.CarDao;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private CarDao carDao;

    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }
    public void createDb(){

    }
}
