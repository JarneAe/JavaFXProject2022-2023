import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Overview {
    private final List<OverviewPart> parts;

    public Overview() {
        this.parts = new ArrayList<>();
        for (String character : List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "=")) {
            parts.add(new OverviewPart(character));
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (OverviewPart op : parts) {
            result.append(op).append("\n");
        }

        return result.toString();
    }

    public void setColor(String value, Color color) {
        // TODO: implement this
        // OverviewPart has a setColor method
    }
}
