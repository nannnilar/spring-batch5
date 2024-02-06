package com.jdc.request.testrequest;

import lombok.Data;

import java.time.LocalDate;
@Data
public class User {

    private String name;
    private String phone;
    private String email;
    private LocalDate registeredAt;
}
