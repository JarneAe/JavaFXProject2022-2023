package be.kdg.nerdle;

import java.util.Scanner;

public class NerdleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String name = sc.nextLine();

        User user = new User(name);

        System.out.print("Press enter to start the session...");
        sc.nextLine();

        GameSession.startSession(user);
    }
}
