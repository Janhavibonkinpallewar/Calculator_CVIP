import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculatorGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 400);

            JTextField display = new JTextField();
            display.setEditable(false);
            frame.add(display, BorderLayout.NORTH);

            JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
            String[] buttonLabels = {
                    "7", "8", "9", "/",
                    "4", "5", "6", "*",
                    "1", "2", "3", "-",
                    "0", "C", "=", "+"
            };

            for (String label : buttonLabels) {
                JButton button = new JButton(label);
                button.addActionListener(new CalculatorActionListener(display, label));
                buttonPanel.add(button);
            }

            frame.add(buttonPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }

    static class CalculatorActionListener implements ActionListener {
        private final JTextField display;
        private final String buttonLabel;

        public CalculatorActionListener(JTextField display, String buttonLabel) {
            this.display = display;
            this.buttonLabel = buttonLabel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttonLabel.equals("=")) {
                try {
                    String expression = display.getText();
                    double result = evaluateExpression(expression);
                    display.setText(Double.toString(result));
                } catch (Exception ex) {
                    display.setText("Error");
                }
            } else if (buttonLabel.equals("C")) {
                display.setText("");
            } else {
                display.setText(display.getText() + buttonLabel);
            }
        }

        private double evaluateExpression(String expression) {
            // You'll need to implement the actual expression evaluation here.
            // For simplicity, you can use JavaScript engine, or you can write your
            // own expression parser.
            // Example using JavaScript engine:
            // ScriptEngineManager manager = new ScriptEngineManager();
            // ScriptEngine engine = manager.getEngineByName("js");
            // return (double) engine.eval(expression);
            return 0.0;
        }
    }
}
