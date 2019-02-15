package rpn.operator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Clear extends Operator {

    Clear() {
        super(0);
    }

    @Override
    protected void evalInternal(Stack<BigDecimal> stack, List<Operator> operationList) {
        stack.clear();
        operationList = new ArrayList<>();
    }

    @Override
    protected void undo(Stack<BigDecimal> stack) {}
}
