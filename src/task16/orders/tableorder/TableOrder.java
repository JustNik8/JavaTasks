package task16.orders.tableorder;

import task16.customer.Customer;
import task16.menuitems.MenuItem;
import task16.orders.Order;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class TableOrder implements Order {
    private int size;
    private MenuItem[] items;
    private Customer customer;

    public TableOrder(int capacity, Customer customer) {
        this.size = capacity;
        items = new MenuItem[capacity];
        this.customer = customer;
    }

    public TableOrder(Customer customer) {
        this.size = 0;
        items = new MenuItem[10];
        this.customer = customer;
    }

    @Override
    public boolean add(MenuItem item) {
        if (size >= items.length){
            resizeArray();
        }
        items[size] = item;
        size++;
        return true;
    }

    @Override
    public String[] itemsNames() {
        String[] names = new String[size];
        for (int i = 0; i < size; i++){
            names[i] = items[i].getName();
        }
        return names;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemQuantity(String itemName) {
        int count = 0;
        for (MenuItem item : items){
            if (item.getName().equals(itemName)){
                count++;
            }
        }

        return count;
    }

    @Override
    public int itemQuantity(MenuItem item) {
        int count = 0;
        for (MenuItem currentItem : items){
            if (currentItem.equals(item)){
                count++;
            }
        }
        return count;
    }

    @Override
    public MenuItem[] getItems() {
        return items;
    }

    @Override
    public boolean remove(String itemName) {
        int index = -1;
        for (int i = 0; i < size; i++){
            if (items[i].getName().equals(itemName)){
                index = i;
                break;
            }
        }

        if (index == -1){
            return false;
        }

        for (int i = index; i < size-1; i++){
            items[i] = items[i+1];
        }
        size--;
        items[size] = null;
        return true;

    }

    @Override
    public boolean remove(MenuItem item) {
        int index = -1;
        for (int i = 0; i < size; i++){
            if (items[i].equals(item)){
                index = i;
                break;
            }
        }
        if (index == -1){
            return false;
        }

        for (int i = index; i < size-1; i++){
            items[i] = items[i+1];
        }
        size--;
        items[size] = null;
        return true;
    }

    @Override
    public int removeAll(String itemName) {
        int deletedCount = 0;

        for (int i = 0; i < size; i++){
            if (items[i].getName().equals(itemName)){
                continue;
            }
            else{
                items[deletedCount] = items[i];
                deletedCount++;
            }
        }

        size -= deletedCount;
        for (int i = size; i < size + deletedCount; i++){
            items[i] = null;
        }
        return deletedCount;
    }

    @Override
    public int removeAll(MenuItem item) {
        int deletedCount = 0;
        for (int i = 0; i < size; i++){
            if (items[i].equals(item)){
                continue;
            }
            else{
                items[deletedCount] = items[i];
                deletedCount++;
            }
        }

        size -= deletedCount;
        for (int i = size; i < size + deletedCount; i++){
            items[i] = null;
        }

        return deletedCount;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        Comparator<MenuItem> menuItemComparator = (o1, o2) -> o2.getCost() - o1.getCost();

        MenuItem[] sortedItems = Arrays.copyOf(items, size);
        Arrays.sort(sortedItems, menuItemComparator);
        return sortedItems;
    }

    @Override
    public int costTotal() {
        int totalCost = 0;
        for (MenuItem item : items){
            totalCost += item.getCost();
        }
        return totalCost;
    }

    @Override
    public Customer getCustomer() {
        return this.customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private void resizeArray(){
        items = Arrays.copyOf(items, items.length*2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableOrder that = (TableOrder) o;
        return size == that.size && Arrays.equals(items, that.items) && Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, customer);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    @Override
    public String toString() {
        return "TableOrder{" +
                "size=" + size +
                ", items=" + Arrays.toString(items) +
                ", customer=" + customer +
                '}';
    }
}
