package task9.task1;

import java.util.Scanner;

public class Task9Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Task1
        System.out.println("---------Task1---------");
        System.out.print("Input TIN: ");
        String tin = sc.next();

        if (tin.length() != 10){
            throw new TINRuntimeException("Invalid TIN");
        }
        else{
            System.out.println("TIN is valid");
        }


    }
}
