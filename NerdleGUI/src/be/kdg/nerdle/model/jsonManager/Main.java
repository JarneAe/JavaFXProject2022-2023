package be.kdg.nerdle.model.jsonManager;

import be.kdg.nerdle.model.User;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        User bart = new User("Bart");
        JsonManager manager = new JsonManager();
        System.out.println(bart);
        manager.WriteObjectToJson(bart);
    }
}
