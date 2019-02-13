package rpn.operator;

import java.math.BigDecimal;
import java.util.Stack;


public class Sub extends Operator {

    Sub() {
        super(2);
    }

    @Override
    public void evalInternal(Stack<BigDecimal> stack) {
        var second = stack.pop();
        var first = stack.pop();
        stack.push(first.subtract(second));
    }
}
