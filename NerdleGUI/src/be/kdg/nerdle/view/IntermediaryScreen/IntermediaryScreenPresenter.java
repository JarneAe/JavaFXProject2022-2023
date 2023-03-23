package be.kdg.nerdle.view.IntermediaryScreen;

import be.kdg.nerdle.model.User;
import be.kdg.nerdle.view.GameScreen.GameScreenPresenter;
import be.kdg.nerdle.view.GameScreen.GameScreenView;
import be.kdg.nerdle.view.HighcoreScreen.HighscoreScreenPresenter;
import be.kdg.nerdle.view.HighcoreScreen.HighscoreScreenView;
import be.kdg.nerdle.view.ProfileScreen.ProfileScreenPresenter;
import be.kdg.nerdle.view.ProfileScreen.ProfileScreenView;
import javafx.scene.control.Alert;

public class IntermediaryScreenPresenter {
    private final IntermediaryScreenView view;
    private final User user;

    public IntermediaryScreenPresenter(IntermediaryScreenView view, User user) {
        this.view = view;
        this.user = user;
        addEventListeners();
    }

    private void addEventListeners() {
        System.out.println(user);

        view.getBtnStart().setOnMouseClicked(event -> {
            if (user.hasPlayedToday()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Kan spel niet opstarten");
                alert.setHeaderText("Sorry, je hebt vandaag al gespeeld!");
                alert.setContentText("Klik OK om de melding te sluiten");
                alert.showAndWait();
            } else {
                GameScreenView GameScreenView = new GameScreenView();
                new GameScreenPresenter(GameScreenView, user);
                view.getScene().setRoot(GameScreenView);
            }


        });

        view.getBtnStats().setOnMouseClicked(event -> {
            HighscoreScreenView highscoreView = new HighscoreScreenView();
            new HighscoreScreenPresenter(highscoreView, user);

            view.getScene().setRoot(highscoreView);
            highscoreView.getScene().getWindow().setWidth(480);
            highscoreView.getScene().getWindow().setHeight(500);
        });

        view.getBtnProfile().setOnMouseClicked(event -> {
            ProfileScreenView profileScreenView = new ProfileScreenView();
            new ProfileScreenPresenter(profileScreenView, user);

            view.getScene().setRoot(profileScreenView);
            profileScreenView.getScene().getWindow().setWidth(480);
            profileScreenView.getScene().getWindow().setHeight(500);
        });
    }
}
