package rpn.operator;

import java.math.BigDecimal;
import java.util.Stack;


public class Add extends Operator {

    Add() {
        super(2);
    }

    @Override
    public void evalInternal(Stack<BigDecimal> stack, Stack<Operator> operatorStack) {
        operand = stack.pop();
        stack.push(operand.add(stack.pop()));
        if (operatorStack != null ) operatorStack.push(this);
    }

    @Override
    protected void undo(Stack<BigDecimal> stack) {
        stack.push(operand);
        new Sub().evalInternal(stack, null);
    }
}
