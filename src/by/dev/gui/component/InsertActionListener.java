package by.dev.gui.component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static by.dev.gui.util.Constant.EMPTY_STRING;

public class InsertActionListener implements ActionListener {

    private final JTextField display;

    public InsertActionListener(JTextField display) {
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String input = event.getActionCommand();
        if (Window.start) {
            display.setText(EMPTY_STRING);
            Window.start = false;
        }
        display.setText(display.getText() + input);
    }

}
