package lab12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab12Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Task 1
        System.out.println("----------Task1----------");
        String priceString = "3.0 RU, 57.0 USD 0.43 EU, 6.7 USD 9.0 ERR, 4.563 UKR, 0.004 EU, 5 RUB";
        Pattern floatingPricePattern = Pattern.compile("\\d+\\.\\d{0,2}\\s*(RU|EU|USD)");
        //Pattern floatingPricePattern = Pattern.compile("\\d+(?=.{0,1}\\d{0,2})\\s*(RU|EU|USD)");
        System.out.println(RegexUtils.getListByPattern(priceString, floatingPricePattern));

        //Task2
        System.out.println("----------Task2----------");
        //Declare expressions
        String expression1 = "(1 + 8) – 9 / 4";
        String expression2 = "6 / 5 – 2 * 9";
        String expression3 = "1 - 34 * 2 / 2-3-3";
        String expression4 = "1 - 34 * 2 / 2+3-3";

        //Pattern for expressions
        Pattern expressionPattern = Pattern.compile("(\\d+)(\\s*)(\\+)");

        //Printing expressions
        System.out.print(expression1 + " - ");
        System.out.println(RegexUtils.checkConditionByPattern(expression1, expressionPattern));
        System.out.print(expression2 + " - ");
        System.out.println(RegexUtils.checkConditionByPattern(expression2, expressionPattern));
        System.out.print(expression3 + " - ");
        System.out.println(RegexUtils.checkConditionByPattern(expression3, expressionPattern));
        System.out.print(expression4 + " - ");
        System.out.println(RegexUtils.checkConditionByPattern(expression4, expressionPattern));

        //Task3
        System.out.println("----------Task3----------");
        //Declare source string
        String dateString = "29/02/2000, 30/04/2003, 01/01/2003, 29/02/2001, 30-04-2003, 1/1/1899";

        //Declare pattern
        Pattern datePattern = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d");
        System.out.println(RegexUtils.getListByPattern(dateString, datePattern));

        //Task4
        System.out.println("----------Task4----------");
        //Declare source string
        String emailString = "user@example.com, root@localhost " +
                "myhost@@@com.ru, @my.ru, Julia String, mvolkov_test@mail.yandex.ru";

        //Declare pattern
        Pattern emailPattern = Pattern.compile("(\\w+)(@)[(\\w+)([.]?)]+(\\w+)");

        System.out.println(RegexUtils.getListByPattern(emailString, emailPattern));

        //Task5
        System.out.println("----------Task5----------");
        //Declare source string
        List<String> passwords = new ArrayList<>();
        passwords.add("F032_Password");
        passwords.add("TrySpy1");
        passwords.add("smart_pass");
        passwords.add("A007");

        for (String pass : passwords){
            System.out.print(pass + " ");
            if (RegexUtils.isPasswordSave(pass)){
                System.out.println("is safe");
            }
            else {
                System.out.println("is not safe");
            }
        }

    }
}
