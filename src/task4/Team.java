package task4;

import java.awt.*;

public class Team {
    private String name;
    private Image icon;
    private int score = 0;

    public Team(String name, Image icon) {
        this.name = name;
        this.icon = icon;
    }

    public void addScore(){
        this.score++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
