package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CurrencyServiceAspect {
    @Pointcut("this(org.example.service.CurrencyService)")
    public void thisCurrencyPointCut(){ }
    @Pointcut("target(org.example.service.CurrencyService)")
    public void targetCurrencyPointCut(){}
    @Pointcut("this(org.example.service.CurrencyServiceImpl)")
    public void thisCurrencyImplPointCut(){}
    @Pointcut("target(org.example.service.CurrencyServiceImpl)")
    public void targetCurrencyImplPointCut(){}

    @Before("targetCurrencyImplPointCut()")
    public void beforeCurrencyAdvice(JoinPoint joinPoint) throws Throwable{
        System.out.println(
                String.format(
                        "%s method innvoke before advice with - %s",
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs())
                )
        );
    }
}
