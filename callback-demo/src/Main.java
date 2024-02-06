import com.demo.action.NumberAction;
import com.demo.expression.AddExpressionEvaluator;
import com.demo.expression.ExpressionEvaluator;
import com.demo.expression.MultiplyExpressionEvaluator;
import com.demo.printer.DecorateValuePrinter;
import com.demo.printer.SimpleValuePrinter;
import com.demo.printer.ValuePrinter;

public class Main {
    public static void main(String[] args) {
        ExpressionEvaluator evaluator = new MultiplyExpressionEvaluator();
        ValuePrinter printer = new DecorateValuePrinter();
        NumberAction numberAction = new NumberAction();

//        numberAction.calculate(5,evaluator,printer);
        numberAction.calculate(4,(a,b) -> a*b, t -> System.out.println(
                String.format("The value is :[%d]",t)
        ));
    }
}