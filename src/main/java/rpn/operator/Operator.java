package rpn.operator;

import rpn.exception.InsuffecientOperandsException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

public abstract class Operator {

    private int operandCount;
    protected BigDecimal operand;

    Operator(int operandCount) {
        this.operandCount = operandCount;
    }

    public void evaluate(Stack<BigDecimal> stack, List<Operator> operationList) {
        assertOperandCount(stack);
        evalInternal(stack, operationList);
    }

    private void assertOperandCount(Stack<BigDecimal> stack) {
        if (stack.size() < operandCount) {
            throw new InsuffecientOperandsException();
        }
    }

    protected abstract void evalInternal(Stack<BigDecimal> stack, List<Operator> operationList);

    protected abstract void undo(Stack<BigDecimal> stack);
}
