package rpn;

import rpn.exception.CalculationFailedException;

import java.util.Scanner;

public class Application {

    private void run() {
        var calculator = new Calculator();

        var scanner = new Scanner(System.in);

        while(true) {
            var line = scanner.nextLine();
            if (line.isBlank()) {
                return;
            }

            try {
                calculator.processInput(line);

            } catch (CalculationFailedException e) {
                System.err.println(e.getMessage());
            }

            System.out.println(String.format("stack: %s", calculator.getCurrentStackDescription()));
        }
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
