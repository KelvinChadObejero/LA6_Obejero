package FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame {
    // Declare the components from GUI Designer
    private JPanel panel1;

    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;

    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JRadioButton rbNone;

    private JButton btnOrder;

    // Constructor
    public FoodOrderingSystem() {
        // Set the title of the window
        setTitle("Food Ordering System");

        // Action listener for the "Order" button
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Initialize the total price to 0
                double totalPrice = 0;

                // Calculate the total price based on selected food items
                if (cPizza.isSelected()) totalPrice += 100;
                if (cBurger.isSelected()) totalPrice += 80;
                if (cFries.isSelected()) totalPrice += 65;
                if (cSoftDrinks.isSelected()) totalPrice += 55;
                if (cTea.isSelected()) totalPrice += 50;
                if (cSundae.isSelected()) totalPrice += 40;

                // Apply the selected discount (if any)
                double discount = 0;
                if (rb5.isSelected()) {
                    discount = 0.05;  // 5% discount
                } else if (rb10.isSelected()) {
                    discount = 0.10;  // 10% discount
                } else if (rb15.isSelected()) {
                    discount = 0.15;  // 15% discount
                }

                // Apply the discount to the total price
                double finalPrice = totalPrice * (1 - discount);

                // Display the total price using JOptionPane
                JOptionPane.showMessageDialog(null, "The total price is Php " + String.format("%.2f", finalPrice));
            }
        });
    }

    public static void main(String[] args) {
        // Create and display the app
        FoodOrderingSystem app = new FoodOrderingSystem();
        app.setContentPane(app.panel1);  // Use the root panel from your GUI Designer
        app.setSize(300, 400);  // Set the window size
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the app when window is closed
        app.setVisible(true);  // Make the window visible
    }
}
