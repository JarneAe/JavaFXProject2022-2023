package be.kdg.nerdle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class GameSession {

    private User user;
    public static void startSession(User user) {
        System.out.println("session started");
        System.out.println("User: " + user.toString());
    }

    public String GetFormula() {

        int dayNumber = LocalDate.now().getDayOfYear();
        System.out.println(dayNumber);
        String line = null;
        
        try {
            line = Files.readAllLines(Paths.get("formulas.txt")).get(dayNumber);
        } catch (IOException e) {
            System.out.println(e);
        }
        return line;
    }
}
