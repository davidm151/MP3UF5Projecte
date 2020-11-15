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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
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

    public Controller() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public void setNomEquipC(String nom) {
//        model.setNomEquip(nom);
//    }
//
//    public String getNomEquipC() {
//        return model.getNomEquip();
//    }
//
//    public void setGolsEnContraC(int x) {
//        model.setGolsEnContra(x);
//    }
//
//    public int getGolsEnContraC() {
//        return model.getGolsEnContra();
//    }
//
//    public void setGolsAfavorC(int x) {
//        model.setGolsAfavor(x);
//    }
//
//    public int getGolsAfavorC() {
//        return model.getGolsAfavor();
//    }
//
//    public void setPartitsGuanyats(int x) {
//        model.setPartitsGuanyats(x);
//    }
//
//    public int getPartitsGuanyats() {
//        return model.getPartitsGuanyats();
//    }
//
//    public void setPartitsPerduts(int x) {
//        model.setPartitsPerduts(x);
//    }
//
//    public int getPartitsPerduts() {
//        return model.getPartitsPerduts();
//    }
//
//    public void setPuntsEquip(int x) {
//        model.setPuntsEquip(x);
//    }
//
//    public int getPuntsEquip() {
//        return model.getPuntsEquip();
//    }
//
//    public void setJornada(int x) {
//        model.setJornada(x);
//    }
//
//    public int getJornada() {
//        return model.getJornada();
//    }
//
//    public void setPartitsEmpatats(int x) {
//        model.setPartitsEmpatats(x);
//    }
//
//    public int getPartitsEmpatats() {
//        return model.getPartitsEmpatats();
//    }
    


//    public void getAfegirEquips() {
//        JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
//    }
    
    


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
        
        
        
        view.getAfegirEquip().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //m.setV2((int) v.getjSpinner2().getValue());
                
                model.setGolsAfavor(Integer.parseInt(view.getGolsAfavor().getText()));
                model.setGolsEnContra(Integer.parseInt(view.getGolsEnContra().getText()));
                model.setJornada(Integer.parseInt(view.getJornada().getText()));
                model.setPuntsEquip(Integer.parseInt(view.getPuntsEquip().getText()));
                model.setPartitsEmpatats(Integer.parseInt(view.getPartitsEmpats().getText()));
                model.setPartitsGuanyats(Integer.parseInt(view.getPartitsGuanyats().getText()));
                model.setPartitsPerduts(Integer.parseInt(view.getPartitsPerduts().getText()));
                model.setNomEquip(view.getNomEquip().getText());
                System.out.println(model.getGolsAfavor());
                System.out.println(model.getGolsEnContra());
                System.out.println(model.getJornada());
                System.out.println(model.getNomEquip());
                System.out.println(model.getPartitsEmpatats());
                System.out.println(model.getPartitsGuanyats());
                System.out.println(model.getPartitsPerduts());
                System.out.println(model.getPuntsEquip());
                
                
                
                
              
            }
        });
        
        

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

//    public void LlistarTaula(JTable taula) {
//        DefaultTableModel modelTaula = new DefaultTableModel();
//        taula.setModel(modelTaula);
//
//        modelTaula.addColumn("Nom equip");
//        modelTaula.addColumn("Gols afavor");
//        modelTaula.addColumn("Gols en contra");
//        modelTaula.addColumn("Jornada");
//        modelTaula.addColumn("Partits guanyats");
//        modelTaula.addColumn("Partits empatats");
//        modelTaula.addColumn("Partits perduts");
//        modelTaula.addColumn("Punts");
//        Object[] columna = new Object[8];
//    }

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
