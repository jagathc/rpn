package rpn.operator;

import org.junit.jupiter.api.Test;
import rpn.exception.InsuffecientOperandsException;

import java.math.BigDecimal;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {

    private Add op = new Add();

    @Test
    void shouldAddTwoOperands() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.ONE);
        stack.push(BigDecimal.TEN);

        op.evaluate(stack, null);

        assertEquals(stack.size(), 1);
        assertEquals(stack.pop(), new BigDecimal("11"));
    }

    @Test
    void shouldThrowExceptionIfNotEnoughOperands() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.ONE);

        assertThrows(InsuffecientOperandsException.class, () -> op.evaluate(stack, null));
    }
}