package lab10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Array<E> {
    private Object[] data;
    private int capacity;

    public Array(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public void set(int index, E element){
        checkIndex(index);
        data[index] = element;
    }

    public E get(int index){
        checkIndex(index);
        return (E) data[index];
    }

    private void checkIndex(int index){
        if (index < 0 || index >= capacity){
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public void fillRandoms(int bound){
        Random random = new Random();
        for (int i = 0; i < capacity; i++){
            data[i] = random.nextInt(bound);
        }
    }

    public List<E> getFirst5ElementAsList(){
        List<E> res = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            res.add((E) data[i]);
        }

        return res;
    }
}
