package task21.shapes;

import java.awt.*;

public class Circle extends Shape{
    private static final int type = Shape.CIRCLE;

    public Circle(Color color, int x, int y, int size) {
        super(color, x, y, size, size);
    }

    public Circle(int x, int y, int size) {
        super(x, y, size, size);
    }

    @Override
    public int getType() {
        return type;
    }
}
