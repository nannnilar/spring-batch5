package org.example.withoutaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class PerformanceAspect {
    @Around(("@annotation(org.example.withoutaop.annotation.PerformanceLogger)"))
    public  Object performanceTest(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            long endTime =  System.currentTimeMillis();
            System.out.println(
                    String.format(
                            "%s method invoking takes time %d miliseconds.",
                            joinPoint.getSignature().getName(),
                            (endTime-startTime)
                    )
            );
        }
        return null;
    }
}
