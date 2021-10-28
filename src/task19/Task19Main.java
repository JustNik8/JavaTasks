package task19;

public class Task19Main {
    public static void main(String[] args) {

        Plate plate = new Plate("porcelain", 1000, 36);
        Pan pan = new Pan("iron", 2500, 23);
        Fork fork = new Fork("silver", 400, 4);

        System.out.println("PLATE");
        System.out.println(plate.isCrashed());
        plate.crush();
        System.out.println(plate.isCrashed());
        plate.sayHello();

        System.out.println("\nPAN");
        System.out.println(pan.getCost());
        pan.setCost(4000);
        System.out.println(pan.getCost());
        pan.sayHello();

        System.out.println("\nFORK");
        System.out.println(fork.getTeethCount());
        fork.setTeethCount(3);
        System.out.println(fork.getTeethCount());
        fork.sayHello();
    }
}
