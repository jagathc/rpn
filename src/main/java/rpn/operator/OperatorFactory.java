package rpn.operator;

import rpn.exception.InvalidOperatorException;

import java.util.Map;
import java.util.function.Supplier;

public class OperatorFactory {
    private static Map<String, Supplier<Operator>> operatorMap = Map.of(
            "+", Add::new,
            "-", Sub::new,
            "*", Mul::new,
            "/", Div::new,
            "sqrt", Sqrt::new,
            "clear", Clear::new,
            "undo", Undo::new,
            "noop", NoOp::new
    );

    public static Operator getOperator(String operator) {
        if (operatorMap.containsKey(operator)) {
            return operatorMap.get(operator).get();
        } else {
            throw new InvalidOperatorException(operator);
        }
    }
}
