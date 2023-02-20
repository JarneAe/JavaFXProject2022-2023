package be.kdg.nerdle.model.jsonManager;

import be.kdg.nerdle.model.User;


public class Main {
    public static void main(String[] args) {
        User test = new User("test");
        JsonManager.writeUserToJson(test);
    }
}
