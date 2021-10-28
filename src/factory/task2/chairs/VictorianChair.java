package factory.task2.chairs;

public class VictorianChair implements Chair{

    private int age;

    @Override
    public void sit() {
        System.out.println("You have just sit on Victorian Chair");
    }

    public VictorianChair(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
