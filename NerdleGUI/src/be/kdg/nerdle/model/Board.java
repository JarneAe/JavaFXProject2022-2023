package be.kdg.nerdle.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Try> tries;

    private Overview overview;

    private String[][] board = new String[8][8];

    public Board() {
        this.tries = new ArrayList<>();
        overview = new Overview();
    }

    public List<Try> getTries() {
        return tries;
    }

    public void updateBoard(int row, int column, String value) {
        board[row][column] = value;
        System.out.println(Arrays.deepToString(board));
    }

    public boolean validateRow(int row) {
        for (int i = 0; i < 8; i++) {
            if (board[row][i] == null) {
                return false;
            }
        }

        String eqValue = String.join("", board[row]);
        try {
            Equation equation = new Equation(eqValue);
        } catch (IllegalArgumentException e){
            return false;
        }


        return true;
    }

    public void addToTries(Try t) {
        tries.add(t);
    }
}

