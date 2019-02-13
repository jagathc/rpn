package rpn;

import rpn.exception.CalculationFailedException;
import rpn.exception.InsuffecientOperandsException;
import rpn.exception.InvalidOperatorException;
import rpn.operator.Operator;
import rpn.operator.OperatorFactory;
import rpn.util.StringTokenizer;

import java.math.BigDecimal;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.math.RoundingMode.HALF_UP;
import static rpn.util.Scale.CALCULATION_SCALE;
import static rpn.util.Scale.DISPLAY_SCALE;

public class Calculator {
    private Stack<BigDecimal> stack = new Stack<>();

    public void processInput(String input) {
        var tokenizer = new StringTokenizer(input);

        tokenizer.stream()
                .forEach(token -> {
                    try {

                        var number = new BigDecimal(token.getValue()).setScale(CALCULATION_SCALE.scale, HALF_UP);
                        stack.push(number);
                    } catch (NumberFormatException ex) {

                        try {
                            Operator operator = OperatorFactory.getOperator(token.getValue());
                            operator.evaluate(stack);
                        } catch (InsuffecientOperandsException e) {

                            throw new CalculationFailedException(
                                    String.format("operator %s (position: %d): insufficient parameters",
                                            token.getValue(), token.getStartPosition()), e);

                        } catch (InvalidOperatorException e) {
                            throw new CalculationFailedException(
                                    String.format("Input token %s (position: %d), not supported",
                                            token.getValue(), token.getStartPosition()), e);
                        } catch (ArithmeticException e) {
                            throw new CalculationFailedException(
                                    String.format("operator %s (position: %d): %s",
                                            token.getValue(), token.getStartPosition(), e.getMessage()), e);
                        }
                    }
                });
    }

    public String getCurrentStackDescription() {
        return stack.stream()
                .map(elem -> elem.setScale(DISPLAY_SCALE.scale, HALF_UP).stripTrailingZeros().toPlainString())
                .collect(Collectors.joining(" "));
    }
}
