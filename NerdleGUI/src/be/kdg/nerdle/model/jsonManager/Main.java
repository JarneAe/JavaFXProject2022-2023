package be.kdg.nerdle.model.jsonManager;

import be.kdg.nerdle.model.User;


public class Main {
    public static void main(String[] args) {
        User bart = new User("Bart");
        int test = 3;
        JsonManager manager = new JsonManager(bart);
        System.out.println(bart);
    }
}
