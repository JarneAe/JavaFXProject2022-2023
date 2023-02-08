package be.kdg.nerdle.model;

public class Try {
    private int tryNumber;
    private Equation guess;

    public Try(int tryNumber) {
        this.tryNumber = tryNumber;
    }

    public Equation getGuess() {
        return this.guess;
    }
}

