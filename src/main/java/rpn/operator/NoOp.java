package rpn.operator;

import java.math.BigDecimal;
import java.util.Stack;

public class NoOp extends Operator {

    NoOp() {
        super(0);
    }

    @Override
    protected void evalInternal(Stack<BigDecimal> stack, Stack<Operator> operatorStack) {
        operand = stack.pop();
        stack.push(operand);
        if (operatorStack != null ) operatorStack.push(this);
    }

    @Override
    protected void undo(Stack<BigDecimal> stack) {
        stack.pop();
    }

}
