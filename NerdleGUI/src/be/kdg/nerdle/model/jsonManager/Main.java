package be.kdg.nerdle.model.jsonManager;

import be.kdg.nerdle.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        User bart = new User("Bart");
        bart.addToScores(5);

        User bart2 = new User("nog is bart");
        bart2.addToScores(3);

        JsonManager jsonManager = new JsonManager();
        jsonManager.WriteObjectToJson(List.of(bart, bart2));
    }
}
