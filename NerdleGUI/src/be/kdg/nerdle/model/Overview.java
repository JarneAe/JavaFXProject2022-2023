package be.kdg.nerdle.model;

import java.util.ArrayList;
import java.util.List;

// this class will probably be deleted
public class Overview {
    private final List<OverviewPart> parts;

    public Overview() {
        this.parts = new ArrayList<>();
        for (String character : List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "=", "Enter", "Delete")) {
            parts.add(new OverviewPart(character));
        }
    }

    public OverviewPart getPartByIndex(int i) {
        return parts.get(i);
    }

    public Color getColorByIndex(int i) {
        return parts.get(i).getColor();
    }

    public void setColor(String value, Color color) {
        for (OverviewPart part : parts) {
            if (part.getValue().equals(value)) {
                part.setColor(color);
            }
        }
    }
}
