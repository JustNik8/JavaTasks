package task21.shapes;

import task21.utils.ColorUtils;

import java.awt.*;

public abstract class Shape {
    private Color color;
    private int x;
    private int y;
    private int height;
    private int width;

    public static final int OVAL = 0;
    public static final int CIRCLE = 1;
    public static final int RECT = 2;

    public Shape(Color color, int x, int y, int height, int width) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public Shape(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = ColorUtils.getRandomColor();
    }

    public abstract int getType();

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
