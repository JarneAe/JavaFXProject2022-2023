import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;

public class GameSession {
    public static void startSession() {
        System.out.println("session started");
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
