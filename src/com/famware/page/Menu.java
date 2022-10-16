package com.famware.page;

import com.famware.graphic.Bouton;
import com.famware.graphic.FamwareColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Menu extends JPanel {

    JPanel menuPanel = new JPanel();

    public Menu (){
        //ENTETE
        JPanel entete = new JPanel();
        entete.setPreferredSize(new Dimension(800,100));
        entete.setBackground(FamwareColor.firstColor);
        JLabel title = new JLabel("MENU GENERAL");
        title.setForeground(FamwareColor.secondColor);
        title.setFont(new Font("sansserif",Font.CENTER_BASELINE, 32));
        entete.add(title);


        JPanel content = new JPanel();

        //Paramétrages des boutons
        Bouton quitter = new Bouton();
        Bouton consultationDossier = new Bouton();
        Bouton modificationDossier = new Bouton();
        Bouton ajoutDossier = new Bouton();
        consultationDossier.setText("1. Consultation des dossiers");
        modificationDossier.setText("2. Modification des dossiers");
        ajoutDossier.setText("3. Ajout de dossier");
        quitter.setText("Quitter");

        //GBC LAYOUT
        GridBagConstraints gbc =  new GridBagConstraints();
        content.setLayout(new GridBagLayout());


        //Remplissage de la content panel
        content.setBackground(FamwareColor.firstColor);

        gbc.gridx = gbc.gridy = 0;
        gbc.gridwidth = gbc.gridheight = 1;

        gbc.insets = new Insets(20,50,20,50);
        gbc.anchor = GridBagConstraints.LINE_START;
        content.add(consultationDossier, gbc);

        gbc.gridy = 1;
        content.add(modificationDossier, gbc);

        gbc.gridy = 2;
        content.add(ajoutDossier, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        content.add(quitter, gbc);

        menuPanel.add(entete, BorderLayout.NORTH);
        menuPanel.add(content, BorderLayout.CENTER);
        menuPanel.setBackground(FamwareColor.firstColor);
        title.setFocusable(true);
        title.setRequestFocusEnabled(true);
        title.requestFocusInWindow();

        title.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });











        //PARAMETRAGES DES BOUTONS
        quitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PageChanger.ChangePage("accueil");
            }
        });

        consultationDossier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PageChanger.ChangePage("cdoss");
            }
        });



    }

}
