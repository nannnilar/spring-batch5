package com.demo.expression;

public class MultiplyExpressionEvaluator implements ExpressionEvaluator{
    @Override
    public int evalute(int i, int j) {
        return j*i;
    }
}
