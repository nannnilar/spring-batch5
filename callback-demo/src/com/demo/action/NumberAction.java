package com.demo.action;

import com.demo.ds.Pair;
import com.demo.expression.ExpressionEvaluator;
import com.demo.printer.ValuePrinter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberAction {
    public void calculate(int n, ExpressionEvaluator evaluator, ValuePrinter printer){
        List<Pair> pairs = generatePair(n);
        for (Pair pair: pairs){
            printer.print(
                    evaluator.evalute(pair.getI(), pair.getJ())
            );

        }
    }

    private static List<Pair> generatePair(int n){
        return IntStream.range(1,n+1)
                .mapToObj(p -> new Pair(p, p+1))
                .collect(Collectors.toList());
    }
}
