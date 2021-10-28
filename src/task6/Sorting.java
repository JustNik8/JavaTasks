package task6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static <T extends Comparable<? super T>> void insertionSort(List<T> list){
        for(int left = 0; left < list.size(); left++){
            T value = list.get(left);

            int i = left - 1;
            for (; i >= 0; i--){
                if (value.compareTo(list.get(i)) < 0){
                    list.set(i+1, list.get(i));
                }
                else break;
            }
            list.set(i+1, value);
        }
    }

    public static <T> void quickSort(List<T> list, int low, int high, Comparator<T> comparator){
        if (list.isEmpty()) return; //Finish sorting if list is empty
        if (low >= high) return;

        //Choosing a pivot
        int middle = low + (high - low) / 2;
        T  pivot = list.get(middle);

        //Dividing into sub-lists, that are larger and smaller than the pivot
        int i = low, j = high;
        while (i <= j){
            while (comparator.compare(list.get(i), pivot) < 0){
                i++;
            }
            while (comparator.compare(list.get(j), pivot) > 0){
                j--;
            }
            if (i <= j){
                Collections.swap(list, i ,j );
                i++;
                j--;
            }
        }

        //Calling of recursion for sorting left and right parts
        if (low < j){
            quickSort(list, low, j, comparator);
        }
        if (high > i){
            quickSort(list, i, high, comparator);
        }

    }

    public static <T extends Comparable<? super T>> List<T> mergeSort(List<T> src){

        if (src.size() <= 1){
            return src;
        }

        int midpoint = src.size() / 2;
        List<T> left = new ArrayList<>(midpoint);
        List<T> right;
        int rightCapacity;

        if (src.size() % 2 == 0) {
            rightCapacity = midpoint;
        }
        else {
            rightCapacity = midpoint+1;
        }
        right = new ArrayList<>(rightCapacity);

        for (int i = 0; i < midpoint; i++){
            left.add(src.get(i));
        }
        for (int j = 0; j < rightCapacity; j++){
            right.add(src.get(midpoint+j));
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static <T extends Comparable<? super T>> List<T> merge(List<T> left, List<T> right) {

        List<T> result = new ArrayList<>(left.size() + right.size());

        int leftPointer, rightPointer;
        leftPointer = rightPointer = 0;

        while (leftPointer < left.size() || rightPointer < right.size()){
              if (leftPointer < left.size() && rightPointer < right.size()) {
                  if (left.get(leftPointer).compareTo(right.get(rightPointer)) < 0){
                      result.add(left.get(leftPointer));
                      leftPointer++;
                  }
                  else {
                      result.add(right.get(rightPointer));
                      rightPointer++;
                  }
              }

              else if (leftPointer < left.size()){
                  result.add(left.get(leftPointer));
                  leftPointer++;
              }
              else if (rightPointer < right.size()){
                  result.add(right.get(rightPointer));
                  rightPointer++;
              }
        }

        return result;
    }
}
