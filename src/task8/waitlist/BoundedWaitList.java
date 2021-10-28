package task8.waitlist;

public class BoundedWaitList<E> extends WaitList<E> {
    private final int capacity;

    public BoundedWaitList(int capacity) {
        this.capacity = capacity;
    }

    public void add(E element){
        if (content.size() < capacity){
            content.add(element);
        }
    }

    public int getCapacity() {
        return capacity;
    }
}
