import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Try> tries;

    public Board() {
        this.tries = new ArrayList<>();
    }
    public void drawBoard() {
        System.out.println("drawing board");
    }

    public void addToTries(Try t) {
        tries.add(t);
    }
}
