package rpn.operator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Stack;


public class Sqrt extends Operator {

    Sqrt() {
        super(1);
    }

    @Override
    public void evalInternal(Stack<BigDecimal> stack) {
        stack.push(stack.pop().sqrt(MathContext.DECIMAL64));
    }
}
