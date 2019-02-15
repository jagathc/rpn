package rpn.operator;

import java.math.BigDecimal;
import java.util.Stack;

public class Clear extends Operator {

    Clear() {
        super(0);
    }

    @Override
    protected void evalInternal(Stack<BigDecimal> stack, Stack<Operator> operatorStack) {
        stack.clear();
        operatorStack.clear();
    }

    @Override
    protected void undo(Stack<BigDecimal> stack) {}
}
