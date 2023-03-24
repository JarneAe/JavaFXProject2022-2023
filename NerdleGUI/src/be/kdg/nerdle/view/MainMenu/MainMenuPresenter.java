package be.kdg.nerdle.view.MainMenu;

import be.kdg.nerdle.view.NameSelector.NameSelectorPresenter;
import be.kdg.nerdle.view.NameSelector.NameSelectorView;

public class MainMenuPresenter {
    private final MainMenuView view;

    public MainMenuPresenter(MainMenuView view) {
        this.view = view;
        addEventListeners();
    }

    private void addEventListeners() {
        view.getBtnStart().setOnAction(actionEvent -> {
            NameSelectorView nameSelectorView = new NameSelectorView();
            new NameSelectorPresenter(nameSelectorView);

            view.getScene().setRoot(nameSelectorView);
        });
    }
}