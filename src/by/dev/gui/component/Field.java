package by.dev.gui.component;

import javax.swing.*;

public class Field extends JTextField {

     public Field(String text) {
         this.setText(text);
         this.setColumns(12);
         this.setEnabled(false);
         this.setFont(this.getFont().deriveFont(50f));
     }

}
