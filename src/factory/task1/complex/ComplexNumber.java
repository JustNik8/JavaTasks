package factory.task1.complex;

public class ComplexNumber {
    private int real;
    private int image;

    public ComplexNumber() {
        this.real = 0;
        this.image = 0;
    }

    public ComplexNumber(int real, int image) {
        this.real = real;
        this.image = image;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ComplexNumber{" +
                "real=" + real +
                ", image=" + image +
                '}';
    }
}
