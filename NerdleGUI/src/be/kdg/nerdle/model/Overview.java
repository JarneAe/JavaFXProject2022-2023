package be.kdg.nerdle.model;

import java.util.ArrayList;
import java.util.List;

public class Overview {
    private final List<Part> parts;
    public static final int LENGTH_OF_OVERVIEW = 17;

    public Overview() {
        this.parts = new ArrayList<>();
        for (String character : List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "=", "Enter", "Delete")) {
            parts.add(new Part(character));
        }
    }

    public Color getColorByIndex(int i) {
        return parts.get(i).getColor();
    }

    public void updateColors(Part[] row) {
        for (Part part : row) {
            setColor(part.getValue(), part.getColor());
        }
    }

    public void setColor(String value, Color color) {
        for (Part part : parts) {
            if (part.getValue().equals(value)) {
                part.setColor(color);
            }
        }
    }
}
