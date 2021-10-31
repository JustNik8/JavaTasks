package task16.custom.components;

import task16.customer.Address;
import task16.customer.Customer;
import task16.gui.AddMenuItemGUI;
import task16.menuitems.Drink;
import task16.menuitems.MenuItem;
import task16.orders.Order;

import javax.swing.*;
import java.awt.*;

public class OrderItem extends Container {

    private JLabel orderLabel;
    private JLabel customerLabel;
    private JButton addButton;
    private Order order;

    public OrderItem(Order order) {
        this.order = order;

        Customer customer = order.getCustomer();
        String customerInfo = customer.getFirstName() + " " + customer.getSecondName() + " " +
                customer.getAge() + " " + customer.getAddress().toString();

        customerLabel = new JLabel(customerInfo);

        StringBuilder builder = new StringBuilder("<html>");
        MenuItem[] items = order.getItems();
        for (MenuItem item : items) {
            if (item != null) {
                builder.append(item.getName()).append(" ").append(item.getCost()).append(" ").append(item.getDescription());
                if (item instanceof Drink) {
                    Drink drink = (Drink) item;
                    builder.append(" ").append(drink.getType()).append(" ").append(drink.getAlcoholVol());
                }
                builder.append("<br/>");
            }
        }
        builder.append("</html>");

        orderLabel = new JLabel(builder.toString());
        addButton = new JButton("Add item");

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        customerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addButton.addActionListener(e -> {
            AddMenuItemGUI addMenuItemGUI = new AddMenuItemGUI(this.order);
            addMenuItemGUI.setVisible(true);
        });
        this.add(customerLabel);
        this.add(orderLabel);
        this.add(addButton);
    }

    public Order getOrder() {
        return order;
    }

}
