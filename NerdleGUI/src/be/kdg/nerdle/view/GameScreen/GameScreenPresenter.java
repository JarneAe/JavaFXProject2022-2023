package be.kdg.nerdle.view.GameScreen;

import be.kdg.nerdle.model.Color;
import be.kdg.nerdle.model.GameSession;
import be.kdg.nerdle.model.User;
import be.kdg.nerdle.view.HighcoreScreen.HighscoreScreenPresenter;
import be.kdg.nerdle.view.HighcoreScreen.HighscoreScreenView;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
            for (int j = 0; j < 6; j++) {
                view.getBoardPart(i, j).setOnMouseClicked(event -> view.getBoardPart(1, 1).setActiveStyle());
            }
        }


        // all listeners on the keyboard portion of the screen
        for (int i = 0; i < 17; i++) {
            int finalI = i;
            view.getKeyboardPart(i).setOnMouseClicked(event ->
                    handleKeyboardClick(view.getKeyboardPart(finalI).getText())
            );

            view.getKeyboardPart(i).setOnMouseEntered(event -> view.getKeyboardPart(finalI).setHoverStyle(session.getColorByOverviewIndex(finalI)));

            view.getKeyboardPart(i).setOnMouseExited(event -> view.getKeyboardPart(finalI).setInactiveStyle(session.getColorByOverviewIndex(finalI)));
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
                    break;
                }

                session.assignColorsToBoardParts();
                colorAssignment();

                session.nextTry();

                if (session.hasGameEnded()) {
                    // TODO handle game end
                    System.out.println("game ended!");
                    break;
                }

                activeColumn = 0;

                view.getBoardPart(0, session.getCurrentTry()).setActiveStyle();
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
                view.getBoardPart(activeColumn - 1, session.getCurrentTry()).setText("");
                session.updateBoard(activeColumn - 1, null);
                view.getBoardPart(activeColumn, session.getCurrentTry()).setInactiveStyle(session.getColorByBoardIndex(session.getCurrentTry(), activeColumn));
                activeColumn--;
                view.getBoardPart(activeColumn, session.getCurrentTry()).setActiveStyle();
            }

            default -> {
                view.getBoardPart(activeColumn, session.getCurrentTry()).setText(value);
                session.updateBoard(activeColumn, value);
                view.getBoardPart(activeColumn, session.getCurrentTry()).setInactiveStyle(session.getColorByBoardIndex(session.getCurrentTry(), activeColumn));
                if (activeColumn < 7) {
                    activeColumn++;
                }

                view.getBoardPart(activeColumn, session.getCurrentTry()).setActiveStyle();
            }
        }
    }

    public void colorAssignment() {
        for (int i = 0; i < 8; i++) {
            Color color = session.getColorByBoardIndex(session.getCurrentTry(), i);
            view.getBoardPart(i, session.getCurrentTry()).setCustomColor(color);
        }

        for (int i = 0; i < 17; i++) {
            Color color = session.getColorByOverviewIndex(i);
            view.getKeyboardPart(i).setCustomColor(color);
        }
    }
}
