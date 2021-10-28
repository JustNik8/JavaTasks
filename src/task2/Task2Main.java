package task2;

public class Task2Main {
    public static void main(String[] args) {
        System.out.println("--------Second task----------");

        Ball ball = new Ball(4 ,6);

        System.out.println(ball);
        ball.move(3, 7);
        System.out.println(ball);
    }
}
