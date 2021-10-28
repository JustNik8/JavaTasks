package task16.ordersmanagers.internetordersmanager;

import task16.menuitems.MenuItem;
import task16.orders.Order;
import task16.ordersmanagers.OrdersManager;

public class InternetOrdersManager implements OrdersManager {
    private QueueNode head;
    private QueueNode tail;
    private int size = 0;

    public boolean add(Order order){
        if (head == null){
            head = new QueueNode(order);
            size++;
            return true;
        }

        QueueNode current = head;
        while (current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(new QueueNode(order));
        size++;
        return true;

    }

    public Order remove(){
        Order orderToReturn = head.getValue();
        removeHead();
        return orderToReturn;
    }

    public Order order(){
        return head.getValue();
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int quantity = 0;
        QueueNode current = head;
        while (current != null){
            quantity += current.getValue().itemQuantity(itemName);
            current = current.getNext();
        }

        return quantity;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int quantity = 0;
        QueueNode current = head;
        while (current != null){
            quantity += current.getValue().itemQuantity(item);
            current = current.getNext();
        }

        return quantity;
    }

    @Override
    public Order[] getOrders() {
        Order[] orders = new Order[size];
        QueueNode current = head;
        for (int i = 0; i < size; i++){
            orders[i] = current.getValue();
            current = current.getNext();
        }

        return orders;
    }

    @Override
    public int ordersCostSummary() {
        int costSummary = 0;

        QueueNode current = head;
        while (current != null){
            costSummary += current.getValue().costTotal();
            current = current.getNext();
        }

        return costSummary;
    }

    @Override
    public int ordersQuantity() {
        return size;
    }

    private void removeHead(){
        QueueNode next = head.getNext();
        head.setNext(next);
        head = next;
        size--;
    }

}
