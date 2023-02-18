package be.kdg.nerdle.model.jsonManager;

import be.kdg.nerdle.model.User;
import be.kdg.nerdle.model.UserAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

//        GsonBuilder builder = new GsonBuilder();
//        builder.registerTypeAdapter(User.class, new UserAdapter());
//        Gson gson = builder.create();
//
//        String jsonString = "{\"name\":\"kanker}";
//        User user = gson.fromJson(jsonString, User.class);
//        System.out.println(user);
//        jsonString = gson.toJson(user);
//        System.out.println(jsonString);

        User bart = new User("Bart");
        bart.addToScores(5);

        System.out.println(bart.getScores().toString());






//        User bart2 = new User("Bart2");
//
//        List<User> userList = List.of(bart2,bart);
//        System.out.println(userList);
//
//        JsonManager manager = new JsonManager();
//        manager.WriteObjectToJson(userList);
    }
}
