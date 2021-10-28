package factory.task2.factories;

import factory.task2.chairs.FunctionalChair;
import factory.task2.chairs.MagicChair;
import factory.task2.chairs.VictorianChair;

public class ChairFactory implements AbstractChairFactory {

    public VictorianChair createVictorianChair(int age){
        return new VictorianChair(age);
    }

    @Override
    public MagicChair creteMagicChair() {
        return new MagicChair();
    }

    @Override
    public FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }
}
