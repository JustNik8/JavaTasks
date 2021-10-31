package task16.custom.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class HintTextField extends JTextField {
    private final Font gainFont = new Font("Tahoma", Font.PLAIN, 14);
    private final Font lostFont = new Font("Tahoma", Font.ITALIC, 14);



    public HintTextField(final String hint, final int columns){
        super(columns);
        setText(hint);
        setFont(lostFont);
        setForeground(Color.GRAY);

        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(hint)){
                    setText("");
                }
                else{
                    setText(getText());
                }
                setFont(gainFont);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().equals(hint) || getText().length() == 0){
                    setText(hint);
                    setFont(lostFont);
                    setForeground(Color.GRAY);
                }
                else{
                    setText(getText());
                    setFont(gainFont);
                    setForeground(Color.BLACK);
                }
            }
        });
    }
}
