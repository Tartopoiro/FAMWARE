package com.famware.graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

public class FamPasswordField extends JPasswordField {

    FamPasswordField th = this;
    public FamPasswordField(String text, int columns) {
        super(text, columns);
        setEchoChar((char) 0);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(6, 8, 6, 8));
        setForeground(FamwareColor.mutedText);
        setFont(new Font("sansserif",Font.BOLD,14));


        th.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if (Objects.equals(th.getText(), text)){
                    th.setForeground(Color.BLACK);
                    th.setText(null);
                    th.setEchoChar('•');
                }

            }

            @Override
            public void focusLost(FocusEvent e) {

                if (th.getText().isEmpty() ){
                    th.setForeground(FamwareColor.mutedText);
                    th.setText(text);
                    th.setEchoChar((char) 0);
                }

            }

        });
    }


    protected void paintComponent(Graphics g) {
        int width = th.getWidth();
        int height = th.getHeight();

        g.setColor(Color.WHITE);
        g.fillRoundRect(0, 0, width, height, 20, 30);
        super.paintComponent(g);

    }

}
