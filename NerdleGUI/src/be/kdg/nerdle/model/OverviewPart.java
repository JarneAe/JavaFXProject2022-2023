package be.kdg.nerdle.model;

public class OverviewPart {
    private String value;
    private Color color;

    public OverviewPart(String value) {
        this.value = value;
        this.color = Color.CLEAR;
    }
    public OverviewPart() {
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
