package be.kdg.nerdle.model.jsonManager;

import be.kdg.nerdle.model.User;
import be.kdg.nerdle.model.UserList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class JsonManager {
    /**
     * only this gson object should be used to interface with Users.json, or gson objects created exactly like this,
     * as without the TypeAdapter for LocalDate, writing to Users.json simply will not work.
     */
    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();
    private static final Path pathToUsersFile = Paths.get("./resources/Users.json");


    /**
     * Writes a single user to the Users.json file in the root of the project. This method checks if a user with the given
     * username already exists, and will not write the user to the json if this is the case
     *
     * @param user the user to write to the json file
     */
    public static void writeUserToJson(User user) {
        UserList userList = getAllUsersFromJson();

        if (!nameTaken(user.getName())) {
            assert userList != null; // avoid a NullPointerException
            userList.addToUsers(user);
            writeUserListToJson(userList);
        } else {
            System.out.printf("user with this username already exists. (%s)%n", user.getName());
        }
    }

    /**
     * private method to write a UserList object to the json file
     *
     * @param userList UserList object, typically read from the json beforehand. WARNING: if this is a new UserList object,
     *                 it will truncate the Users.json file!
     */
    private static void writeUserListToJson(UserList userList) {
        try {
            FileWriter writer = new FileWriter(pathToUsersFile.toFile());
            gson.toJson(userList, writer);
            writer.flush(); // has to be done, otherwise it doesn't want to write half the time
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * private method for getting all users from the json in the form of a UserList object
     *
     * @return UserList object with the contents of the Users.json file
     */

    public static UserList getAllUsersFromJson() {
        try (Reader reader = new FileReader(pathToUsersFile.toFile())) {
            UserList userList = gson.fromJson(reader, UserList.class);

            if (userList == null) userList = new UserList(); // deal with empty JSON file

            return userList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * method for getting a particular user out of the json file
     *
     * @param name the name of the user you are trying to get. Case-sensitive!
     * @return the User object. if the name does not match any of the entries in the json file, this will return null!
     */
    public static User getUserByName(String name) {
        for (User user : Objects.requireNonNull(getAllUsersFromJson()).getUsers()) {
            if (user.getName().equals(name)) return user;
        }

        System.out.printf("user not found in the json file. (%s)", name);
        return null;
    }

    /**
     * method to add a score entry to a user in the json file
     *
     * @param name  name of the user you are trying to update. Case-sensitive!
     * @param date  LocalDate of the date you are trying to assign a score for. Normally always LocalDate.now(), but
     *              this was kept in for testing purposes
     * @param tries integer of the number of tries you are trying to assign
     */
    public static void addToOutcomesByName(String name, LocalDate date, int tries) {
        UserList userList = getAllUsersFromJson();

        for (int i = 0; i < Objects.requireNonNull(userList).getUsers().size(); i++) {
            if (userList.getUsers().get(i).getName().equals(name))
                userList.getUsers().get(i).addToOutcomes(date, tries);
        }

        writeUserListToJson(userList);
    }

    /**
     * method to check if a name is available or not
     *
     * @param name name you are trying to check is available
     * @return True if the name is taken, false if it is not
     */
    public static boolean nameTaken(String name) {
        List<User> userList = Objects.requireNonNull(getAllUsersFromJson()).getUsers();

        for (User user : userList) {
            if (user.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    /**
     * method intended for use on the "enter username" screen. this method handles users who already exist, and
     * record new users into the Users.json file
     *
     * @param name name of the user. Input from text field, probably
     * @return User object, either read from Users.json or newly created
     */
    public static User handleEnteredUsername(String name) {
        initialize();
        if (nameTaken(name)) return getUserByName(name);
        else {
            User user = new User(name);
            writeUserToJson(user);
            return user;
        }
    }

    private static void initialize() {
        try {
            File tmpFile = pathToUsersFile.toFile();
            if (!tmpFile.exists()) {
                boolean ignored = tmpFile.createNewFile();
            }
        } catch (IOException ignored) {}
    }
}
