package task19;

public class Plate extends Dish{
    private double diameter;

    public Plate(String material, double cost, double diameter) {
        super(material, cost);
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, I'm Plate!");
    }
}
