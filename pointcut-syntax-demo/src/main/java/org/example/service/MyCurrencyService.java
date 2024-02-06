package org.example.service;

import org.example.annotation.Secured;
import org.example.annotation.Transcation;
import org.example.ds.CurrencyName;
import org.springframework.stereotype.Component;

@Component("currency_service") @Secured
public class MyCurrencyService {
    public void changeCurrency(double num1, double num2){
//        return 0;
    }

    public void changeCurrency(double num1){

    }
    @Transcation
    public String getCurrencyCountryName(CurrencyName currencyName){
        if (currencyName.name().equals("US")){
            return "US";
        }else
            throw new IllegalArgumentException("Error");
    }
//    @Transcation
    public String getCurrencyName(CurrencyName currencyName){
        return "US";
    }
}
