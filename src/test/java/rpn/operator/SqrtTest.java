package rpn.operator;

import org.junit.jupiter.api.Test;
import rpn.exception.InsuffecientOperandsException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {
    private Sqrt op = new Sqrt();

    @Test
    void shouldCalculateSquareRoot() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(new BigDecimal("2"));

        op.evaluate(stack);

        assertEquals(stack.size(), 1);
        assertEquals(
                new BigDecimal("1.41421356237").setScale(10, RoundingMode.HALF_UP),
                stack.pop().setScale(10, RoundingMode.HALF_UP)
                );
    }

    @Test
    void shouldThrowExceptionIfNotEnoughOperands() {
        Stack<BigDecimal> stack = new Stack<>();

        assertThrows(InsuffecientOperandsException.class, () -> op.evaluate(stack));
    }
}