package org.example;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Main2 {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        System.out.println(
                parser.parseExpression("'Hello'.concat(' ').concat('World')").getValue()
        );
        System.out.println(
                parser.parseExpression("'HelloWorld'.toUpperCase()")
                        .getValue()
        );
        System.out.println(
                parser.parseExpression("'2*3 is : '.concat( 2*3)")
                        .getValue()
        );
    }
}
