package be.kdg.nerdle;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Try> tries;

    private Overview overview;

    public Board() {
        this.tries = new ArrayList<>();
        overview = new Overview();
    }

    public List<Try> getTries() {
        return tries;
    }

    public void drawBoard() {
        for (Try t : tries) {
            System.out.println(t.getGuess());
        }

        System.out.println("\nOverview: ");
        overview.display();
    }

    public void addToTries(Try t) {
        tries.add(t);
    }
}
