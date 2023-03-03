package be.kdg.nerdle.view.GameScreen;

import be.kdg.nerdle.view.NameSelector.NameSelectorView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class GameScreenPresenter {
    private final GameScreenView view;
    public GameScreenPresenter(GameScreenView view) {
        this.view = view;
        addEventListeners();
    }

    public void addEventListeners() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int finalI = i;
                int finalJ = j;
                view.getBoardPart(i, j).setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        view.getBoardPart(finalI, finalJ).setText("2");
                    }
                });
            }
        }
    }
}
