package task23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Task23Main {

    private static final Random random = new Random();

    public static void main(String[] args) {


        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            arrayList.add(random.nextInt(10));
        }
        //System.out.println(arrayList);

        List<Integer> linkedList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            linkedList.add(random.nextInt(10));
        }
        //System.out.println(linkedList);

        //arrayList.contains(3);


        CoolArrayList<Integer> coolArrayList = new CoolArrayList<>(2);

        coolArrayList.add(0);
        coolArrayList.add(1);
        coolArrayList.add(2);
        coolArrayList.add(3);
        coolArrayList.add(4);
        coolArrayList.add(5);
        coolArrayList.add(15);
        coolArrayList.add(10);
        coolArrayList.add(11);
        coolArrayList.add(15);
        coolArrayList.add(10);

        System.out.println("coolArrayList: " + coolArrayList);
        System.out.println("size: " + coolArrayList.size());
        System.out.println("capacity: " + coolArrayList.capacity());
        System.out.println("isEmpty: " + coolArrayList.isEmpty());
        System.out.println("contains 1: " + coolArrayList.contains(1));
        System.out.println("contains 100: " + coolArrayList.contains(100));

        Object[] array = coolArrayList.toArray();
        System.out.println("convert to array: " + Arrays.toString(array));

        coolArrayList.remove(3);
        System.out.println("element at index 3 was deleted: " + coolArrayList);

        Integer num = 15;
        coolArrayList.remove(num);
        System.out.println("15 was deleted: " + coolArrayList);

        System.out.println("index of 10: " + coolArrayList.indexOf(10));
        System.out.println("last index of 15: " + coolArrayList.lastIndexOf(10));
        System.out.println("index of 124: " + coolArrayList.indexOf(124));

        System.out.println("sublist: " + coolArrayList.subList(0, 5));

        System.out.println(coolArrayList);
        coolArrayList.add(1, 17);
        System.out.println("Add to 17 to 1 index: " + coolArrayList);
        coolArrayList.set(4, 20);
        System.out.println("set 20 to index 4: " + coolArrayList);

        List<Integer> someNums = new ArrayList<>();
        someNums.add(4);
        someNums.add(7);
        coolArrayList.addAll(someNums);
        coolArrayList.add(7);
        System.out.println("add 4 7 7: " + coolArrayList);

        someNums.add(1);
        coolArrayList.removeAll(someNums);
        System.out.println("remove 4 7: " + coolArrayList);

        someNums.add(5);
        someNums.add(10);
        coolArrayList.retainAll(someNums);
        System.out.println("retain 4 7 1 5 10: " + coolArrayList);

        System.out.print("print with foreach: ");
        for (Integer number : coolArrayList){
            System.out.print(number + " ");
        }
        System.out.println();

        coolArrayList.clear();
        System.out.println("Clear list: " + coolArrayList);
    }
}
