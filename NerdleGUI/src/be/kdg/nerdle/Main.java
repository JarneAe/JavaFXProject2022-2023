package be.kdg.nerdle;

import be.kdg.nerdle.view.MainMenuPresenter;
import be.kdg.nerdle.view.MainMenuView;
import be.kdg.nerdle.view.NameSelectorPresenter;
import be.kdg.nerdle.view.NameSelectorView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //MainMenuView mainMenu = new MainMenuView();
        //MainMenuPresenter presenter = new MainMenuPresenter(mainMenu);

        NameSelectorView selectorView = new NameSelectorView();
        NameSelectorPresenter presenter = new NameSelectorPresenter(selectorView);
        Scene scene = new Scene(selectorView);
        stage.setScene(scene);
        stage.setMinWidth(1000);
        stage.setMinHeight(720);
        stage.show();
    }
}
