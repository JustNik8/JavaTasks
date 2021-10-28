package factory.task2.factories;

import factory.task2.chairs.FunctionalChair;
import factory.task2.chairs.MagicChair;
import factory.task2.chairs.VictorianChair;

public interface AbstractChairFactory {
    VictorianChair createVictorianChair(int age);
    MagicChair creteMagicChair();
    FunctionalChair createFunctionalChair();
}
