package com.famware.page;

import java.awt.*;

public class PageChanger extends Fenetre{


    //Déclaration de chaque page
    static Accueil accueil = new Accueil();
    static Menu menu = new Menu();
    static ConsultationDossier cDoss = new ConsultationDossier();

    //Déclaration du layout
    static CardLayout cardLay = new CardLayout();


    //Déclaration de l'historique de page

    public static void PageConstructor () {
        contentPanel.setLayout(cardLay);
        //AJOUT DE CHAQUE PAGE AU CONTENT PANEL
        contentPanel.add(cDoss.cDosspanel, "cdoss");
        contentPanel.add(accueil.accueilPanel, "accueil");
        contentPanel.add(menu.menuPanel, "menu");
        //INITIALISATION DU CONTENT PANEL SUR L'ACCUEIL
        cardLay.show(contentPanel, "accueil");
    }

     public static void ChangePage (String navigateur) {

        cardLay.show(contentPanel, navigateur);

    }
}
