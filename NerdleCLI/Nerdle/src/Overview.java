import java.util.ArrayList;
import java.util.List;

public class Overview {
    private final List<OverviewPart> parts;

    public Overview() {
        this.parts = new ArrayList<>();
        for (String character : List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "=")) {
            parts.add(new OverviewPart(character));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (OverviewPart op : parts) {
            result.append(op).append("\n");
        }

        return result.toString();
    }

    public void display() {
        for (OverviewPart part : parts) {
            if (part.getColor() == Color.CLEAR) {
                System.out.print(ConsoleColors.RESET);

            } else if (part.getColor() == Color.GREEN) {
                System.out.print(ConsoleColors.GREEN);

            } else if (part.getColor() == Color.PURPLE) {
                System.out.print(ConsoleColors.PURPLE);

            } else if (part.getColor() == Color.BLACK) {
                System.out.print(ConsoleColors.BLACK);
            }

            System.out.print(part.getValue() + " ");
        }

        System.out.println();
    }

    public void setColor(String value, Color color) {
        for (OverviewPart part : parts) {
            if (part.getValue().equals(value)) {
                part.setColor(color);
            }
        }
    }
}
