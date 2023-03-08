package be.kdg.nerdle.model;

import java.util.*;

/**
 * wrapper class for interacting with Users.json file.
 */
public class UserList {

    private final List<User> users;

    public UserList() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void addToUsers(User user) {
            users.add(user);
    }

    public List<User> generateHighScoreList() {
        Collections.sort(users);
        return users;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "users=" + users +
                '}';
    }
}
