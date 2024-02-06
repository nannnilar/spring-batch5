package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentServiceAspect {
    @Before("execution(* org.example.service.MyStudentService.*(..))")
    public void beforeStudentServiceAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s's %s method is invoked",
                        joinPoint.getTarget().getClass().getSimpleName(),
                        joinPoint.getSignature().getName())
        );
    }
}
