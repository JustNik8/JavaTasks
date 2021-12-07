package task16.gui;

import task16.custom.components.HintTextField;
import task16.custom.components.OrderItem;
import task16.customer.Address;
import task16.customer.Customer;
import task16.menuitems.Dish;
import task16.menuitems.Drink;
import task16.menuitems.DrinkTypeEnum;
import task16.menuitems.MenuItem;
import task16.orders.Order;
import task16.orders.internetorder.InternetOrder;
import task16.orders.tableorder.TableOrder;
import task16.ordersmanagers.internetordersmanager.InternetOrdersManager;
import task16.ordersmanagers.tableordersmanager.TableOrdersManager;
import task16.storage.Storage;

import javax.swing.*;
import java.awt.*;

public class OrderGui extends JFrame {

    private static final int MAIN_UI = 0;
    private static final int ADD_ORDER_UI = 1;
    private static final int ORDERS_LIST_UI = 2;

    private final Container mainContainer = this.getContentPane();

    int menuSize = 10;
    private MenuItem[] menuItems = new MenuItem[menuSize];

    public OrderGui(){
        super("Order");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(350, 100, 800, 600);

        setMainUI();

    }

    private void updateUI(int updateType) {
        mainContainer.removeAll();
        mainContainer.revalidate();
        mainContainer.repaint();
        if (updateType == ADD_ORDER_UI){
            setAddOrderUI();
        }
        else if (updateType == ORDERS_LIST_UI){
            setOrdersListUI();
        }
        else{
            setMainUI();
        }
    }

    private void addLabel(String text, Container container){
        JLabel jLabel = new JLabel(text);
        Font font = new Font("Tahoma", Font.PLAIN, 24);
        jLabel.setFont(font);
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(jLabel);
    }

    private void addHintTextField(String hint, int columns, Container container){
        HintTextField textField = new HintTextField(hint, columns);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setMaximumSize(textField.getPreferredSize());
        container.add(textField);
    }

    private void addRadioButton(String text, ButtonGroup group, Container container){
        JRadioButton radioButton= new JRadioButton(text);
        radioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        group.add(radioButton);
        container.add(radioButton);
    }

    private void setMainUI(){
        mainContainer.setLayout(new FlowLayout());

        JButton addOrderButton = new JButton("Add order");
        addOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
        addOrderButton.addActionListener(e -> {
            updateUI(ADD_ORDER_UI);
        });

        JButton watchOrdersButton = new JButton("Watch all orders");
        watchOrdersButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
        watchOrdersButton.addActionListener(e -> {
            updateUI(ORDERS_LIST_UI);
        });

        mainContainer.add(addOrderButton);
        mainContainer.add(watchOrdersButton);
    }

