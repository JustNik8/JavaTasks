package task23;

import java.util.*;

//This is the coolest ArrayList you have ever seen!
public class CoolArrayList<T> implements List<T> {

    private static final int INITIAL_CAPACITY = 10;
    private Object[] data;
    private int capacity;
    private int size;

    public CoolArrayList(int initialCapacity){
        this.data = new Object[initialCapacity];
        this.capacity = initialCapacity;
        this.size = 0;
    }

    public CoolArrayList() {
        this(INITIAL_CAPACITY);
    }

    @Override
    public int size() {
        return this.size;
    }

    public int capacity(){return this.capacity;}

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public boolean contains(Object o) {

        for (int i = 0; i < size; i++){
            if (data[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && data[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) data[currentIndex++];
            }
        };

        return iterator;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++){
            array[i] = data[i];
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (size >= capacity) {
            resize(this.size * 2);
        }
        data[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {

        int indexToDelete = -1;

        for (int i = 0; i < size; i++){
            if (data[i].equals(o)){
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete == -1){
            return false;
        }

        remove(indexToDelete);
        return true;

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        addAll(size, c);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        for (T elem : c){
            add(index++, elem);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;

        for (int i = 0; i < size(); i++){
            Object obj = get(i);
            if (c.contains(obj)){
                remove(i);
                i--;
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> otherList) {
        boolean modified = false;

        for (int i = 0; i < size(); i++){
            Object obj = get(i);
            if (!otherList.contains(obj)){
                remove(i);
                i--;
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public void clear() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
        capacity = INITIAL_CAPACITY;
    }

    @Override
    public T get(int index) {
        return (T) data[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        T previousElement = (T) data[index];
        data[index] = element;

        return previousElement;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("index = " + index + " but size = " + size);
        }
        if (size >= capacity){
            resize(this.size*2);
        }
        for (int i = size; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        for (int i = index; i < size-1; i++){
            data[i] =data[i+1];
        }
        T element = (T) data[size];
        size--;
        data[size] = null;
        return element;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++){
            if (data[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size-1; i >=0; i--){
            if (data[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    /**
     *@deprecated Never use this method, because i haven't implemented this!
     * Always returns null!
     */
    @Deprecated
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    /**
       *@deprecated Never use this method, because i haven't implemented this!
     * Always returns null!
     */
    @Deprecated
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex > toIndex){
            throw new IllegalArgumentException("fromIndex > toIndex");
        }
        if (fromIndex < 0 || fromIndex > size){
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        }
        if (toIndex < 0 || toIndex > size){
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        }

        CoolArrayList<T> coolArrayList = new CoolArrayList<>(toIndex - fromIndex);
        for (int i = fromIndex; i < toIndex; i++){
            coolArrayList.add((T) data[i]);
        }
        return coolArrayList;
    }

    private void resize(int newSize){
        Object[] newArray = new Object[newSize];
        System.arraycopy(data, 0, newArray, 0, this.size);
        data = newArray;
        capacity = newSize;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder string = new StringBuilder();
        string.append("[");
        for (int i = 0; i < size-1; i++){
            string.append(data[i]).append(", ");
        }
        string.append(data[size-1]).append("]");

        return string.toString();
    }
}
