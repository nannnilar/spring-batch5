package com.example.connectionjdbctemplate.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.Connection;

@Aspect
@Component
public class DataSourceAspest {
    @Around("target(javax.sql.DataSource)")
    public Object dataSourceAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("DataSource Trace:"+joinPoint.getSignature());
        Object returnObject = joinPoint.proceed();
        if (returnObject instanceof Connection){
            return createConnectionProxy((Connection) returnObject);
        }else {
            return returnObject;
        }
    }

    private Connection createConnectionProxy(Connection connection){
        return (Connection) Proxy.newProxyInstance(
                DataSourceAspest.class.getClassLoader(),
                new Class[]{Connection.class},
                new ConnectionInvocationHandler(connection)
        );
    }
}
