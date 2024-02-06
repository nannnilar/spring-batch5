package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.expression.ExpressionParser;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MyCurrencyServiceAspect {
    @Pointcut("@within(org.example.annotation.Secured)")
    public void withAnnotationPointcut(){}

    @Pointcut("within(org.example.service.*)")
    public void withinPointcut(){}

    @Pointcut("@annotation(org.example.annotation.Transcation)")
    public void annotationPointcut(){}

    @Pointcut("bean(currency_service)")
    public void beanPointcut(){}

    @Pointcut("args(double , double )")
    public void argsPointcut(){}

    @Pointcut("@args(org.example.annotation.CurrencyType)")
    public void argsAnnotationPointcut(){}

    @Pointcut("@target(org.example.annotation.Secured)")
    public void targetAnnotationPointcut(){}

    @Pointcut("execution(!public * org.example.service.*.*(..))")
    public void executionPointcut(){}

//    @Around("executionPointcut()")
    public Object arroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        Object obj = null;
        System.out.println(
                String.format("%s 's %s method invoke with %s in BeforeAdvice.",
                        joinPoint.getTarget().getClass().getSimpleName(),
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
        try {
            obj = joinPoint.proceed();
            System.out.println("Return Type:" + obj);
        } catch (Throwable e){
            System.out.println(e);
        } finally {
            System.out.println(
                    String.format("%s 's %s method invoke with %s in AfterAdvice.",
                            joinPoint.getTarget().getClass().getSimpleName(),
                            joinPoint.getSignature().getName(),
                            Arrays.toString(joinPoint.getArgs()))
            );
        }
        return obj;
    }

//    @After("targetAnnotationPointcut()")
    public void afterAnnotationAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s 's %s method invoke with %s in AfterAdvice.",
                        joinPoint.getTarget().getClass().getSimpleName(),
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }

//    @AfterReturning(value = "withAnnotationPointcut()",returning = "value")
    public void afterReturningWithinAnnotationAdvice(JoinPoint joinPoint, Object value){
        System.out.println(
                String.format("%s 's %s method invoke with %s in AfterReturningAdvice "
                        +"advice return value is %s",
                        joinPoint.getTarget().getClass().getSimpleName(),
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        value)
        );
    }

//    @AfterThrowing(  value = "withAnnotationPointcut()" ,throwing = "exception")
    public void afterThrowingWithinAnnotationAdvice(JoinPoint joinPoint, Exception exception){
        System.out.println(
                String.format("%s 's %s method invoke with %s in AfterThrowingAdvice.",
                        joinPoint.getTarget().getClass().getSimpleName(),
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
        System.out.println("Error Message:" + exception.getMessage());
        System.out.println("Error Class:" +exception.getClass().getSimpleName());
    }

//    @Before("withAnnotationPointcut()")
    public void beforeWithAnnotationAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s 's %s method invoke with %s in before advice.",
                        joinPoint.getTarget().getClass().getSimpleName(),
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }
}
