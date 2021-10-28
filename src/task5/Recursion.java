package task5;

public class Recursion {
    public static void printSpeltNumber(int number){
        if (number > 0){
            int remainder = number % 10;
            number /= 10;
            Recursion.printSpeltNumber(number);
            System.out.print(remainder + " ");
        }
    }
}
