package rpn.operator;

import rpn.exception.InsuffecientOperandsException;

import java.math.BigDecimal;
import java.util.Stack;

public abstract class Operator {

    private int operandCount;

    Operator(int operandCount) {
        this.operandCount = operandCount;
    }

    public void evaluate(Stack<BigDecimal> stack) {
        assertOperandCount(stack);
        evalInternal(stack);
    }

    private void assertOperandCount(Stack<BigDecimal> stack) {
        if (stack.size() < operandCount) {
            throw new InsuffecientOperandsException();
        }
    }

    protected abstract void evalInternal(Stack<BigDecimal> stack);
}
