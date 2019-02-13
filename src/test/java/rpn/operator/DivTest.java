package rpn.operator;

import org.junit.jupiter.api.Test;
import rpn.exception.InsuffecientOperandsException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DivTest {
    private Div op = new Div();

    @Test
    void shouldDivide() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.ONE);
        stack.push(BigDecimal.TEN);

        op.evaluate(stack);

        assertEquals(stack.size(), 1);
        assertEquals(new BigDecimal("0.1").setScale(10, RoundingMode.HALF_UP),
                stack.pop().setScale(10, RoundingMode.HALF_UP));
    }

    @Test
    void shouldThrowExceptionIfNotEnoughOperands() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.ONE);

        assertThrows(InsuffecientOperandsException.class, () -> op.evaluate(stack));
    }

    @Test
    void shouldThrowExceptionIfDividedByZero() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.ONE);
        stack.push(BigDecimal.ZERO);

        assertThrows(ArithmeticException.class, () -> op.evaluate(stack));
    }
}