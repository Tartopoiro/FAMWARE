package com.famware.graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

// Classe définissant l'esthetique des boutons
public class Bouton extends JButton {
    JButton button = this;

    public Bouton() {

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBorder(null);
        button.setFont(new Font("sansserif", Font.BOLD, 18));
        button.setFocusable(false);

        //Paramétrage de la réponse graphique
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        button.setCursor(cursor);
        button.setForeground(Color.white);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {

                button.setForeground(FamwareColor.secondColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {

                button.setForeground(Color.white);

            }
        });


    }
}
