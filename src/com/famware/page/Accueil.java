package com.famware.page;

import com.famware.graphic.Bouton;
import com.famware.graphic.FamPasswordField;
import com.famware.graphic.FamTextField;
import com.famware.graphic.FamwareColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.KeyStore;
import java.sql.*;


import static java.awt.TextArea.SCROLLBARS_VERTICAL_ONLY;

public class Accueil extends JPanel{

    //DECLARATION DES VARIABLES DE CLASSES
    JPanel accueilPanel = new JPanel();






    public Accueil() {

        //ESTHETIQUE DE L'ENTETE
        JPanel entete = new JPanel();

        FamTextField id = new FamTextField("Identifiant",10);
        FamPasswordField mdp = new FamPasswordField("Mot de passe",10);


        ImageIcon logo = new ImageIcon(getClass().getResource("logo-no-background.png"));
        JLabel labelLogo = new JLabel (logo);
        labelLogo.setSize(600,80);
        labelLogo.setBorder(BorderFactory.createEmptyBorder(0,0,0,100));

        Bouton connexion = new Bouton();
        connexion.setText("Connexion");
        connexion.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));

        entete.setBackground(FamwareColor.firstColor);
        entete.setSize(1000,80);
        entete.add(labelLogo);
        entete.add(id);
        entete.add(mdp);
        entete.add(connexion);
        entete.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));

        //LE DEVLOG :

        String textdevlog ="DEVLOG \n\r\n\r";
        TextArea devlog = new TextArea(textdevlog,30,50, SCROLLBARS_VERTICAL_ONLY);
        devlog.setEditable(false);
        devlog.setFocusable(false);
        JPanel pdevlog = new JPanel();
        pdevlog.add(devlog);
        pdevlog.setBackground(FamwareColor.firstColor);
        pdevlog.setBorder(BorderFactory.createEmptyBorder(50,450,0,0));
        pdevlog.setFocusable(false);

        //ESTHETIQUE CONTACT
        JLabel contact = new JLabel("Contact : bbasset.benjamin@gmail.com");
        contact.setForeground(FamwareColor.secondColor);
        contact.setFont( new Font("sansserif",Font.BOLD,18));
        JPanel pContact = new JPanel();
        pContact.add(contact);
        pContact.setBackground(FamwareColor.firstColor);
        pContact.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));



        //ESTHETIQUE GENARAL DE L'ACCUEIL

        accueilPanel.setBackground(FamwareColor.firstColor);
        BorderLayout bl = new BorderLayout();
        accueilPanel.setLayout(bl);
        accueilPanel.add(entete, bl.NORTH);
        accueilPanel.add(pContact, bl.SOUTH);
        accueilPanel.add(pdevlog, bl.CENTER);




        //CONFIGURATION DE LA CONNEXION
        connexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textid = id.getText();
                String textmdp = mdp.getText();
                try {

                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "guest", "guest");
                    PageChanger.ChangePage("menu");

                }
                catch(Exception exception){
                    JFrame pane = new JFrame();
                    pane.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(pane, "Identifiant ou Mot de passe incorrect");
                }

            }
        });

        KeyListener klconnect = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String textid = id.getText();
                    String textmdp = mdp.getText();
                    try {

                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "guest", "guest");
                        PageChanger.ChangePage("menu");

                    }
                    catch(Exception exception){
                        JFrame pane = new JFrame();
                        pane.setAlwaysOnTop(true);
                        JOptionPane.showMessageDialog(pane, "Identifiant ou Mot de passe incorrect");
                }
                
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        id.addKeyListener(klconnect);
        mdp.addKeyListener(klconnect);


    }

    public void connexiondb() {

    }
}
