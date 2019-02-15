package rpn.operator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

public class Undo extends Operator {

    Undo() {
        super(1);
    }

    @Override
    public void evalInternal(Stack<BigDecimal> stack, List<Operator> operationList) {
        if (!operationList.isEmpty()) {
            Operator op = operationList.remove(operationList.size()-1);
            op.undo(stack);
        }
    }

    @Override
    protected void undo(Stack<BigDecimal> stack) {}


}
