package be.kdg.nerdle.model;

import java.util.*;

/**
 * wrapper class for interacting with Users.json file.
 */
public class UserList {

    private List<User> users;

    public UserList() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void addToUsers(User user) {
            users.add(user);
    }

    public Map<String, Double> generateHighScoreList() {
        Map<String, Double> highScoreList = new TreeMap<>();
        Collections.sort(users);
        for (User user : users) {
            highScoreList.put(user.getName(), user.getAverageTries());
        }

        return highScoreList;
    }





    @Override
    public String toString() {
        return "UserList{" +
                "users=" + users +
                '}';
    }
}
