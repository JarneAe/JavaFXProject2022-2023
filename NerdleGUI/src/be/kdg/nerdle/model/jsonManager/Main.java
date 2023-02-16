package be.kdg.nerdle.model.jsonManager;

import be.kdg.nerdle.model.User;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        User bart = new User("Bart");
        User bart2 = new User("Bart2");

        List<User> userList = List.of(bart2,bart);
        System.out.println(userList);

        JsonManager manager = new JsonManager();
        manager.WriteObjectToJson(userList);
    }
}
