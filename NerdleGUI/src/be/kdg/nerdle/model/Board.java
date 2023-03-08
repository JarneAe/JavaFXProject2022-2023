package be.kdg.nerdle.model;

import java.util.Arrays;

public class Board {
    private final Part[][] board = new Part[6][8];

    public Board() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Part();
            }
        }
    }

    public void updateBoard(int row, int column, String value) {
        board[row][column].setValue(value);
        System.out.println(Arrays.deepToString(board));
    }

    public Part[] getRow(int i) {
        return board[i];
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

        for (Part part : board[row]) {
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

