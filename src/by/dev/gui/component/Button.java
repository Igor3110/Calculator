package by.dev.gui.component;

import javax.swing.*;

public class Button extends JButton {

    public Button(String text) {
        this.setText(text);
        this.setFont(this.getFont().deriveFont(40f));
    }

}
