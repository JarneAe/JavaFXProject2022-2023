package be.kdg.nerdle.view.GameScreen;

import be.kdg.nerdle.model.*;
import be.kdg.nerdle.view.IntermediaryScreen.IntermediaryScreenPresenter;
import be.kdg.nerdle.view.IntermediaryScreen.IntermediaryScreenView;
import javafx.scene.control.Alert;

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
        // all listeners on the keyboard portion of the screen
        for (int i = 0; i < Overview.LENGTH_OF_OVERVIEW; i++) {
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
                if (session.validateRow()) {
                    System.out.println("good");
                } else {
                    System.out.println("bad");
                    break;
                }

                session.assignColorsToBoardParts();
                session.assignColorsToOverview();
                colorAssignment();

                session.nextTry();

                if (session.hasGameEnded()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Spel afgelopen");
                    alert.setHeaderText("Het spel is afgelopen!");
                    alert.setContentText("Klik OK om het spel te beëindigen.");
                    alert.showAndWait();

                    session.handleEndOfGame();
                    IntermediaryScreenView intermediaryScreenView = new IntermediaryScreenView();
                    new IntermediaryScreenPresenter(intermediaryScreenView, session.getUser());
                    view.getScene().setRoot(intermediaryScreenView);
                    break;
                }

                activeColumn = 0;

                view.getBoardPart(0, session.getCurrentTry()).setActiveStyle();
            }

            case "Delete" -> {
                if (activeColumn == 0) {
                    break;
                }

                if (activeColumn == Board.LENGTH_OF_ROW-1 && !view.getBoardPart(activeColumn, session.getCurrentTry()).getText().equals("")) {
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
                if (activeColumn < Board.LENGTH_OF_ROW-1) {
                    activeColumn++;
                }

                view.getBoardPart(activeColumn, session.getCurrentTry()).setActiveStyle();
            }
        }
    }

    public void colorAssignment() {
        for (int i = 0; i < Board.LENGTH_OF_ROW; i++) {
            Color color = session.getColorByBoardIndex(session.getCurrentTry(), i);
            view.getBoardPart(i, session.getCurrentTry()).setCustomColor(color);
        }

        for (int i = 0; i < Overview.LENGTH_OF_OVERVIEW; i++) {
            Color color = session.getColorByOverviewIndex(i);
            view.getKeyboardPart(i).setCustomColor(color);
        }
    }
}
