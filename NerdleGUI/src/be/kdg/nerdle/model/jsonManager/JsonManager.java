package be.kdg.nerdle.model.jsonManager;

import be.kdg.nerdle.model.User;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {

    Gson gson = new Gson();

    public void WriteObjectToJson(User user) throws IOException {
        try (FileWriter writer = new FileWriter("Users.json",true)) {
            gson.toJson(user, writer);
        } catch (IOException e) {
            e.printStackTrace();

        }
        }
}
