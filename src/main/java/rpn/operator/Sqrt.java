package rpn.operator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Stack;


public class Sqrt extends Operator {

    Sqrt() {
        super(1);
    }

    @Override
    protected void evalInternal(Stack<BigDecimal> stack, List<Operator> operationList) {
        operand = stack.pop();
        stack.push(operand.sqrt(MathContext.DECIMAL64));
        if (operationList != null ) operationList.add(this);
    }

    @Override
    protected void undo(Stack<BigDecimal> stack) {
        stack.pop();
        stack.push(operand);
    }
}
