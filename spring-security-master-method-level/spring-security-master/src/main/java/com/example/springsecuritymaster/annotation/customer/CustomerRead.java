package com.example.springsecuritymaster.annotation.customer;

import org.springframework.security.access.annotation.Secured;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Secured(value = {"ROLE_CUSTOMER_PAGE_VIEW", "ROLE_CUSTOMER_READ","ROLE_SUPER_ADMIN"})
public @interface CustomerRead {


}
