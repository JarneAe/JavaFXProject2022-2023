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

    public Color getColorByIndex(int i, int j) {
        return board[i][j].getColor();
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



    /*
    TODO: this function is supposed to loop through a row on the board, and assign the right colors on the board.
        to assign a color to a particular value, use board[row][i].setColor(Color)
        note that the Color passed as argument is **NOT** a JavaFX Color, but a Color as defined in
        the enum class, somewhere else in the model.
     */
    public void assignColorsToBoardParts(Equation answer, int row) {

        char[] answerList = answer.getValue().toCharArray();

        for (int i = 0; i < 8 ; i++) {

            char answerChar = answer.getValue().charAt(i);
            char userInput = board[row][i].getValue().charAt(0);
            //checks if char is in answer
            for (char c : answerList ){
                if(c == userInput){
                    board[row][i].setColor(Color.PURPLE);
                }
            }
            //checks if char on correct place
            if(answerChar == userInput){
                board[row][i].setColor(Color.GREEN);
                System.out.println(answerList);
            }
            // makes all the other tiles black
            if(board[row][i].getColor() == Color.CLEAR){
                board[row][i].setColor(Color.BLACK);
            }
        }
    }

    public boolean hasGameEnded(int row) {
        if (row == 5) return true;

        boolean correctCheck = true;

        for (OverviewPart part : board[row]) {
            System.out.println(row);
            System.out.println(part);
            if (!part.getColor().equals(Color.GREEN)) {
                correctCheck = false;
                break;
            }
        }

        return correctCheck;
    }
}

