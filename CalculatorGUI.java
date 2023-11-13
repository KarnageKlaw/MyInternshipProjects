import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {
    private JTextField numField1, numField2, resultField;
    private JComboBox<String> operationComboBox;

    public CalculatorGUI() {
        // Set up the JFrame
        super("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        // Create components
        numField1 = new JTextField();
        numField2 = new JTextField();
        operationComboBox = new JComboBox<>(new String[]{"Addition", "Subtraction", "Multiplication", "Division"});
        resultField = new JTextField();
        resultField.setEditable(false);

        JButton calculateButton = new JButton("Calculate");

        // Add components to the JFrame
        add(new JLabel("Number 1:"));
        add(numField1);
        add(new JLabel("Number 2:"));
        add(numField2);
        add(new JLabel("Operation:"));
        add(operationComboBox);
        add(new JLabel("Result:"));
        add(resultField);
        add(calculateButton);

        // Add action listener to the Calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
    }

    private void calculate() {
        try {
            // Get the input values from the text fields
            double num1 = Double.parseDouble(numField1.getText());
            double num2 = Double.parseDouble(numField2.getText());

            // Perform the selected operation
            int selectedIndex = operationComboBox.getSelectedIndex();
            double result = 0;

            switch (selectedIndex) {
                case 0:
                    result = num1 + num2;
                    break;
                case 1:
                    result = num1 - num2;
                    break;
                case 2:
                    result = num1 * num2;
                    break;
                case 3:
                    // Check for division by zero
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Error: Division by zero is not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Error: Invalid operation choice.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }

            // Display the result
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI calculatorGUI = new CalculatorGUI();
            calculatorGUI.setVisible(true);
        });
    }
}
