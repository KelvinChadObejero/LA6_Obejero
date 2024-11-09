package SimpleCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    // Declare components (they should already be set in your GUI Designer)
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JComboBox<String> cbOperations;
    private JButton btnCompute;
    private JLabel lblResult;
    private JPanel panel1;

    public SimpleCalculator() {
        // Set the title of the window
        setTitle("Simple Calculator");

        // Action listener for the Compute button
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse numbers from text fields
                    double num1 = Double.parseDouble(tfNumber1.getText().trim());
                    double num2 = Double.parseDouble(tfNumber2.getText().trim());

                    // Get the selected operator from combo box
                    String operator = (String) cbOperations.getSelectedItem();
                    double result = 0;

                    // Perform the operation based on the selected operator
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                lblResult.setText("Error: Division by zero");
                                return;
                            }
                            break;
                    }

                    // Display the result in the label
                    lblResult.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    lblResult.setText("Error: Invalid input");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Create and display the app
        SimpleCalculator app = new SimpleCalculator();
        app.setContentPane(app.panel1);  // Set the content pane to the panel created by GUI Designer
        app.setSize(700, 300);  // Set the window size
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the app when window is closed
        app.setVisible(true);  // Make the window visible
    }
}
