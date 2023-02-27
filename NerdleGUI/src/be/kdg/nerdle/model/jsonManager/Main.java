package be.kdg.nerdle.model.jsonManager;

import be.kdg.nerdle.model.User;
import be.kdg.nerdle.model.UserList;

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
//        User test = new User("test2");
//        test.addToOutcomes(LocalDate.of(2022, 3, 3), 6);
//        test.addToOutcomes(LocalDate.now(), 4);
//        JsonManager.writeUserToJson(test);
//        System.out.println(test.getAverageTries());

        UserList users = JsonManager.getAllUsersFromJson();
        assert users != null;
        System.out.println(users.generateHighScoreList());
    }
}
