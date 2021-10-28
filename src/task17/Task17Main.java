package task17;

import java.util.*;

public class Task17Main {
    public static void main(String[] args) {
        Random random = new Random();

        int size = random.nextInt(15) + 5;
        List<Integer> listOfNums = new ArrayList<>(size);

        for (int i = 0; i < size-1; i++){
            listOfNums.add(random.nextInt(40));
            System.out.print(listOfNums.get(i) + " ");
        }
        System.out.println();

        Collections.sort(listOfNums);

        for (Integer listOfNum : listOfNums) {
            System.out.print(listOfNum + " ");
        }

    }

}
