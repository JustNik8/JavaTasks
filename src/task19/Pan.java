package task19;

public class Pan extends Dish{

    private double weight;

    public Pan(String material, double cost, double weight) {
        super(material, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, I'm Pan!");
    }
}
