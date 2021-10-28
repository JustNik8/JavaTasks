package task19;

public abstract class Dish {
    private String material;
    private double cost;
    private boolean crashed = false;

    public Dish(String material, double cost) {
        this.material = material;
        this.cost = cost;
    }

    public abstract void sayHello();

    public void crush(){
        crashed = true;
    }

    public void fix(){
        crashed = false;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isCrashed() {
        return crashed;
    }

}
