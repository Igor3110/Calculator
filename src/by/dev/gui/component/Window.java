package by.dev.gui.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import static by.dev.gui.util.Constant.*;

public class Window extends JFrame {

    public static Boolean start;

    public Window(String title) {
        Panel window;
        Panel panelButtons;
        Field display;
        BigDecimal result;
        String lastCommand;
        ActionListener insertActionListener;
        ActionListener commandActionListener;

        result = BigDecimal.ZERO;
        lastCommand = EQUELS;
        start = true;

        window = new Panel(new BorderLayout());

        display = new Field(EMPTY_STRING);

        window.add(NORTH, display);

        panelButtons = new Panel(new GridLayout(4, 4));

        insertActionListener = new InsertActionListener(display);
        commandActionListener = new CommandActionListener(lastCommand, display, result);

        addButtonsToPanel(panelButtons, insertActionListener, commandActionListener);

        window.add(CENTER, panelButtons);

        setContentPane(window);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addButtonsToPanel(JPanel panelButtons, ActionListener insertActionListener, ActionListener commandActionListener) {
        addButtonToPanel(SEVEN, panelButtons, insertActionListener);
        addButtonToPanel(EIGHT, panelButtons, insertActionListener);
        addButtonToPanel(NINE, panelButtons, insertActionListener);
        addButtonToPanel(DIVIDE, panelButtons, commandActionListener);

        addButtonToPanel(FOUR, panelButtons, insertActionListener);
        addButtonToPanel(FIVE, panelButtons, insertActionListener);
        addButtonToPanel(SIX, panelButtons, insertActionListener);
        addButtonToPanel(MULTIPLY, panelButtons, commandActionListener);

        addButtonToPanel(ONE, panelButtons, insertActionListener);
        addButtonToPanel(TWO, panelButtons, insertActionListener);
        addButtonToPanel(THREE, panelButtons, insertActionListener);
        addButtonToPanel(MINUS, panelButtons, commandActionListener);

        addButtonToPanel(ZERO, panelButtons, insertActionListener);
        addButtonToPanel(POINT, panelButtons, insertActionListener);
        addButtonToPanel(EQUELS, panelButtons, commandActionListener);
        addButtonToPanel(PLUS, panelButtons, commandActionListener);
    }

    private void addButtonToPanel(String text, JPanel panelButtons, ActionListener listener) {
        Button button;
        button = new Button(text);
        button.addActionListener(listener);
        panelButtons.add(button);
    }

}
