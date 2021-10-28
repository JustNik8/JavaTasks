package task16.menuitems;

import java.util.Objects;

public final class Drink extends MenuItem implements Alcoholable{
    private final double alcoholVol;
    private final DrinkTypeEnum type;

    public Drink(int cost, String name, String description, double alcoholVol, DrinkTypeEnum type) {
        super(cost, name, description);
        this.alcoholVol = alcoholVol;
        this.type = type;
    }

    @Override
    public boolean isAlcoholicDrink() {
        return alcoholVol >= 0.3;
    }

    @Override
    public double getAlcoholVol() {
        return alcoholVol;
    }

    public DrinkTypeEnum getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "alcoholVol=" + alcoholVol +
                ", type=" + type +
                ", cost=" + cost +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
