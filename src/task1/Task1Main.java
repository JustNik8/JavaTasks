package task1;

public class Task1Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Sanya", 5);

        System.out.println(dog.getName());
        System.out.println(dog.getAge());

        System.out.println(dog);
        System.out.println(dog.intoHumanAge());
    }
}
