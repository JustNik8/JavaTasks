package lab10;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Lab10Main {

    private static final Random random = new Random();

    public static void main(String[] args) {
        int size = 10;

        Integer[] nums = new Integer[size];
        for (int i = 0; i < size; i++){
            nums[i] = i;
        }

        List<Integer> listNums = convertArrayToList(nums);
        System.out.println("----------Task1--------");
        System.out.println("----------Array and list of integers---------");
        System.out.println(Arrays.toString(nums) + " " + nums.getClass().getSimpleName());
        System.out.println(listNums + " " + listNums.getClass().getSimpleName());

        String[] stringArray = new String[size];
        for (int i = 0; i < size; i++){
            stringArray[i] = generateRandomString(7);
        }
        List<String> stringList = convertArrayToList(stringArray);

        System.out.println("----------Array and list of strings---------");
        System.out.println(Arrays.toString(stringArray) + " " + stringArray.getClass().getSimpleName());
        System.out.println(stringList + " " + stringList.getClass().getSimpleName());

        System.out.println("\n----------Task2----------");
        Array<Integer> arrayInt = new Array<>(10);
        arrayInt.fillRandoms(50);
        System.out.println(arrayInt);

        System.out.println("\n----------Task3----------");
        System.out.println(arrayInt.get(8));
        arrayInt.set(1, 1);
        System.out.println(arrayInt);

        System.out.println("\n----------Task4----------");
        System.out.println(arrayInt.getFirst5ElementAsList() + " " + arrayInt.getFirst5ElementAsList().getClass().getSimpleName());

        System.out.println("\n----------Task5----------");
        int arraySize = 10;
        Integer[] numsArray = new Integer[arraySize];
        String[] stringsArray = new String[arraySize];
        for (int i = 0; i < arraySize; i++){
            numsArray[i] = random.nextInt(10);
            stringsArray[i] = generateRandomString(5);
        }
        System.out.println(newArrayList(numsArray));
        System.out.println(newHashSet(numsArray));
        System.out.println(newHashMap(stringsArray, numsArray));

    }

    private static <E> List<E> convertArrayToList(E[] array){
        return Arrays.asList(array);
    }

    private static String generateRandomString(int size){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++){
            char ch = (char) (random.nextInt(25) + 97);
            result.append(ch);
        }

        return result.toString();
    }

    private static <T> ArrayList<T> newArrayList(T[] elems){
        return new ArrayList<>(Arrays.asList(elems));
    }

    private static <T> HashSet<T> newHashSet(T[] elems){
        return new HashSet<>(Arrays.asList(elems));
    }

    private static <K, V> HashMap<K, V> newHashMap(K[] keys, V[] values) {
        if (keys.length != values.length){
            throw new RuntimeException("keys.length(" + keys.length + ")" + " != values.length(" + values.length + ")");
        }

        HashMap<K, V> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
        }

        return map;
    }

}
