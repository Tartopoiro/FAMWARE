package com.famware.page;

import com.famware.graphic.Bouton;
import com.famware.graphic.FamwareColor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ConsultationDossier extends JPanel {
    JPanel cDosspanel = new JPanel();

    public ConsultationDossier (){
        //JDBC
        try {
            //ENTETE
            JPanel entete = new JPanel();
            entete.setPreferredSize(new Dimension(800,100));
            entete.setBackground(FamwareColor.firstColor);

            JLabel title = new JLabel("LISTE DES DOSSIERS");
            title.setForeground(FamwareColor.secondColor);
            title.setFont(new Font("sansserif",Font.CENTER_BASELINE, 32));

            entete.add(title);

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "FAMWARE.basset");
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM representant");

            //Construction du Tableau
            String num = "";
            String mail = "";
            String nom = "";
            String prenom = "";

            String[] columnNames = {
                    "Prénom","Nom","mail","numéro"
            };

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);
            JTable array = new JTable();
            array.setDefaultEditor(Object.class, null);
            array.setAutoCreateRowSorter(true);
            array.setModel(model);
            array.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            array.setFillsViewportHeight(true);

            while (res.next()) {
                mail = res.getString(3);
                num = res.getString(2);
                nom = res.getString(4);
                prenom = res.getString(5);
                model.addRow(new Object[]{prenom, nom, mail, num});
            }
            conn.close();

            //graphics
            cDosspanel.setBackground(FamwareColor.firstColor);
            JScrollPane jsarray = new JScrollPane(array);
            jsarray.setBackground(FamwareColor.firstColor);
            jsarray.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
            cDosspanel.add(entete, BorderLayout.NORTH);
            cDosspanel.add(jsarray, BorderLayout.CENTER);


        }


        catch(Exception e){
            System.out.println(e);
        }

    }
}
