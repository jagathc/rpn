package rpn.operator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Stack;

import static rpn.util.Scale.CALCULATION_SCALE;

public class Div extends Operator {

    Div() {
        super(2);
    }

    @Override
    public void evalInternal(Stack<BigDecimal> stack, List<Operator> operationList) {
        var second = stack.pop();
        var first = stack.pop();
        operand = second;
        stack.push(first.divide(second, CALCULATION_SCALE.scale, RoundingMode.HALF_UP));
        if (operationList != null ) operationList.add(this);
    }

    @Override
    protected void undo(Stack<BigDecimal> stack) {
        stack.push(operand);
        new Mul().evalInternal(stack, null);
    }

}
