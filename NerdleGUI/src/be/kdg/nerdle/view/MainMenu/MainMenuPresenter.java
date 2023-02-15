package be.kdg.nerdle.view.MainMenu;

import be.kdg.nerdle.view.NameSelector.NameSelectorPresenter;
import be.kdg.nerdle.view.NameSelector.NameSelectorView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainMenuPresenter {
    private MainMenuView view;

    public MainMenuPresenter(MainMenuView view){
        this.view = view;
        addEventListeners();
    }

    private void addEventListeners() {
        view.getBtnStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                NameSelectorView nameSelectorView = new NameSelectorView();
                new NameSelectorPresenter(nameSelectorView);

                view.getScene().setRoot(nameSelectorView);
                //nameSelectorView.getScene().getWindow().sizeToScene();


            }
        });
    }
}