package lab9;

import java.util.Scanner;

public class ThrowsDemo {
    public void getKey(){
        Scanner sc = new Scanner( System.in );
        System.out.print("Enter Key: ");
        String key = sc.nextLine();
        boolean keyWasEntered = false;


        while (!keyWasEntered) {
            try {
                printDetails(key);
                keyWasEntered = true;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                System.out.print("Enter a new key: ");
                key = sc.nextLine();
            }
        }
    }
    private void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println( message );
    }

    private String getDetails(String key) throws Exception {
        if(key.equals("")) {
            throw new Exception( "Key set to empty string" );
        }
        return "data for " + key;
    }
}

