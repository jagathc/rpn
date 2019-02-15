package rpn.operator;

import org.junit.jupiter.api.Test;
import rpn.exception.InsuffecientOperandsException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class MulTest {
    private Mul op = new Mul();

    @Test
    void shouldMultiply() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.TEN);
        stack.push(BigDecimal.TEN);

        op.evaluate(stack, null);

        assertEquals(stack.size(), 1);
        assertEquals(stack.pop(), new BigDecimal("100"));
    }

    @Test
    void shouldThrowExceptionIfNotEnoughOperands() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.ONE);

        assertThrows(InsuffecientOperandsException.class, () -> op.evaluate(stack, null));
    }
}