package task18;

public class Arm {
    private String type;
    Hand hand = new Hand();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Arm{" +
                "type='" + type + '\'' +
                ", hand=" + hand +
                '}';
    }
}
