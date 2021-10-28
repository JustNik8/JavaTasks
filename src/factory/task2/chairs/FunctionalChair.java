package factory.task2.chairs;

public class FunctionalChair implements Chair{
    @Override
    public void sit() {
        System.out.println("You have just sit on Functional Chair");
    }

    public int sum (int a, int b){
        return a + b;
    }
}
