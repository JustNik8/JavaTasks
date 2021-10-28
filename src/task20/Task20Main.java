package task20;

public class Task20Main {
    public static void main(String[] args) {
        Car car = new Car(20);

        System.out.println(car.getPrice());
        car.setPrice(34567);
        System.out.println(car.getPrice());
    }
}
