package homework08;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel() {
        setLayout(new BorderLayout());

        // Поле ввоода\вывода
        JTextField field = new JTextField();
        field.setEditable(false);
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setFont(new Font("DIALOG", Font.BOLD, 24));
        field.setText("0");

        add(field, BorderLayout.NORTH);

        // Кнопки
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5 ,5));

        ButtonListener buttonListener = new ButtonListener(field);

        buttonPanel.add(new Button(ButtonType.DIGIT,     "7" , buttonListener));
        buttonPanel.add(new Button(ButtonType.DIGIT,     "8" , buttonListener));
        buttonPanel.add(new Button(ButtonType.DIGIT,     "9" , buttonListener));
        buttonPanel.add(new Button(ButtonType.OPERATION, "+" , buttonListener));
        buttonPanel.add(new Button(ButtonType.DIGIT,     "4" , buttonListener));
        buttonPanel.add(new Button(ButtonType.DIGIT,     "5" , buttonListener));
        buttonPanel.add(new Button(ButtonType.DIGIT,     "6" , buttonListener));
        buttonPanel.add(new Button(ButtonType.OPERATION, "-" , buttonListener));
        buttonPanel.add(new Button(ButtonType.DIGIT,     "1" , buttonListener));
        buttonPanel.add(new Button(ButtonType.DIGIT,     "2" , buttonListener));
        buttonPanel.add(new Button(ButtonType.DIGIT,     "3" , buttonListener));
        buttonPanel.add(new Button(ButtonType.OPERATION, "*" , buttonListener));
        buttonPanel.add(new Button(ButtonType.DOT,       "." , buttonListener));
        buttonPanel.add(new Button(ButtonType.DIGIT,     "0" , buttonListener));
        buttonPanel.add(new Button(ButtonType.EQUALS,    "=" , buttonListener));
        buttonPanel.add(new Button(ButtonType.OPERATION, "/" , buttonListener));
        buttonPanel.add(new Button(ButtonType.CLEAR,     "CE", buttonListener));

        add(buttonPanel);

    }

}
