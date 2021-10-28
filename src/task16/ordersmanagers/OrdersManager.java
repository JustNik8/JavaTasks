package task16.ordersmanagers;

import task16.menuitems.MenuItem;
import task16.orders.Order;

public interface OrdersManager {
    int itemsQuantity();
    int itemsQuantity(String itemName);
    int itemsQuantity(MenuItem item);
    Order[] getOrders();
    int ordersCostSummary();
    int ordersQuantity();
}
