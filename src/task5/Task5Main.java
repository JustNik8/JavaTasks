package task5;

import java.util.Scanner;

public class Task5Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число: ");
        try {
            int number = sc.nextInt();
            Recursion.printSpeltNumber(number);
        }
        catch (Exception e){
            System.out.println("Вы ввели не число!!!");
        }

    }
}
