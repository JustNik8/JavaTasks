package factory.task1.factories;
import factory.task1.complex.ComplexNumber;

public interface ComplexFactory {
    ComplexNumber createComplex();
    ComplexNumber createComplex(int real, int image);
}
