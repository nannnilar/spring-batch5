package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.*;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        context.registerShutdownHook();

        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setBeanResolver(new BeanFactoryResolver(context));
        ExpressionParser parser = new SpelExpressionParser();

        System.out.println(
                parser.parseExpression("@bean2.taxCount")
                        .getValue(evaluationContext)
        );
        System.out.println(
                parser.parseExpression("@springBean1.appName")
                        .getValue(evaluationContext)
        );
    }
}
