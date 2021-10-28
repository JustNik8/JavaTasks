package task8;


import task8.waitlist.BoundedWaitList;
import task8.waitlist.IWaitList;
import task8.waitlist.UnfairWaitList;
import task8.waitlist.WaitList;

public class Task8Main {
    public static void main(String[] args) {

        WaitList<Integer> waitList = new WaitList<>();
        fillWaitListWithNumbers(waitList, 10);
        System.out.println("-----------------WaitList-----------------");
        System.out.println(waitList);
        waitList.add(123);
        waitList.contains(4);
        System.out.println(waitList.remove());
        System.out.println(waitList);

        System.out.println("-----------------BoundedWaitList(5)-----------------");
        BoundedWaitList<Integer> boundedList = new BoundedWaitList<>(5);
        fillWaitListWithNumbers(boundedList, boundedList.getCapacity());
        System.out.println(boundedList);
        System.out.println(boundedList.remove());
        System.out.println(boundedList);

        System.out.println("-----------------UnfairWaitList-----------------");
        UnfairWaitList<Integer> unfairList = new UnfairWaitList<>();
        fillWaitListWithNumbers(unfairList, 10);
        System.out.println(unfairList);
        unfairList.remove(0);
        System.out.println(unfairList);
        unfairList.remove(6);
        System.out.println(unfairList);

    }

    private static void fillWaitListWithNumbers(IWaitList<Integer> waitList, int size){
        for (int i = 0; i < size; i++){
            waitList.add(i);
        }
    }
}
