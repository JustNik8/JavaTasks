package task16.menuitems;

public final class Dish extends MenuItem{
    public Dish(int cost, String name, String description) {
        super(cost, name, description);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "cost=" + cost +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
