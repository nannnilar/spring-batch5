package com.example.springsecuritymaster.annotation.department;

import jakarta.annotation.security.RolesAllowed;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RolesAllowed( value = {"DEPARTMENT_PAGE_VIEW", "DEPARTMENT_READ", "DEPARTMENT_CREATE","SUPER_ADMIN"})
public @interface DepartmentRead {
}
