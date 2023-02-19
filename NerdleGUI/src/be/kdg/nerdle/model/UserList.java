package be.kdg.nerdle.model;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return "UserList{" +
                "users=" + users +
                '}';
    }
}
