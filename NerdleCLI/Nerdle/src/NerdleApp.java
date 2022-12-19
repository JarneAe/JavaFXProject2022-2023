import java.util.Scanner;

public class NerdleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Press enter to start the session...");
        sc.nextLine();

        GameSession.startSession();
    }
}
