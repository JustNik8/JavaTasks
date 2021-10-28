package task20;

public class Car implements Priceable{

    private double price;

    public Car(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
