package be.kdg.nerdle.model.jsonManager;

import be.kdg.nerdle.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class JsonManager {

    Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

    public void WriteObjectToJson(List<User> userList) throws IOException {
        try (FileWriter writer = new FileWriter("Users.json")) {
            gson.toJson(userList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
