package rpn.operator;

import java.math.BigDecimal;
import java.util.Stack;


public class Mul extends Operator {

    Mul() {
        super(2);
    }

    @Override
    public void evalInternal(Stack<BigDecimal> stack) {
        stack.push(stack.pop().multiply(stack.pop()));
    }
}
