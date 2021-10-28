package task18;

import java.util.Arrays;

public class Human {
    Leg[] legs = new Leg[2];
    Arm[] arms = new Arm[2];
    Head head = new Head("Black");

    public Human() {

        for (int i = 0; i < 2; i++){
            legs[i] = new Leg();
            arms[i] = new Arm();
        }

        legs[0].setType("left");
        legs[1].setType("right");

        arms[0].setType("left");
        arms[1].setType("right");
    }

    public Leg[] getLegs() {
        return legs;
    }

    public void setLegs(Leg[] legs) {
        this.legs = legs;
    }

    public Arm[] getArms() {
        return arms;
    }

    public void setArms(Arm[] arms) {
        this.arms = arms;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "Human{" +
                "legs=" + Arrays.toString(legs) +
                ", arms=" + Arrays.toString(arms) +
                ", head=" + head +
                '}';
    }
}
