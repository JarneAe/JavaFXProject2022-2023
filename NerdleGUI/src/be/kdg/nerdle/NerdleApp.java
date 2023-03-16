package be.kdg.nerdle;

import be.kdg.nerdle.view.MainMenu.MainMenuPresenter;
import be.kdg.nerdle.view.MainMenu.MainMenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.mariuszgromada.math.mxparser.License;

public class NerdleApp extends Application {
    public static void main(String[] args) {
        // start point of the app needs to do this otherwise they won't shut up about licenses
        License.iConfirmNonCommercialUse("Rob Hellemans");
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        MainMenuView mainMenu = new MainMenuView();
        new MainMenuPresenter(mainMenu);
        Scene scene = new Scene(mainMenu);

        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setMinWidth(500);
        stage.setHeight(720);
        stage.setMinHeight(500);
        stage.setTitle("Nerdle");
        stage.show();
    }
}
