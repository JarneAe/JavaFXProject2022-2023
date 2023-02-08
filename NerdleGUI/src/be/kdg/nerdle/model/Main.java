package be.kdg.nerdle.model;

public class Main { // testing rommel
    public static void main(String[] args) {
        User John = new User("John");
        User Tom = new User("Tom");
        GameSession session = new GameSession(John);
        //System.out.println(John.getId());
        //System.out.println(Tom.getId());

        Equation.setSizeConstraint(8);

    }
}
