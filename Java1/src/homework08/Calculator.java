package homework08;

import javax.swing.*;

public class Calculator extends JFrame {

    public Calculator() {
        super("Калькулятор");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new MainPanel();

        setContentPane(mainPanel);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Calculator();
    }

}
