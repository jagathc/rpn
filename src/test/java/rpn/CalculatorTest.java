package rpn;

import org.junit.jupiter.api.Test;
import rpn.exception.CalculationFailedException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldCalculate() {
        var calculator = new Calculator();

        calculator.processInput("1 2 3 4 5");
        assertEquals(calculator.getCurrentStackDescription(), "1 2 3 4 5");

        calculator.processInput("undo undo *");
        assertEquals(calculator.getCurrentStackDescription(), "1 6");

        calculator.processInput("3 /");
        assertEquals(calculator.getCurrentStackDescription(), "1 2");

        calculator.processInput("4 + + 5");
        assertEquals(calculator.getCurrentStackDescription(), "7 5");

        calculator.processInput("clear");
        assertEquals(calculator.getCurrentStackDescription(), "");

        calculator.processInput("2 3 -");
        assertEquals(calculator.getCurrentStackDescription(), "-1");

        calculator.processInput("clear 9 sqrt");
        assertEquals(calculator.getCurrentStackDescription(), "3");
    }

    @Test
    void shouldThrowExceptionForInsufficientParameters() {
        var calculator = new Calculator();
        var input = "2 3 + * 3";
        var exception = assertThrows(CalculationFailedException.class,
                () -> calculator.processInput(input));

        assertEquals("operator * (position: 7): insufficient parameters", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForInvalidOperator() {
        var calculator = new Calculator();
        var input = "2 3 $ 3";
        var exception = assertThrows(CalculationFailedException.class,
                () -> calculator.processInput(input));

        assertEquals("Input token $ (position: 5), not supported", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForArithmaticErrors() {
        var calculator = new Calculator();
        var input1 = "2 0 /";
        var ex1 = assertThrows(CalculationFailedException.class,
                () -> calculator.processInput(input1));

        assertEquals("operator / (position: 5): BigInteger divide by zero", ex1.getMessage());

        var input2 = "clear -1 sqrt";
        var ex2 = assertThrows(CalculationFailedException.class,
                () -> calculator.processInput(input2));
        assertEquals("operator sqrt (position: 10): Attempted square root of negative BigDecimal",
                ex2.getMessage());
    }
}