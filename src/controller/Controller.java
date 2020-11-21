/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import model.Equip;
import model.Jugador;
import model.Model;
import utilscontroller.Utils;
import view.View;

/**
 *
 * @author profe
 */
public class Controller {

    private static Model model;
    private static View view;
    private TableColumn tc;
    private TableColumn tc2;
    private int filaSel = -1;
    private int filaSel2 = -1;

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
        //Combo Puntuacio
        view.getPuntuacio().addItem("Puntuacio de menor a major");
        view.getPuntuacio().addItem("Ordenar alfabeticament equips");

        tc = Utils.<Equip>loadTable(model.getDades(), view.getTaulaEquips(), Equip.class, true, true);
        tc2 = Utils.<Jugador>loadTable(model.getDadesJugador(), view.getTaulaJugadors(), Jugador.class, true, true);

        view.getAfegirEquip().addActionListener(
                e -> {
                    Model.afegirEquip(view.getNomEquip().getText(), Integer.parseInt(view.getGolsEnContra().getText()), Integer.parseInt(view.getGolsAfavor().getText()), Integer.parseInt(view.getPartitsGuanyats().getText()), Integer.parseInt(view.getPartitsPerduts().getText()), Integer.parseInt(view.getPartitsEmpats().getText()), Integer.parseInt(view.getPuntsEquip().getText()), Integer.parseInt(view.getJornada().getText()));
                    tc = Utils.<Equip>loadTable(model.getDades(), view.getTaulaEquips(), Equip.class, true, true);

                }
        );

        view.getAfegirJugador().addActionListener(
            e-> {
                Model.afegirJugador(view.getNomJugador().getText(), view.getCognomsJugador().getText(), view.getEquipJugador().getText(), view.getPosicioJugador().getText(), Integer.parseInt(view.getGolsJugador().getText()), Integer.parseInt(view.getPartitsJugador().getText()));
                tc2 = Utils.<Jugador>loadTable(model.getDadesJugador(), view.getTaulaJugadors(), Jugador.class, true, true);
            }
        );

