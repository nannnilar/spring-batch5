package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductServiceAspect {

    @Pointcut("this(org.example.service.ProductService)")
    public void thisPointcut(){}

//    @Before("thisPointcut()")
    public void beforeThisPointcutAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s's method is invoked",
                        joinPoint.getTarget().getClass().getSimpleName(),
                        joinPoint.getSignature().getName())
        );
    }
}
