package rpn.operator;

import org.junit.jupiter.api.Test;
import rpn.exception.InsuffecientOperandsException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UndoTest {
    private Undo op = new Undo();

    @Test
    void shouldUndo() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(new BigDecimal(BigInteger.ONE));
        stack.push(new BigDecimal(BigInteger.TEN));

        op.evaluate(stack);

        assertEquals(stack.size(), 1);
        assertEquals(new BigDecimal(BigInteger.ONE), stack.pop());
    }

    @Test
    void shouldThrowExceptionIfNotEnoughOperands() {
        Stack<BigDecimal> stack = new Stack<>();

        assertThrows(InsuffecientOperandsException.class, () -> op.evaluate(stack));
    }
}