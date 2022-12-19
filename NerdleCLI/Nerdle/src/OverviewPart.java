public class OverviewPart {
    private String value;
    private Color color;

    public OverviewPart(String value) {
        this.value = value;
        this.color = Color.CLEAR;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "OverviewPart{" +
                "value='" + value + '\'' +
                ", color=" + color +
                '}';
    }
}
