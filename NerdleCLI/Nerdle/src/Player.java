public class Player {
    private static int IDCOUNT = 0;

    public String name;
    int id;

    public Player(String name) {
        IDCOUNT++;
        this.id = IDCOUNT;
        this.name = name;
    }
    public int getId() {
        return id;
    }

}
