package rpn.operator;

import org.junit.jupiter.api.Test;
import rpn.exception.InsuffecientOperandsException;

import java.math.BigDecimal;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SubTest {

    private Sub op = new Sub();

    @Test
    void shouldSubtract() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.ONE);
        stack.push(BigDecimal.TEN);

        op.evaluate(stack, null);

        assertEquals(stack.size(), 1);
        assertEquals(stack.pop(), new BigDecimal("-9"));
    }

    @Test
    void shouldThrowExceptionIfNotEnoughOperands() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.ONE);

        assertThrows(InsuffecientOperandsException.class, () -> op.evaluate(stack, null));
    }
}