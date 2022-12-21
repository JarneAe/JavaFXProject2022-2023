package be.kdg.nerdle;

import java.util.List;
import java.util.Scanner;

public class Try {
    private int tryNumber;
    private Equation guess;
    private Scanner scanner = new Scanner(System.in);

    public Try(int tryNumber) {
        this.tryNumber = tryNumber;
    }

    public void guess() {
        Equation equation;
        String equationInput;

        do {
            equationInput = scanner.nextLine();
            List<String> lst = List.of(equationInput.split(""));
            equation = new Equation(lst);
        } while (equation.getValue() == null);

        System.out.println(equation.getValue());
        this.guess = equation;
    }

    public Equation getGuess() {
        return this.guess;
    }
}
