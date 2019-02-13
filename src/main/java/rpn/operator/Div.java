package rpn.operator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

import static rpn.util.Scale.CALCULATION_SCALE;

public class Div extends Operator {

    Div() {
        super(2);
    }

    @Override
    public void evalInternal(Stack<BigDecimal> stack) {
        var second = stack.pop();
        var first = stack.pop();
        stack.push(first.divide(second, CALCULATION_SCALE.scale, RoundingMode.HALF_UP));
    }
}
