package task16.orders.internetorder;

import task16.menuitems.MenuItem;

import java.util.Objects;

class ListNode {
    private ListNode next;
    private MenuItem value;

    public ListNode(MenuItem value) {
        this.value = value;
    }

    public ListNode(ListNode next, MenuItem value) {
        this.next = next;
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public MenuItem getValue() {
        return value;
    }

    public void setValue(MenuItem value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return Objects.equals(next, listNode.next) && Objects.equals(value, listNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, value);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "next=" + next +
                ", value=" + value +
                '}';
    }
}
