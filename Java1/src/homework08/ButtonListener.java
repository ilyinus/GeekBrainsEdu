package homework08;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ButtonListener implements ActionListener {
    private JTextField field;
    private List<Double> operands = new ArrayList<>();
    private List<String> operators = new ArrayList<>();
    private String currentText;
    private ButtonType lastButtonType;
    private boolean dotApproved = true;
    private int position;

    public ButtonListener(JTextField field) {
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonType type = ((Button) e.getSource()).getType();
        currentText = field.getText();

        if (type == ButtonType.DIGIT)
            addDigit(e.getActionCommand());
        if (type == ButtonType.DOT)
            addDot();
        if (type == ButtonType.CLEAR)
            clear();
        if (type == ButtonType.OPERATION)
            applyOperation(e.getActionCommand());
        if (type == ButtonType.EQUALS)
            calculate();

        if (type != ButtonType.DOT)
            lastButtonType = type;

    }

    private void clear() {
        operators.clear();
        operands.clear();
        position = 0;
        field.setText("0");
        dotApproved = true;
    }

    private void applyOperation(String operation) {

        if (lastButtonType == ButtonType.DIGIT || lastButtonType == ButtonType.EQUALS) {
            field.setText(currentText + operation);
            operands.add(Double.valueOf(currentText.substring(position)));
            operators.add(operation);
            position = currentText.length() + 1;
            dotApproved = true;
        }

    }

    private void addDot() {

        if (dotApproved && lastButtonType == ButtonType.DIGIT) {
            field.setText(currentText + ".");
            dotApproved = false;
        }

    }

    private void addDigit(String digit) {

        if (currentText.equals("0") && digit.equals("0"))
            return;

        if (currentText.equals("0") || lastButtonType == ButtonType.EQUALS)
            field.setText("");

        field.setText(field.getText() + digit);

    }

    private void calculate() {
        double result = 0;

        String lastSign = field.getText().substring(position);

        if (lastButtonType == ButtonType.DIGIT)
            operands.add(Double.valueOf(lastSign));

        for (int i = 0; i < operands.size(); i++) {
            double operand = operands.get(i);

            if (i == 0) {
                result = operand;
                continue;
            }

            String operator = operators.get(i - 1);

            if (operator.equals("+"))
                result += operand;
            if (operator.equals("-"))
                result -= operand;
            if (operator.equals("*"))
                result *= operand;
            if (operator.equals("/"))
                result /= operand;

        }

        if (result == 0) {
            field.setText("0");
        } else if ((Math.round(result) - result) == 0) {
            field.setText(String.valueOf((int) result));
        } else {
            field.setText(String.valueOf(result));
        }

        operands.clear();
        operators.clear();
        position = 0;

    }

}
