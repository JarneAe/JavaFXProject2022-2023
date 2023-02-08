package be.kdg.nerdle;

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
        Button button = new Button("hello");
        Scene scene = new Scene(button);
        stage.setScene(scene);
        stage.setMinWidth(1000);
        stage.setMinHeight(720);
        stage.setTitle("Dictee");
        stage.show();
    }
}
