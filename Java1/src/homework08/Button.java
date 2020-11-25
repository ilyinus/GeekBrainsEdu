package homework08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Button extends JButton {
    private ButtonType type;

    public Button(ButtonType type, String title, ActionListener listener) {
        this.type = type;
        addActionListener(listener);
        setText(title);
        setFont(new Font("DIALOG", Font.PLAIN, 18));
    }

    public ButtonType getType() {
        return type;
    }
}
