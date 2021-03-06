package rpn.operator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Stack;


public class Sqrt extends Operator {

    Sqrt() {
        super(1);
    }

    @Override
    protected void evalInternal(Stack<BigDecimal> stack, Stack<Operator> operatorStack) {
        operand = stack.pop();
        stack.push(operand.sqrt(MathContext.DECIMAL64));
        if (operatorStack != null ) operatorStack.push(this);
    }

    @Override
    protected void undo(Stack<BigDecimal> stack) {
        stack.pop();
        stack.push(operand);
    }
}