    private void setAddOrderUI(){
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.PAGE_AXIS));

        //Set fields for customerInfo
        //Container customerContainer = new Container();
        //customerContainer.setLayout(new BoxLayout(customerContainer, BoxLayout.PAGE_AXIS));

        addLabel("Customer Info", mainContainer);

        addHintTextField("Enter first name", 15, mainContainer);
        addHintTextField("Enter second name", 15, mainContainer);
        addHintTextField("Enter age", 15, mainContainer);

        //Container addressContainer = new Container();
        //addressContainer.setLayout(new BoxLayout(addressContainer, BoxLayout.PAGE_AXIS));

        addLabel("AddressInfo", mainContainer);

        addHintTextField("City name", 15, mainContainer);
        addHintTextField("Zip code", 15, mainContainer);
        addHintTextField("Street name", 15, mainContainer);
        addHintTextField("Building number", 15, mainContainer);
        addHintTextField("Building letter", 15, mainContainer);
        addHintTextField("Apartment number", 15, mainContainer);

        //Container orderContainer = new Container();
        //orderContainer.setLayout(new BoxLayout(orderContainer, BoxLayout.PAGE_AXIS));

        addLabel("Type of order", mainContainer);

        ButtonGroup orderButtonGroup = new ButtonGroup();
        addRadioButton("Internet order", orderButtonGroup, mainContainer);
        addRadioButton("Table order", orderButtonGroup, mainContainer);

        //Add order button
        JButton addOrderButton = new JButton("Add order");
        addOrderButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        addOrderButton.addActionListener(e -> {
            try {
                JTextField tempTF = (JTextField) mainContainer.getComponent(1);
                JRadioButton internetRB, tableRB;

                String firstName = tempTF.getText();

                tempTF = (JTextField) mainContainer.getComponent(2);
                String secondName = tempTF.getText();

                tempTF = (JTextField) mainContainer.getComponent(3);
                int age = Integer.parseInt(tempTF.getText());

                //12
                internetRB = (JRadioButton) mainContainer.getComponent(12);
                tableRB = (JRadioButton) mainContainer.getComponent(13);
                Address address = null;
                if (internetRB.isSelected()) {
                    tempTF = (JTextField) mainContainer.getComponent(5);
                    String cityName = tempTF.getText();

                    tempTF = (JTextField) mainContainer.getComponent(6);
                    int zipCode = Integer.parseInt(tempTF.getText());

                    tempTF = (JTextField) mainContainer.getComponent(7);
                    String streetName = tempTF.getName();

                    tempTF = (JTextField) mainContainer.getComponent(8);
                    int buildingNumber = Integer.parseInt(tempTF.getText());

                    tempTF = (JTextField) mainContainer.getComponent(9);
                    char buildingLetter = tempTF.getText().charAt(0);

                    tempTF = (JTextField) mainContainer.getComponent(10);
                    int apartmentNumber = Integer.parseInt(tempTF.getText());

                    address = new Address(cityName, zipCode, streetName, buildingNumber, buildingLetter, apartmentNumber);
                    Customer customer = new Customer(firstName, secondName, age, address);

                    InternetOrdersManager manager = Storage.getInternetOrdersManager();
                    InternetOrder order = new InternetOrder(customer);
                    manager.add(order);
                } else if (tableRB.isSelected()) {
                    Customer customer = new Customer(firstName, secondName, age, Address.EMPTY_ADDRESS);
                    TableOrdersManager manager = Storage.getTableOrdersManager();
                    TableOrder order = new TableOrder(customer);
                    manager.add(order, manager.itemsQuantity() + 1);
                }
            }catch (Exception exception){
                showMessage("Ошибка");
            }
        });

        //add back button
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backButton.addActionListener(e -> {
            updateUI(MAIN_UI);
        });


        addLabel("-----------", mainContainer);
        mainContainer.add(addOrderButton);
        mainContainer.add(backButton);
    }

    private void setOrdersListUI(){
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.PAGE_AXIS));

        //Back button
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backButton.addActionListener(e -> {
            updateUI(MAIN_UI);
        });

        //UpdateButton
        JButton updateButton = new JButton("Update");
        updateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        updateButton.addActionListener(e -> {
            updateUI(ORDERS_LIST_UI);
        });

        addLabel("Table orders", mainContainer);
        TableOrdersManager tableManager = Storage.getTableOrdersManager();
        Order[] tableOrders = tableManager.getOrders();
        if (tableOrders != null) {
            for (Order tableOrder : tableOrders) {
                OrderItem orderItem = new OrderItem(tableOrder);
                mainContainer.add(orderItem);
            }
        }

        addLabel("Internet orders", mainContainer);
        InternetOrdersManager internetManager = Storage.getInternetOrdersManager();
        Order[] internetOrders = internetManager.getOrders();
        if (internetOrders != null) {
            for (Order order : internetOrders) {
                OrderItem orderItem = new OrderItem(order);
                mainContainer.add(orderItem);
            }
        }

        addLabel("---------------", mainContainer);
        mainContainer.add(updateButton);
        mainContainer.add(backButton);

    }

    private void showMessage(String text){
        JOptionPane.showMessageDialog(
                null,
                text,
                "Attention",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    public void updateOrdersList(){
        updateUI(ORDERS_LIST_UI);
    }
}
