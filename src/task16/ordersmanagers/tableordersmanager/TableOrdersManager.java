package task16.ordersmanagers.tableordersmanager;

import task16.menuitems.MenuItem;
import task16.orders.Order;
import task16.ordersmanagers.OrdersManager;
import task16.ordersmanagers.IllegalTableNumber;

public class TableOrdersManager implements OrdersManager {
    private final Order[] orders;
    private final int capacity;
    private int size = 0;

    public TableOrdersManager(int capacity) {
        this.capacity = capacity;
        orders = new Order[capacity];
    }

    public TableOrdersManager() {
        //Default value
        capacity = 40;
        orders = new Order[capacity];
    }

    public void add(Order order, int tableNumber){
        if (tableNumber > capacity){
            throw new IllegalTableNumber("tableNumber(" + tableNumber + ") > capacity(" + capacity + ")");
        }

        orders[tableNumber-1] = order;
        size++;
    }

    public void addItem(MenuItem item, int tableNumber){
        if (tableNumber > capacity){
            throw new IllegalTableNumber("tableNumber(" + tableNumber + ") > capacity(" + capacity + ")");
        }

        orders[tableNumber-1].add(item);
    }

    int freeTableNumber(){
        for (int i = 0; i < capacity; i++){
            if (orders[i] == null){
                return i+1;
            }
        }

        return -1;
    }
    int[] freeTableNumbers(){
        int freeTablesCount = 0;
        for (int i = 0; i  <capacity; i++){
            if (orders[i] == null){
                freeTablesCount++;
            }
        }
        int[] freeTables = new int[freeTablesCount];
        for (int i = 0, freeNum = 0; i  <capacity; i++){
            if (orders[i] == null){
                freeTables[freeNum] = freeNum + 1;
                freeNum++;
            }
        }
        return freeTables;
    }

    Order getOrder(int tableNumber){
        return orders[tableNumber-1];
    }

    public void remove(int tableNumber){
        orders[tableNumber-1] = null;
        size--;
    }

    public int remove(Order order){

        for (int i = 0; i < capacity; i++){
            if (orders[i].equals(order)){
                orders[i] = null;
                size--;
                return i+1;
            }
        }

        return -1;
    }

    public int removeAll(Order order){
        int removedOrdersCount = 0;

        for (int i = 0; i < capacity; i++){
            if (orders[i].equals(order)){
                orders[i] = null;
                removedOrdersCount++;
            }
        }

        size -= removedOrdersCount;
        return removedOrdersCount;
    }

    @Override
    public int itemsQuantity() {
        int quantity = 0;
        for (int i = 0; i < capacity; i++){
            if (orders[i] != null){
                quantity += orders[i].itemsQuantity();
            }
        }
        return quantity;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int quantity = 0;
        for (int i = 0; i < capacity; i++){
            if (orders[i] != null){
                quantity += orders[i].itemQuantity(itemName);
            }
        }
        return quantity;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int quantity = 0;
        for (int i = 0; i < capacity; i++){
            if (orders[i] != null){
                quantity += orders[i].itemQuantity(item);
            }
        }
        return quantity;
    }

    @Override
    public Order[] getOrders() {
        if (size <= 0){
            return null;
        }
        Order[] tempOrders = new Order[size];
        int orderIndex = 0;
        for (Order order: orders){
            if (order != null){
                tempOrders[orderIndex] = order;
                orderIndex++;
            }
        }

        return tempOrders;
    }

    @Override
    public int ordersCostSummary() {
        int costSummary = 0;
        for (Order order : orders){
            if (order != null){
                costSummary += order.costTotal();
            }
        }

        return costSummary;
    }

    @Override
    public int ordersQuantity() {
        return size;
    }

}
