package rpn.operator;

import org.junit.jupiter.api.Test;
import rpn.exception.InsuffecientOperandsException;

import java.math.BigDecimal;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class ClearTest {

    private Clear op = new Clear();

    @Test
    void shouldClearStack() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.ONE);
        stack.push(BigDecimal.TEN);

        op.evaluate(stack);
        assertEquals(stack.size(), 0);

        op.evaluate(stack);
        assertEquals(stack.size(), 0);
    }
}