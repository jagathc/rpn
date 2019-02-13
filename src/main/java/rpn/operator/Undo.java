package rpn.operator;

import java.math.BigDecimal;
import java.util.Stack;

public class Undo extends Operator {

    Undo() {
        super(1);
    }

    @Override
    public void evalInternal(Stack<BigDecimal> stack) {
        stack.pop();
    }
}
