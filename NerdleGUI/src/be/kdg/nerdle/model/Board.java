package be.kdg.nerdle.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Try> tries;
    private OverviewPart[][] board = new OverviewPart[6][8];

    public Board() {
        this.tries = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new OverviewPart();
            }
        }
    }

    public List<Try> getTries() {
        return tries;
    }

    public void updateBoard(int row, int column, String value) {
        board[row][column].setValue(value);
        System.out.println(Arrays.deepToString(board));
    }

    public boolean validateRow(int row) {
        for (int i = 0; i < 8; i++) {
            if (board[row][i] == null) {
                return false;
            }
        }
        StringBuilder eqValue = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            eqValue.append(board[row][i].getValue());
        }

        try {
            new Equation(eqValue.toString()); // test if the input fits into an Equation object, therefore validating it
        } catch (IllegalArgumentException e){
            return false;
        }


        return true;
    }

    public void addToTries(Try t) {
        tries.add(t);
    }
}

