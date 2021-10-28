package task16;


import task16.customer.Address;
import task16.customer.Customer;
import task16.menuitems.Dish;
import task16.menuitems.Drink;
import task16.menuitems.DrinkTypeEnum;
import task16.menuitems.MenuItem;
import task16.orders.Order;
import task16.orders.internetorder.InternetOrder;
import task16.ordersmanagers.internetordersmanager.InternetOrdersManager;

import java.util.Arrays;

public class Task16Main {
    public static void main(String[] args) {
        InternetOrdersManager manager = new InternetOrdersManager();

        Customer customer = new Customer("Sanya", "Kireev", 19, Address.EMPTY_ADDRESS);
        InternetOrder order = new InternetOrder(customer);

        manager.add(order);

        MenuItem drink1 = new Drink(100, "beer", "desc", 5.8, DrinkTypeEnum.BEER);
        MenuItem dish1 = new Dish(500, "pelmeni", "vkusno");
        order.add(drink1);
        order.add(dish1);

        Order[] orders = manager.getOrders();
        order.remove(dish1);
    }

    private static <T> void  printArray(T[] arr){
        for (T t: arr){
            System.out.println(t);
        }
    }
}
