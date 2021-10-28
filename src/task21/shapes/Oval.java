package task21.shapes;

import java.awt.*;

public class Oval extends Shape{

    private static final int type = Shape.OVAL;

    public Oval(Color color, int x, int y, int height, int width) {
        super(color, x, y, height, width);
    }

    public Oval(int x, int y, int height, int width) {
        super(x, y, height, width);
    }

    @Override
    public int getType() {
        return type;
    }
}
