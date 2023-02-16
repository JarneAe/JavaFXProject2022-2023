package be.kdg.nerdle.model.jsonManager;

import be.kdg.nerdle.model.User;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {

    private Gson gson = new Gson();


    public void WriteObjectToJson(User user) throws IOException {
        gson.toJson(user, new FileWriter("Users.json"));
    }
}
