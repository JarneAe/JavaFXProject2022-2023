package be.kdg.nerdle.model.jsonManager;

import be.kdg.nerdle.model.User;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonManager {

    Gson gson = new Gson();

    public void WriteObjectToJson(List<User> userList) throws IOException {
        try (FileWriter writer = new FileWriter("Users.json",true)) {
            gson.toJson(userList, writer);
        } catch (IOException e) {
            e.printStackTrace();

        }
        }
}
