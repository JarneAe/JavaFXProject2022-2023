package be.kdg.nerdle.model.jsonManager;

import be.kdg.nerdle.model.User;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        User bart = new User("Bart");
        User bart2 = new User("Bart2");
        JsonManager manager = new JsonManager();
        manager.WriteObjectToJson(bart);
        manager.WriteObjectToJson(bart2);
    }
}
