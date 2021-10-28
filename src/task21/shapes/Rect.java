package task21.shapes;

import java.awt.*;

public class Rect extends Shape {

    private static final int type = Shape.RECT;

    public Rect(Color color, int x, int y, int height, int width) {
        super(color, x, y, height, width);
    }

    public Rect(int x, int y, int height, int width) {
        super(x, y, height, width);
    }

    @Override
    public int getType() {
        return type;
    }
}
