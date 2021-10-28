package factory.task1.factories;

import factory.task1.complex.ComplexNumber;

public class ConcreteFactory implements ComplexFactory{
    @Override
    public ComplexNumber createComplex() {
        return new ComplexNumber();
    }

    @Override
    public ComplexNumber createComplex(int real, int image) {
        return new ComplexNumber(real, image);
    }
}
