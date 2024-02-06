package org.example;

import org.example.ds.CurrencyName;
import org.example.service.AlternativeCurrencyService;
import org.example.service.CurrencyService;
import org.example.service.MyCurrencyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        AlternativeCurrencyService alternativeCurrencyService =
                 context.getBean(AlternativeCurrencyService.class);
        alternativeCurrencyService.getCurrencyCount(200.0);

        CurrencyService currencyService = context.getBean(CurrencyService.class);
        currencyService.getCurrenciesCount(500);

        MyCurrencyService myCurrencyService = context.getBean(MyCurrencyService.class);
        myCurrencyService.changeCurrency(2.9);
        myCurrencyService.changeCurrency(2.3,4.6);
        myCurrencyService.getCurrencyName(CurrencyName.US);
        myCurrencyService.getCurrencyCountryName(CurrencyName.US);
        try{
            myCurrencyService.getCurrencyCountryName(CurrencyName.EURO);
        }catch (IllegalArgumentException e){
            System.out.println("Exception is caught.");
        }


    }
}