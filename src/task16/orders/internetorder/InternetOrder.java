package task16.orders.internetorder;

import task16.customer.Customer;
import task16.menuitems.MenuItem;
import task16.orders.Order;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class InternetOrder implements Order {
    private int size = 0;
    private ListNode head;
    private ListNode tail;
    private Customer customer;

    public InternetOrder(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean add(MenuItem item) {
       if (head == null){
           head = new ListNode(item);
           size++;
           return true;
       }

       ListNode current = head;
       while (current.getNext() != null){
           current = current.getNext();
       }

       current.setNext(new ListNode(item));
       this.tail = current.getNext();
       size++;
       return true;

    }

    @Override
    public String[] itemsNames() {
        String[] names = new String[size];

        ListNode current = this.head;

        for (int i = 0; i < size; i++){
            names[i] = current.getValue().getName();
            current = current.getNext();
        }

        return names;

    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemQuantity(String itemName) {
        int quantity = 0;
        ListNode current = head;
        while (current != null){
            if (current.getValue().getName().equals(itemName)){
                quantity++;
            }
            current = current.getNext();
        }

        return quantity;

    }

    @Override
    public int itemQuantity(MenuItem item) {
        int quantity = 0;
        ListNode current = head;
        while (current != null){
            if (current.getValue().equals(item)){
                quantity++;
            }
            current = current.getNext();
        }

        return quantity;
    }

    @Override
    public MenuItem[] getItems() {
        MenuItem[] items = new MenuItem[size];
        ListNode current = head;

        for (int i = 0; i < size; i++){
            items[i] = current.getValue();
            current = current.getNext();
        }

        return items;
    }

    @Override
    public boolean remove(String itemName) {
        if (head.getValue().getName().equals(itemName)){
            deleteHead();
            return true;
        }

        ListNode prev = head;
        boolean foundNodeToDelete = false;
        while (prev.getNext() != null){
            if (prev.getNext().getValue().getName().equals(itemName)){
                foundNodeToDelete = true;
                break;
            }
            prev = prev.getNext();
        }

        if (foundNodeToDelete){
            ListNode nodeToDelete = prev.getNext();
            prev.setNext(nodeToDelete.getNext());
            nodeToDelete.setNext(null);
            size--;
        }

        return foundNodeToDelete;

    }

    @Override
    public boolean remove(MenuItem item) {
        if (head.getValue().equals(item)){
            deleteHead();
            return true;
        }

        ListNode prev = head;
        boolean foundNodeToDelete = false;
        while (prev.getNext() != null){
            if (prev.getNext().getValue().equals(item)){
                foundNodeToDelete = true;
                break;
            }
            prev = prev.getNext();
        }

        if (foundNodeToDelete){
            ListNode nodeToDelete = prev.getNext();
            prev.setNext(nodeToDelete.getNext());
            nodeToDelete.setNext(null);
            size--;
        }

        return foundNodeToDelete;
    }

    @Override
    public int removeAll(String itemName) {
        int deletedItemsCount = 0;
        if (head.getValue().getName().equals(itemName)){
            deleteHead();
            deletedItemsCount++;
        }

        ListNode prev = head;
        ListNode current = head.getNext();

        while (current != null){
            if (current.getValue().getName().equals(itemName)){
                prev.setNext(current.getNext());
                current.setNext(null);
                current = prev.getNext();
                deletedItemsCount++;
            }
            else {
                prev = current;
                current = current.getNext();
            }
        }

        size -= deletedItemsCount;
        return deletedItemsCount;
    }

    @Override
    public int removeAll(MenuItem item) {
        int deletedItemsCount = 0;
        if (head.getValue().equals(item)){
            deleteHead();
            deletedItemsCount++;
        }

        ListNode prev = head;
        ListNode current = head.getNext();

        while (current != null){
            if (current.getValue().equals(item)){
                prev.setNext(current.getNext());
                current.setNext(null);
                current = prev.getNext();
                deletedItemsCount++;
            }
            else {
                prev = current;
                current = current.getNext();
            }
        }

        size -= deletedItemsCount;
        return deletedItemsCount;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        Comparator<MenuItem> itemComparator = new Comparator<MenuItem>() {
            @Override
            public int compare(MenuItem o1, MenuItem o2) {
                return o2.getCost() - o1.getCost();
            }
        };
        MenuItem[] items = getItems();
        Arrays.sort(items, itemComparator);

        return items;

    }

    @Override
    public int costTotal() {
        ListNode current = head;
        int totalCost = 0;
        while (current != null){
            totalCost += current.getValue().getCost();
            current = current.getNext();
        }
        return totalCost;
    }

    private void deleteHead(){
        ListNode next = head.getNext();
        head.setNext(next);
        head = next;
        size--;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternetOrder order = (InternetOrder) o;
        return size == order.size && Objects.equals(head, order.head) && Objects.equals(tail, order.tail) && Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, head, tail, customer);
    }

    @Override
    public String toString() {
        return "InternetOrder{" +
                "size=" + size +
                ", head=" + head +
                ", tail=" + tail +
                ", customer=" + customer +
                '}';
    }
}
