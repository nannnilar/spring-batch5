package com.example.transactionbalancedemo;

import com.example.transactionbalancedemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionBalanceDemoApplication implements CommandLineRunner {
    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(TransactionBalanceDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String counter = "";
        try {
            accountService.transfer("Mary","John",3000);
            accountService.accountList().forEach(System.out::println);
        }catch (Exception e){
            System.out.println("Caught!!");
        }

        /*System.out.println("John Balance..."+ accountService.getBalance("John"));
        accountService.withdraw("John",7000);
        System.out.println("John Balance..."+ accountService.getBalance("John"));*/
       /* do {
            System.out.println("1.Withdraw");
            System.out.println("2.Deposit");
            System.out.println("3.Transfer");
            System.out.println("exit");
            System.out.print("Enter number what you want to perform:");

            int doAction = 0;
            switch (doAction){
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }

            }
        }while (counter.equals("exit"));*/
    }
}
