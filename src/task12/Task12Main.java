package task12;

import java.util.*;

public class Task12Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Task1
        System.out.println("----------Task1---------");
        Person p1 = new Person(null, "Ivanov", null);
        Person p2 = new Person("Stepan", "Kiselev", null);
        Person p3 = new Person("Vasya", "Koshkin", "Alekseev");
        System.out.println(p1.getFCS());
        System.out.println(p2.getFCS());
        System.out.println(p3.getFCS());

        //Task2
        System.out.println("----------Task2---------");

        Address address1 = Address.parse("Russia, TyumenOblast, Tyumen, Permyakova, 15, 1, 54");
        Address address2 = Address.parse("Russia, Moscow, Moscow, Tverskaya, 25, 0, 23");
        Address address3 = Address.parse("Russia, KrasnodarKray, Krasnodar, Moscovskaya, 108, 5, 12");
        Address address4 = Address.parse("Russia, KrasnodarKray, Sochi, Kurortnaya, 5, 1, 16");

        System.out.println(address1);
        System.out.println(address2);
        System.out.println(address3);
        System.out.println(address4);

        //Task3
        System.out.println("----------Task3----------");
        String[] shirts = new String[11];
        shirts[0] = "S001,Black Polo Shirt,Black,XL";
        shirts[1] = "S002,Black Polo Shirt,Black,L";
        shirts[2] = "S003,Blue Polo Shirt,Blue,XL";
        shirts[3] = "S004,Blue Polo Shirt,Blue,M";
        shirts[4] = "S005,Tan Polo Shirt,Tan,XL";
        shirts[5] = "S006,Black T-Shirt,Black,XL";
        shirts[6] = "S007,White T-Shirt,White,XL";
        shirts[7] = "S008,White T-Shirt,White,L";
        shirts[8] = "S009,Green T-Shirt,Green,S";
        shirts[9] = "S010,Orange T-Shirt,Orange,S";
        shirts[10] = "S011,Maroon Polo Shirt,Maroon,S";

        System.out.println("--------------------------------");
        printArray(shirts);
        System.out.println("--------------------------------\n");

        Shirt[] shirts2 = new Shirt[11];

        for (int i = 0; i < shirts.length; i++){
            StringTokenizer st = new StringTokenizer(shirts[i], ",");

            String id = st.nextToken();
            String name = st.nextToken();
            String color = st.nextToken();
            String size = st.nextToken();

            Shirt shirt = new Shirt(id, name, color, size);
            shirts2[i] = shirt;
        }

        System.out.println("--------------------------------");
        printArray(shirts2);
        System.out.println("--------------------------------\n");

        //Task4
        System.out.println("----------Task4----------");
        String number1 = "89175655655";
        String number2 = "+79175655655";
        String number3 = "+104289652211";

        System.out.println(Phone.getFormattedNumber(number1));
        System.out.println(Phone.getFormattedNumber(number2));
        System.out.println(Phone.getFormattedNumber(number3));

        //Task5
        System.out.println("----------Task5----------");

        System.out.print("Input string: ");
        String testString1 = "Киев Нью-Йорк Амстердам Вена Мельбурн";

        StringBuilder builder = getLine(testString1.split(" "));
        System.out.println(builder);

    }

    private static <T> void printArray(T[] arr){
        for (T t : arr){
            System.out.println(t);
        }
    }

    private static StringBuilder getLine(String[] words){
        StringBuilder res = new StringBuilder();

        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        Collections.sort(wordList);

        res.append(wordList.get(0));
        wordList.remove(0);
        int max = wordList.size();
        int count = 0;

        while (true){

            for (int i = 0 ; i < wordList.size(); i++){
                //if (wordList)
            }

            count++;
            if (wordList.size() == 0 || count == max) break;
        }



        return res;

    }


}
