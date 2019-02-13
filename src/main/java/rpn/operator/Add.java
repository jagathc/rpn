package rpn.operator;

import java.math.BigDecimal;
import java.util.Stack;


public class Add extends Operator {

    Add() {
        super(2);
    }

    @Override
    public void evalInternal(Stack<BigDecimal> stack) {
        stack.push(stack.pop().add(stack.pop()));
    }
}
