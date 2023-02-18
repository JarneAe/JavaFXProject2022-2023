package be.kdg.nerdle.view.NameSelector;

import be.kdg.nerdle.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class NameSelectorPresenter {

    private final NameSelectorView view;


    public NameSelectorPresenter(NameSelectorView view){
        this.view = view;
        addEventListeners();
    }

    private void addEventListeners() {
        view.getBtnConfirm().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = view.getTfUserInput().getText();
                
                User User = new User(name);

                System.out.println(User);

            }
        });



    }

}
