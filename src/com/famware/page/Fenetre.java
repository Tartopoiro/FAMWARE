package com.famware.page;

import javax.swing.*;
import java.awt.*;


public class Fenetre extends JFrame {

    CardLayout cardLay = new CardLayout();
    Accueil accueil = new Accueil();
    Menu menu = new Menu();






    //Déclaration de la fenetre principale et des differentes zones
    JFrame fenetre = new JFrame();
    static JPanel contentPanel = new JPanel();

    public Fenetre() {

        //Esthétique de la fenetre

        Image icon = Toolkit.getDefaultToolkit().getImage("src/com/famware/page/icon.PNG");
        fenetre.setIconImage(icon);
        fenetre.setSize(1000, 800);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        fenetre.setTitle("FAMWARE 0.1");
        fenetre.setLocationRelativeTo(null);
        fenetre.add(contentPanel, BorderLayout.CENTER);
        contentPanel.setFocusable(false);


        PageChanger.PageConstructor();

    }
}
