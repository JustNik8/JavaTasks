package task16.ordersmanagers.internetordersmanager;

import task16.orders.Order;

import java.util.Objects;

class QueueNode {
    private QueueNode next;
    private QueueNode prev;
    private Order value;

    public QueueNode(Order value) {
        this.value = value;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

    public QueueNode getPrev() {
        return prev;
    }

    public void setPrev(QueueNode prev) {
        this.prev = prev;
    }

    public Order getValue() {
        return value;
    }

    public void setValue(Order value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueNode queueNode = (QueueNode) o;
        return Objects.equals(next, queueNode.next) && Objects.equals(prev, queueNode.prev) && Objects.equals(value, queueNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, prev, value);
    }

    @Override
    public String toString() {
        return "QueueNode{" +
                "next=" + next +
                ", prev=" + prev +
                ", value=" + value +
                '}';
    }
}
