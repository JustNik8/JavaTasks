package factory.task2.chairs;

public class MagicChair implements Chair{
    @Override
    public void sit() {
        System.out.println("You have just sit on Magic Chair");
    }

    public void doMagic(){
        System.out.println("Magic has been done!!!");
    }
}
