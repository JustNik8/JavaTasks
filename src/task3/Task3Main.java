package task3;

import task3.shapes.dynamic.Movable;
import task3.shapes.dynamic.MovableCircle;
import task3.shapes.dynamic.MovablePoint;
import task3.shapes.stationary.*;

public class Task3Main {
    public static void main(String[] args) {

        Circle circle = new Circle(5.5, "RED", false);
        System.out.println(circle); // which version?
        System.out.println(circle.getArea()); // which version?
        System.out.println(circle.getPerimeter()); // which version?
        System.out.println(circle.getColor());
        System.out.println(circle.isFilled());
        System.out.println(circle.getRadius());

        Rectangle rect = new Rectangle(5, 5, "RED", true);
        System.out.println(rect);

        Square square = new Square(5, "Blue", false);
        System.out.println(square);
        square.setLength(7);
        System.out.println(square);


        MovablePoint movablePoint = new MovablePoint(1,2,3,4);
        System.out.println(movablePoint);
        movablePoint.moveRight();
        movablePoint.moveDown();
        System.out.println(movablePoint);

        MovableCircle movableCircle = new MovableCircle(movablePoint, 15);
        System.out.println(movableCircle);
        movableCircle.moveDown();
        movableCircle.moveLeft();
        System.out.println(movableCircle);


        /*
        Shape s1 = new Circle(5.5, "RED", false); // Upcast Circle to Shape
        System.out.println(s1); // which version?
        System.out.println(s1.getArea()); // which version?
        System.out.println(s1.getPerimeter()); // which version?
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        System.out.println(s1.getRadius());

        Circle c1 = (Circle)s1; // Downcast back to Circle
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());

        Shape s2 = new Shape();

        Shape s3 = new Rectangle(1.0, 2.0, "RED", false); // Upcast
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
        System.out.println(s3.getLength());

        Rectangle r1 = (Rectangle)s3; // downcast
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());

        Shape s4 = new Square(6.6); // Upcast
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        System.out.println(s4.getSide());

// Take note that we downcast Shape s4 to Rectangle,
// which is a superclass of Square, instead of Square
        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        System.out.println(r2.getSide());
        System.out.println(r2.getLength());

// Downcast Rectangle r2 to Square
        Square sq1 = (Square)r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());
        */

    }
}
