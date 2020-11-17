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
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import model.Equip;
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
//                
                DefaultTableModel model = (DefaultTableModel) view.getTaulaJugadors().getModel();
                Object[] obj = Model.afegir(view.getNomEquip().getText(), Integer.parseInt(view.getGolsEnContra().getText()), Integer.parseInt(view.getGolsAfavor().getText()), Integer.parseInt(view.getPartitsGuanyats().getText()),Integer.parseInt(view.getPartitsPerduts().getText()), Integer.parseInt(view.getPartitsEmpats().getText()), Integer.parseInt(view.getPuntsEquip().getText()), Integer.parseInt(view.getJornada().getText()));

                model.addRow(obj);
                
                System.out.println(Arrays.toString(obj));

            }
        });

        view.getEliminarEquip().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel model = (DefaultTableModel) view.getTaulaJugadors().getModel();
                int filaSel = view.getTaulaJugadors().getSelectedRow();
                Model.borrar(filaSel);
                model.removeRow(filaSel);
                
            }

        });
        
        view.getBotoEditar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

               //Anem a mostrar el contingut del vector dins de la taula
                DefaultTableModel model = (DefaultTableModel) view.getTaulaJugadors().getModel();
                int filaSel = view.getTaulaJugadors().getSelectedRow();
                Object[] obj = Model.modificar(filaSel,view.getNomEquip().getText(), Integer.parseInt(view.getGolsEnContra().getText()), Integer.parseInt(view.getGolsAfavor().getText()), Integer.parseInt(view.getPartitsGuanyats().getText()),Integer.parseInt(view.getPartitsPerduts().getText()), Integer.parseInt(view.getPartitsEmpats().getText()), Integer.parseInt(view.getPuntsEquip().getText()), Integer.parseInt(view.getJornada().getText()));
                model.removeRow(filaSel);
                //Equip.modificar(filaSel);
                model.insertRow(filaSel, obj);
                
            }
        });
    }

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
