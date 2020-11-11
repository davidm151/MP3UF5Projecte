/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTable;
import model.Model;
import view.View;

/**
 *
 * @author profe
 */
public class Controller {

    private static Model model;
    private static View view;

    public Controller(Model m, View v) {
        model = m;
        view = v;
        controlador();
    }

    private void controlador() {

        //Codi que inicilitza la vista
        view.setVisible(true);

        //Codi que assigna els listeners als components de la vista
        //Combo Jornades
        view.getJornades().addItem("Jornada 1");
        view.getJornades().addItem("Jornada 2");
        view.getJornades().addItem("Jornada 3");
        view.getJornades().addItem("Jornada 4");
        view.getJornades().addItem("Jornada 5");
        view.getJornades().addItem("Jornada 6");
        view.getJornades().addItem("Jornada 7");
        view.getJornades().addItem("Jornada 8");

        //Combo Zona Classificacio
        view.getZonaClassificacio().addItem("Champions");
        view.getZonaClassificacio().addItem("Europa Legue");
        view.getZonaClassificacio().addItem("Descens");

        String data[][] = {{"Barcelona", "20", "4", "8", "6", "1", "1", "19"},
        {"Cadiz", "12", "6", "8", "4", "2", "2", "14"},
        {"Celta", "9", "9", "8", "2", "4", "2", "10"}};
        String column[] = {"Nom equip", "Gols afavor", "Gols en contra", "Jornada", "Partits guanyats", "Partits empatats", "Partits perduts", "Punts"};
        model.setColumn(column);
        model.getColumn();
        model.setData(data);
        model.getData();
        JTable jt=new JTable(data,column);
        model.setJt(jt);
        
        view.setTaulaJugadors(jt);
    }

    //Per implementar els ActionEvents dels components de la vista (útil per 
    //exemple, per controlar l'acció que s'executa quan fem clic a un botó tant 
    //usant el ratolí com si l'apretem en la barra del teclat  
    static class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    //Per implementar els KeyEvents
    //També podem usar un KeyAdapter
    //static class Key extends KeyAdapter{}
    static class Key implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    //Podem posar tots els listeners necessaris...
}
