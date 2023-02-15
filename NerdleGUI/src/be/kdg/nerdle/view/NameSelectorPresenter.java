package be.kdg.nerdle.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NameSelectorPresenter {

    private NameSelectorView view;


    public NameSelectorPresenter(NameSelectorView view){
        this.view = view;
        addEventListeners();
    }

    private void addEventListeners() {
        view.getBtnConfirm().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(view.getTfUserInput().getText());
            }
        });



    }

}
