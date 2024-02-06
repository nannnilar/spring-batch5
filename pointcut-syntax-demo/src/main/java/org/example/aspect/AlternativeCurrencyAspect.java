package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AlternativeCurrencyAspect {
    @Pointcut("this(org.example.service.AlternativeCurrencyService)")
    public void thisAlterCurrencyPointcut(){}

    @Pointcut("target(org.example.service.AlternativeCurrencyService)")
    public void targetAlterCurrencyPointcut(){}

    @Pointcut("within(org.example.service.*)")
    public void withinPointcut(){}

//    @After("withinPointcut()")
    public void afterAlterCurrencyAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s 's %s method invoke with %s in after advice.",
                        joinPoint.getTarget().getClass().getSimpleName(),
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }
}