        view.getTaulaEquips().addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filaSel = view.getTaulaEquips().getSelectedRow();

            }
        }
        );

        view.getTaulaJugadors().addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filaSel2 = view.getTaulaJugadors().getSelectedRow();

            }
        }
        );

        view.getMostrar().addActionListener(
                e -> {
                    if (filaSel != -1) {
                        TableColumnModel tcm = view.getTaulaEquips().getColumnModel();
                        tcm.addColumn(tc);
                        Equip obj = (Equip) view.getTaulaEquips().getValueAt(filaSel, tcm.getColumnCount() - 1);
                        tcm.removeColumn(tc);
                        JOptionPane.showMessageDialog(view, obj);
                    } else {
                        JOptionPane.showMessageDialog(view, "Has de seleccionar una fila de la taula!!");
                    }

                }
        );

        view.getMostrarJugador().addActionListener(
                e -> {
                    if (filaSel2 != -1) {
                        TableColumnModel tcm = view.getTaulaJugadors().getColumnModel();
                        tcm.addColumn(tc2);
                        Jugador obj = (Jugador) view.getTaulaJugadors().getValueAt(filaSel2, tcm.getColumnCount() - 1);
                        tcm.removeColumn(tc2);
                        JOptionPane.showMessageDialog(view, obj);
                    } else {
                        JOptionPane.showMessageDialog(view, "Has de seleccionar una fila de la taula!!");
                    }

                }
        );

        view.getEliminarEquip().addActionListener(
                e -> {
                    if (filaSel != -1) {
                        TableColumnModel tcm = view.getTaulaEquips().getColumnModel();
                        tcm.addColumn(tc);
                        Equip obj = (Equip) view.getTaulaEquips().getValueAt(filaSel, tcm.getColumnCount() - 1);
                        tcm.removeColumn(tc);
                        model.borrarEquip(obj);
                        tc = Utils.<Equip>loadTable(model.getDades(), view.getTaulaEquips(), Equip.class, true, true);
                        //Trobo que millor una vegada a seleccionat una fila i li ha donat a borrar
                        //si vol tornar a borrar una fila que tingui de clicar sobre la fila perque sinos
                        //tindrem problemes aixi que per a fer aixo simplement li donem el valro -1 a filaSel
                        //i aixo significara que no hi ha cap fila selecionada i per tant ens fara tornar a seleccionar una fila.
                        filaSel = -1;

                    } else {
                        JOptionPane.showMessageDialog(view, "Has de seleccionar una fila de la taula!!");
                    }

                }
        );
        view.getEliminarJugador().addActionListener(
                e -> {
                    if (filaSel2 != -1) {
                        TableColumnModel tcm = view.getTaulaJugadors().getColumnModel();
                        tcm.addColumn(tc2);
                        Jugador obj = (Jugador) view.getTaulaJugadors().getValueAt(filaSel2, tcm.getColumnCount() - 1);
                        tcm.removeColumn(tc2);
                        model.borrarJugador(obj);
                        tc2 = Utils.<Jugador>loadTable(model.getDadesJugador(), view.getTaulaJugadors(), Jugador.class, true, true);
                        //Trobo que millor una vegada a seleccionat una fila i li ha donat a borrar
                        //si vol tornar a borrar una fila que tingui de clicar sobre la fila perque sinos
                        //tindrem problemes aixi que per a fer aixo simplement li donem el valro -1 a filaSel
                        //i aixo significara que no hi ha cap fila selecionada i per tant ens fara tornar a seleccionar una fila.
                        filaSel2 = -1;

                    } else {
                        JOptionPane.showMessageDialog(view, "Has de seleccionar una fila de la taula!!");
                    }

                }
        );

        view.getBotoEditar().addActionListener(
                e -> {
                    if (filaSel != -1) {
                        TableColumnModel tcm = view.getTaulaEquips().getColumnModel();
                        tcm.addColumn(tc);
                        Equip obj = new Equip(view.getNomEquip().getText(), Integer.parseInt(view.getGolsEnContra().getText()), Integer.parseInt(view.getGolsAfavor().getText()), Integer.parseInt(view.getPartitsGuanyats().getText()), Integer.parseInt(view.getPartitsPerduts().getText()), Integer.parseInt(view.getPartitsEmpats().getText()), Integer.parseInt(view.getPuntsEquip().getText()), Integer.parseInt(view.getJornada().getText()));
                        tcm.removeColumn(tc);
                        model.modificarEquip(obj);
                        tc = Utils.<Equip>loadTable(model.getDades(), view.getTaulaEquips(), Equip.class, true, true);
//                       model.insertRow(filaSel, obj);
//                         tcm.addColumn(tc);
//                        Equip obj=(Equip)view.getTaulaEquips().getValueAt(filaSel, tcm.getColumnCount()-1);
//                        tcm.removeColumn(tc);                      
//                        model.borrarEquip(obj);
//                        tc=Utils.<Equip>loadTable(model.getDades(), view.getTaulaEquips(), Equip.class, true, true);
                        //Trobo que millor una vegada a seleccionat una fila i li ha donat a borrar
                        //si vol tornar a borrar una fila que tingui de clicar sobre la fila perque sinos
                        //tindrem problemes aixi que per a fer aixo simplement li donem el valro -1 a filaSel
                        //i aixo significara que no hi ha cap fila selecionada i per tant ens fara tornar a seleccionar una fila.
                        filaSel = -1;

                        //Anem a mostrar el contingut del vector dins de la taula
                        //    Model.modificarEquip(filaSel,view.getNomEquip().getText(), Integer.parseInt(view.getGolsEnContra().getText()), Integer.parseInt(view.getGolsAfavor().getText()), Integer.parseInt(view.getPartitsGuanyats().getText()), Integer.parseInt(view.getPartitsPerduts().getText()), Integer.parseInt(view.getPartitsEmpats().getText()), Integer.parseInt(view.getPuntsEquip().getText()), Integer.parseInt(view.getJornada().getText()));
                        // model.removeRow(filaSel);
                        //Equip.modificar(filaSel);
                        // model.insertRow(filaSel, obj);
                    } else {
                        JOptionPane.showMessageDialog(view, "Has de seleccionar una fila de la taula!!");
                    }

                }
        );
                view.getPuntuacio().addItemListener(
        
                e->{
                    if(view.getPuntuacio().getSelectedIndex()==0){
                        
                        tc=Utils.<Equip>loadTable(model.getDades(), view.getTaulaEquips(), Equip.class, true, true);
                        
                    }
                    if(view.getPuntuacio().getSelectedIndex()==1){
                       model.getDades2().addAll(model.getDades());
                       tc=Utils.<Equip>loadTable(model.getDades2(), view.getTaulaEquips(), Equip.class, true, true);
                        
                    }
                    
                }
        );
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
