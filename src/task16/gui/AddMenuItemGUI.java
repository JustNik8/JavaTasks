package task16.gui;

import task16.custom.components.HintTextField;
import task16.custom.components.OrderItem;
import task16.menuitems.Dish;
import task16.menuitems.Drink;
import task16.menuitems.DrinkTypeEnum;
import task16.orders.Order;
import javax.swing.*;
import java.awt.*;

public class AddMenuItemGUI extends JFrame {

    private final Container mainContainer = this.getContentPane();
    private JCheckBox alcoCheckBox;
    private final DefaultComboBoxModel<DrinkTypeEnum> drinkTypesModel = new DefaultComboBoxModel<>();
    private JComboBox<DrinkTypeEnum> drinkTypes;
    private HintTextField alcoVolTextField = new HintTextField("Alcohol volume", 15);

    private JRadioButton dishRadioButton;
    private JRadioButton drinkRadioButton;

    public AddMenuItemGUI(Order order) {
        super("Add item");
        this.setBounds(300,300, 400, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.PAGE_AXIS));

        alcoVolTextField.setEnabled(false);
        alcoVolTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        alcoVolTextField.setMaximumSize(alcoVolTextField.getPreferredSize());

        JButton addButton = new JButton("Add");
        setDefaultSettingForButton(addButton);
        addButton.addActionListener(e -> {
            JTextField tempTF = (JTextField) mainContainer.getComponent(3);
            try {
                int cost = Integer.parseInt(tempTF.getText());

                tempTF = (JTextField) mainContainer.getComponent(4);
                String name = tempTF.getText();

                tempTF = (JTextField) mainContainer.getComponent(5);
                String description = tempTF.getText();

                DrinkTypeEnum drinkType;

                if (drinkRadioButton.isSelected()){
                    drinkType = (DrinkTypeEnum) drinkTypes.getSelectedItem();
                    float alcoVol = 0;
                    if (alcoCheckBox.isSelected()){
                        tempTF = (JTextField) mainContainer.getComponent(7);
                        alcoVol = Float.parseFloat(tempTF.getText());
                    }
                    Drink drink = new Drink(cost, name, description, alcoVol, drinkType);
                    System.out.println(drink);
                    order.add(drink);

                }
                else{
                    Dish dish = new Dish(cost, name, description);
                    System.out.println(dish);
                    order.add(dish);
                }
                dispose();
            }
            catch (Exception exception){
                showMessage("Error");
            }
        });

        JButton backButton = new JButton("Back");
        setDefaultSettingForButton(backButton);
        backButton.addActionListener(e -> {
            dispose();
        });

        addLabel("Set menu item", mainContainer);
        initTypeRadioButtons();
        addHintTextField("Cost", 15, mainContainer);
        addHintTextField("Name", 15, mainContainer);
        addHintTextField("Description", 15, mainContainer);
        initAlocohableCheckBox();
        mainContainer.add(alcoVolTextField);
        initTypeComboBox();
        mainContainer.add(addButton);
        mainContainer.add(backButton);
    }

    private void initTypeRadioButtons(){
        //Set up radio buttons for type
        ButtonGroup typeGroup = new ButtonGroup();
        dishRadioButton = new JRadioButton("Dish");
        dishRadioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        dishRadioButton.setSelected(true);
        typeGroup.add(dishRadioButton);
        dishRadioButton.addActionListener(e -> {
            alcoCheckBox.setEnabled(false);
            drinkTypes.setEnabled(false);
        });

        drinkRadioButton = new JRadioButton("Drink");
        drinkRadioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        typeGroup.add(drinkRadioButton);
        drinkRadioButton.addActionListener(e -> {
            alcoCheckBox.setEnabled(true);
            drinkTypes.setEnabled(true);
        });

        mainContainer.add(dishRadioButton);
        mainContainer.add(drinkRadioButton);
    }

    private void initAlocohableCheckBox(){
        alcoCheckBox = new JCheckBox("is Alcohohable");
        alcoCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        alcoCheckBox.setEnabled(false);
        alcoCheckBox.addActionListener(e -> {
            updateComboBoxModel(alcoCheckBox.isSelected());
            alcoVolTextField.setEnabled(true);
        });

        mainContainer.add(alcoCheckBox);
    }

    private void addHintTextField(String hint, int columns, Container container){
        HintTextField textField = new HintTextField(hint, columns);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setMaximumSize(textField.getPreferredSize());
        container.add(textField);
    }

    private void addLabel(String text, Container container){
        JLabel jLabel = new JLabel(text);
        Font font = new Font("Tahoma", Font.PLAIN, 24);
        jLabel.setFont(font);
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(jLabel);
    }

    private void initTypeComboBox(){
        updateComboBoxModel(false);
        drinkTypes = new JComboBox<>(drinkTypesModel);
        drinkTypes.setMaximumRowCount(5);
        drinkTypes.setEnabled(false);

        JPanel typePanel = new JPanel();
        typePanel.add(drinkTypes);
        mainContainer.add(typePanel);
    }

    private void updateComboBoxModel(boolean isAlcoholable){
        drinkTypesModel.removeAllElements();
        if (isAlcoholable){
            drinkTypesModel.addElement(DrinkTypeEnum.BEER);
            drinkTypesModel.addElement(DrinkTypeEnum.WINE);
            drinkTypesModel.addElement(DrinkTypeEnum.VODKA);
            drinkTypesModel.addElement(DrinkTypeEnum.BRANDY);
            drinkTypesModel.addElement(DrinkTypeEnum.CHAMPAGNE);
            drinkTypesModel.addElement(DrinkTypeEnum.WHISKEY);
            drinkTypesModel.addElement(DrinkTypeEnum.TEQUILA);
            drinkTypesModel.addElement(DrinkTypeEnum.RUM);
            drinkTypesModel.addElement(DrinkTypeEnum.VERMUTH);
            drinkTypesModel.addElement(DrinkTypeEnum.LIQUOR);
            drinkTypesModel.addElement(DrinkTypeEnum.JAGERMEISTER);
        }
        else{
            drinkTypesModel.addElement(DrinkTypeEnum.JUICE);
            drinkTypesModel.addElement(DrinkTypeEnum.COFFEE);
            drinkTypesModel.addElement(DrinkTypeEnum.GREEN_TEA);
            drinkTypesModel.addElement(DrinkTypeEnum.BLACK_TEA);
            drinkTypesModel.addElement(DrinkTypeEnum.MILK);
            drinkTypesModel.addElement(DrinkTypeEnum.WATER);
            drinkTypesModel.addElement(DrinkTypeEnum.SODA);
        }
    }

    private void setDefaultSettingForButton(JButton button){
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("Tahoma", Font.PLAIN, 20));
    }

    private void showMessage(String text){
        JOptionPane.showMessageDialog(
                null,
                text,
                "Attention",
                JOptionPane.PLAIN_MESSAGE
        );
    }


}
