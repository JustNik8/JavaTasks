package factory.task2;

import factory.task2.chairs.Chair;
import factory.task2.chairs.FunctionalChair;
import factory.task2.chairs.MagicChair;
import factory.task2.chairs.VictorianChair;
import factory.task2.factories.AbstractChairFactory;
import factory.task2.factories.ChairFactory;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AbstractChairFactory factory = new ChairFactory();
        Chair chair;
        Client client = new Client();

        System.out.print("""
                Input which chair you want to create
                1 - Functional
                2 - Magic
                3 - Victorian
                """);




        int chairNum = sc.nextInt();
        if (chairNum == 1){
            chair = factory.createFunctionalChair();
        }
        else if (chairNum == 2){
            chair = factory.creteMagicChair();
        }
        else {
            chair = factory.createVictorianChair(10);
        }

        client.setChair(chair);
        client.sit();

        /*
        sit();

        if (chair instanceof FunctionalChair){
            System.out.print("Input 2 nums: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(((FunctionalChair) chair).sum(a, b));
        }
        else if (chair instanceof MagicChair){
            ((MagicChair) chair).doMagic();
        }
        else if (chair instanceof VictorianChair){
            System.out.println(((VictorianChair) chair).getAge());
        }
    }

    private static void sit(){
        chair.sit();
    }
        */
    }
}
