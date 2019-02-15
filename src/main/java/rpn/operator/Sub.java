package rpn.operator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;


public class Sub extends Operator {

    Sub() {
        super(2);
    }

    @Override
    public void evalInternal(Stack<BigDecimal> stack, List<Operator> operationList) {
        var second = stack.pop();
        var first = stack.pop();
        operand = second;
        stack.push(first.subtract(second));
        if (operationList != null ) operationList.add(this);
    }

    @Override
    protected void undo(Stack<BigDecimal> stack) {
        stack.push(operand);
        new Add().evalInternal(stack, null);
    }

}
