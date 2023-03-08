package be.kdg.nerdle.view.IntermediaryScreen;

import be.kdg.nerdle.model.User;
import be.kdg.nerdle.view.GameScreen.GameScreenPresenter;
import be.kdg.nerdle.view.GameScreen.GameScreenView;
import be.kdg.nerdle.view.HighcoreScreen.HighscoreScreenPresenter;
import be.kdg.nerdle.view.HighcoreScreen.HighscoreScreenView;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class IntermediaryScreenPresenter {
    private final IntermediaryScreenView view;
    private final User user;

    public IntermediaryScreenPresenter(IntermediaryScreenView view, User user) {
        this.view = view;
        this.user = user;
        addEventListeners();
    }

    public void addEventListeners() {
        System.out.println(user);

        view.getBtnStart().setOnMouseClicked(event -> {
            GameScreenView GameScreenView = new GameScreenView();
            new GameScreenPresenter(GameScreenView, user);
            view.getScene().setRoot(GameScreenView);
        });

        view.getBtnStats().setOnMouseClicked(event -> {
            HighscoreScreenView highscoreView = new HighscoreScreenView();
            new HighscoreScreenPresenter(highscoreView, user);

            view.getScene().setRoot(highscoreView);
            highscoreView.getScene().getWindow().setWidth(480);
            highscoreView.getScene().getWindow().setHeight(500);
        });
    }
}
