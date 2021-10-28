package task19;

public class Fork extends Dish{

    private int teethCount;

    public Fork(String material, double cost, int teethCount) {
        super(material, cost);
        this.teethCount = teethCount;
    }

    public int getTeethCount() {
        return teethCount;
    }

    public void setTeethCount(int teethCount) {
        this.teethCount = teethCount;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, I'm Fork!");
    }
}
