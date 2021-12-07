package task16.menuitems;

import java.util.Objects;

public class MenuItem {
    int cost;
    String name;
    String description;

    public MenuItem(int cost, String name, String description) {
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    public MenuItem() {
        this.cost = 0;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem item = (MenuItem) o;
        return cost == item.cost && Objects.equals(name, item.name) && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, name, description);
    }


}
