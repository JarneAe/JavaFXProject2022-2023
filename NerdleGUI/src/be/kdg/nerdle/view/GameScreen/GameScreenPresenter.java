package be.kdg.nerdle.view.GameScreen;

import be.kdg.nerdle.model.GameSession;
import be.kdg.nerdle.model.User;

public class GameScreenPresenter {
    private final GameScreenView view;
    private int activeColumn;
    private final GameSession session;
    public GameScreenPresenter(GameScreenView view, User user) {
        this.view = view;
        session = new GameSession(user);
        view.getBoardPart(session.getCurrentTry(), 0).setActiveStyle();
        addEventListeners();
    }

    public void addEventListeners() {

        // all listeners for board portion of the screen
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int finalI = i;
                int finalJ = j;
                view.getBoardPart(i, j).setOnMouseClicked(event -> {
                    view.getBoardPart(finalI, finalJ).setText("2");
                    System.out.println(view.getKeyboardPart(2).getText()); // testing
                    view.getBoardPart(1, 1).setActiveStyle();
                });
            }
        }


        // all listeners on the keyboard portion of the screen
        for (int i = 0; i < 17; i++) {
            int finalI = i;
            view.getKeyboardPart(i).setOnMouseClicked(event ->
                    handleKeyboardClick(view.getKeyboardPart(finalI).getText())
            );

            view.getKeyboardPart(i).setOnMouseEntered(event -> view.getKeyboardPart(finalI).setHoverStyle());

            view.getKeyboardPart(i).setOnMouseExited(event -> view.getKeyboardPart(finalI).setInactiveStyle());
        }
    }

    public void handleKeyboardClick(String value) {
        switch (value) {
            case "Enter" -> {
                // TODO enter implementation
                if (session.validateRow()) {
                    System.out.println("good");
                } else {
                    System.out.println("bad");
                }
            }

            case "Delete" -> {
                if (activeColumn == 0) {
                    break;
                }

                if (activeColumn == 7 && !view.getBoardPart(activeColumn, session.getCurrentTry()).getText().equals("")) {
                    view.getBoardPart(activeColumn, session.getCurrentTry()).setText("");
                    session.updateBoard(activeColumn, null);
                    break;
                }
                view.getBoardPart(activeColumn-1, session.getCurrentTry()).setText("");
                session.updateBoard(activeColumn-1, null);
                view.getBoardPart(activeColumn, session.getCurrentTry()).setInactiveStyle();
                activeColumn--;
                view.getBoardPart(activeColumn, session.getCurrentTry()).setActiveStyle();
            }

            default -> {
                BoardPart currentBp = view.getBoardPart(activeColumn, session.getCurrentTry());
                currentBp.setText(value);
                session.updateBoard(activeColumn, value);
                currentBp.setInactiveStyle();
                if (activeColumn < 7) {
                    activeColumn++;
                }

                view.getBoardPart(activeColumn, session.getCurrentTry()).setActiveStyle();
            }
        }
    }
}
