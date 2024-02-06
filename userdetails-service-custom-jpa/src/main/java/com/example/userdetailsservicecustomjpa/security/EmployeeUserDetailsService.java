package com.example.userdetailsservicecustomjpa.security;

import com.example.userdetailsservicecustomjpa.dao.EmployeeDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class EmployeeUserDetailsService implements UserDetailsService {
    private final EmployeeDao employeeDao;

    public EmployeeUserDetailsService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeDao.findByUserName(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found!"));

    }
}
