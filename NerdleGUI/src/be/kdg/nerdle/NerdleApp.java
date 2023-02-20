package be.kdg.nerdle;

import be.kdg.nerdle.view.GameScreen.GameScreenView;
import be.kdg.nerdle.view.MainMenu.MainMenuPresenter;
import be.kdg.nerdle.view.MainMenu.MainMenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NerdleApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        MainMenuView mainMenu = new MainMenuView();
        new MainMenuPresenter(mainMenu);
        Scene scene = new Scene(mainMenu);

        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setMinWidth(250);
        stage.setHeight(720);
        stage.setMinHeight(250);
        stage.setTitle("Nerdle");
        stage.show();
    }
}
