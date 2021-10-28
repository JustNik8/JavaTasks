package task18;

public class Leg {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "type='" + type + '\'' +
                '}';
    }
}
