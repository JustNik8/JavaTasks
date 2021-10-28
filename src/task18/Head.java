package task18;

public class Head {
    private String haircutColor;

    public Head(String haircutColor) {
        this.haircutColor = haircutColor;
    }

    public String getHaircutColor() {
        return haircutColor;
    }

    public void setHaircutColor(String haircutColor) {
        this.haircutColor = haircutColor;
    }

    @Override
    public String toString() {
        return "Head{" +
                "haircutColor='" + haircutColor + '\'' +
                '}';
    }
}
