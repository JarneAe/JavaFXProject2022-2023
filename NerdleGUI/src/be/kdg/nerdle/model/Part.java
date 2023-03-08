package be.kdg.nerdle.model;

public class Part {
    private String value;
    private Color color;

    public Part(String value) {
        this.value = value;
        this.color = Color.CLEAR;
    }
    public Part() {
        this.value = "";
        this.color = Color.CLEAR;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("OverviewPart{%s, %s}", value, color);
    }
}
