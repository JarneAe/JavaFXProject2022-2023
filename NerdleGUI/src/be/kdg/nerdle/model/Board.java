package be.kdg.nerdle.model;

import java.util.Arrays;

public class Board {
    public static final int ROWS = 6;
    public static final int LENGTH_OF_ROW = 8;
    private final Part[][] board = new Part[ROWS][LENGTH_OF_ROW];

    public Board() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < LENGTH_OF_ROW; j++) {
                board[i][j] = new Part();
            }
        }
    }

    public void updateBoard(int row, int column, String value) {
        board[row][column].setValue(value);
    }

    public Part[] getRow(int i) {
        return board[i];
    }

    public Color getColorByIndex(int i, int j) {
        return board[i][j].getColor();
    }

    /**
     * checks if a row on the board is a valid Equation (as defined in the Equation class) and has a length of 8 characters.
     * @param row the index of a row on the board
     * @return true, if the row is a valid equation. False, if it is not.
     */
    public boolean validateRow(int row) {
        for (int i = 0; i < LENGTH_OF_ROW; i++) {
            if (board[row][i] == null) {
                return false;
            }
        }
        StringBuilder eqValue = new StringBuilder();
        for (int i = 0; i < LENGTH_OF_ROW; i++) {
            eqValue.append(board[row][i].getValue());
        }

        try {
            new Equation(eqValue.toString()); // test if the input fits into an Equation object, therefore validating it
        } catch (IllegalArgumentException e){
            return false;
        }


        return true;
    }

    public void assignColorsToBoardParts(Equation answer, int row) {

        char[] answerList = answer.value().toCharArray();

        for (int i = 0; i < LENGTH_OF_ROW; i++) {

            char answerChar = answer.value().charAt(i);
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
                System.out.println("Answer: "+ Arrays.toString(answerList));
            }
            // makes all the other tiles black
            if(board[row][i].getColor() == Color.CLEAR){
                board[row][i].setColor(Color.BLACK);
            }
        }
    }

    public boolean hasGameEnded(int row) {
        if (row == ROWS-1) return true;

        boolean correctCheck = true;

        for (Part part : board[row]) {
            if (!part.getColor().equals(Color.GREEN)) {
                correctCheck = false;
                break;
            }
        }

        return correctCheck;
    }
}

