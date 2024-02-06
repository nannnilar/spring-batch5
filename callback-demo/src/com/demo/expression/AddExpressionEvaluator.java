package com.demo.expression;

public class AddExpressionEvaluator implements ExpressionEvaluator{
    @Override
    public int evalute(int i, int j) {
        return j+i;
    }
}
