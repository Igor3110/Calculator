package by.dev.gui.component;

import javax.swing.*;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static by.dev.gui.util.Constant.*;

public class CommandActionListener implements ActionListener {

    private String lastCommand;
    private final JTextField display;
    private BigDecimal result;

    public CommandActionListener(String lastCommand, JTextField display, BigDecimal result) {
        this.lastCommand = lastCommand;
        this.display = display;
        this.result = result;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String command = event.getActionCommand();
            if (Window.start) {
                if (command.equals(MINUS)) {
                    display.setText(command);
                    Window.start = false;
                } else {
                    lastCommand = command;
                }
            } else {
                calculate(new BigDecimal(display.getText()));
                lastCommand = command;
                Window.start = true;
            }
        } catch (NumberFormatException e) {
            display.setText(EMPTY_STRING);
            JOptionPane.showMessageDialog(null, NUMBER_FORMAT_EXCEPTION, MISTAKE, JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void calculate(BigDecimal x) {
        switch (lastCommand) {
            case PLUS:
                result = result.add(x);
                break;
            case MINUS:
                result = result.subtract(x);
                break;
            case MULTIPLY:
                result = result.multiply(x);
                break;
            case DIVIDE:
                result = result.divide(x);
                break;
            case EQUELS:
                result = x;
                break;
        }
        if (result.compareTo(BigDecimal.ZERO) == 0) {
            result = BigDecimal.ZERO;
        }
        display.setText(result.toString());
    }

}
