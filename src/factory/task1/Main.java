package factory.task1;

import factory.task1.complex.ComplexNumber;
import factory.task1.factories.ComplexFactory;
import factory.task1.factories.ConcreteFactory;

public class Main {
    public static void main(String[] args) {
        ComplexFactory complexFactory = new ConcreteFactory();

        ComplexNumber complex1 = complexFactory.createComplex();
        System.out.println(complex1);

        ComplexNumber complex2 = complexFactory.createComplex(5, 3);
        System.out.println(complex2);
    }
}
