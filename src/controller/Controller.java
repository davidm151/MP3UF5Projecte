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
    private int filtroEquip = -1;
    private int filtroJugador = -1;

    public Controller(Model m, View v) {
        model = m;
        view = v;
        controlador();
    }

    public void carregarTaulaEquipActual() {
        if (filtroEquip == 0) {
            tc = Utils.<Equip>loadTable(model.getDades(), view.getTaulaEquips(), Equip.class, true, true);
        } else {
            model.getDades2().addAll(model.getDades());
            tc = Utils.<Equip>loadTable(model.getDades2(), view.getTaulaEquips(), Equip.class, true, true);
        }
    }

    public void carregarTaulaJugadorActual() {
        if (filtroJugador == 0) {
            tc2 = Utils.<Jugador>loadTable(model.getDadesJugador(), view.getTaulaJugadors(), Jugador.class, true, true);
        } else {
            model.getDadesJugador2().addAll(model.getDadesJugador());
            tc2 = Utils.<Jugador>loadTable(model.getDadesJugador2(), view.getTaulaJugadors(), Jugador.class, true, true);
        }
    }

    private void controlador() {

        //Codi que inicilitza la vista
        view.setVisible(true);

        //Codi que assigna els listeners als components de la vista
        //Combo Puntuacio
        view.getPuntuacio().addItem("Puntuacio de menor a major");
        view.getPuntuacio().addItem("Ordenar alfabeticament equips");
        view.getFiltroJugadors().addItem("Gols de menor a major");
        view.getFiltroJugadors().addItem("Ordenar alfabeticament Jugadors");

        carregarTaulaJugadorActual();
        carregarTaulaEquipActual();

        view.getAfegirEquip().addActionListener(
                e -> {
                    Model.afegirEquip(view.getNomEquip().getText(), Integer.parseInt(view.getGolsEnContra().getText()), Integer.parseInt(view.getGolsAfavor().getText()), Integer.parseInt(view.getPartitsGuanyats().getText()), Integer.parseInt(view.getPartitsPerduts().getText()), Integer.parseInt(view.getPartitsEmpats().getText()), Integer.parseInt(view.getPuntsEquip().getText()), Integer.parseInt(view.getJornada().getText()));

                    carregarTaulaEquipActual();
                }
        );

        view.getAfegirJugador().addActionListener(
                e -> {
                    Model.afegirJugador(view.getNomJugador().getText(), view.getEquipJugador().getText(), view.getPosicioJugador().getText(), Integer.parseInt(view.getGolsJugador().getText()), Integer.parseInt(view.getPartitsJugador().getText()));
                    carregarTaulaJugadorActual();
                }
        );

        view.getTaulaEquips().addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filaSel = view.getTaulaEquips().getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) view.getTaulaEquips().getModel();
                String nomEquip = model.getValueAt(view.getTaulaEquips().getSelectedRow(), 0).toString();
                String golsEncontra = model.getValueAt(view.getTaulaEquips().getSelectedRow(), 1).toString();
                String golsAfavor = model.getValueAt(view.getTaulaEquips().getSelectedRow(), 2).toString();
                String partitsGuanyats = model.getValueAt(view.getTaulaEquips().getSelectedRow(), 3).toString();
                String partitsPerduts = model.getValueAt(view.getTaulaEquips().getSelectedRow(), 4).toString();
                String partitsEmpatats = model.getValueAt(view.getTaulaEquips().getSelectedRow(), 5).toString();
                String puntsEquip = model.getValueAt(view.getTaulaEquips().getSelectedRow(), 6).toString();
                String jornada = model.getValueAt(view.getTaulaEquips().getSelectedRow(), 7).toString();
                view.getJornada().setText(jornada);
                view.getPuntsEquip().setText(puntsEquip);
                view.getPartitsEmpats().setText(partitsEmpatats);
                view.getPartitsPerduts().setText(partitsPerduts);
                view.getPartitsGuanyats().setText(partitsGuanyats);
                view.getGolsAfavor().setText(golsAfavor);
                view.getGolsEnContra().setText(golsEncontra);
                view.getNomEquip().setText(nomEquip);
            }
        }
        );

        view.getTaulaJugadors().addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filaSel2 = view.getTaulaJugadors().getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) view.getTaulaJugadors().getModel();
                String nomcognoms = model.getValueAt(view.getTaulaJugadors().getSelectedRow(), 0).toString();
                String equip = model.getValueAt(view.getTaulaJugadors().getSelectedRow(), 1).toString();
                String posicioJugador = model.getValueAt(view.getTaulaJugadors().getSelectedRow(), 2).toString();
                String golsJugador = model.getValueAt(view.getTaulaJugadors().getSelectedRow(), 3).toString();
                String partitsJugador = model.getValueAt(view.getTaulaJugadors().getSelectedRow(), 4).toString();
                view.getPartitsJugador().setText(partitsJugador);
                view.getGolsJugador().setText(golsJugador);
                view.getPosicioJugador().setText(posicioJugador);
                view.getEquipJugador().setText(equip);
                view.getNomJugador().setText(nomcognoms);

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
                        carregarTaulaEquipActual();
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

                        carregarTaulaJugadorActual();
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
                        Equip obj = (Equip) view.getTaulaEquips().getValueAt(filaSel, tcm.getColumnCount() - 1);
                        obj.set1_nomEquip(view.getNomEquip().getText());
                        obj.set2_golsEnContra(Integer.parseInt(view.getGolsEnContra().getText()));
                        obj.set3_golsAfavor(Integer.parseInt(view.getGolsAfavor().getText()));
                        obj.set4_partitsGuanyats(Integer.parseInt(view.getPartitsGuanyats().getText()));
                        obj.set5_partitsPerduts(Integer.parseInt(view.getPartitsPerduts().getText()));
                        obj.set6_partitsEmpatats(Integer.parseInt(view.getPartitsEmpats().getText()));
                        obj.set7_puntsEquip(Integer.parseInt(view.getPuntsEquip().getText()));
                        obj.set8_jornada(Integer.parseInt(view.getJornada().getText()));
                        tcm.removeColumn(tc);
                        carregarTaulaEquipActual();
                        //Aqui li donem el valor de -1 ja que sinos al editar ens deseleccionara la fila de la taula
                        //pero si li tornem a donar a editar ens editara igual sense tenir la fila seleccionada
                        //aixi que per evitar aixo li fiquem el valor -1.
                        filaSel = -1;
                    } else {
                        JOptionPane.showMessageDialog(view, "Has de seleccionar una fila de la taula!!");
                    }
                }
        );

        view.getEditarJugador().addActionListener(
                e -> {
                    if (filaSel2 != -1) {
                        TableColumnModel tcm = view.getTaulaJugadors().getColumnModel();
                        tcm.addColumn(tc2);
                        Jugador obj = (Jugador) view.getTaulaJugadors().getValueAt(filaSel2, tcm.getColumnCount() - 1);
                        obj.set1_nomcognomsJugador(view.getNomJugador().getText());
                        obj.set2_equipJugador(view.getEquipJugador().getText());
                        obj.set3_posicioJugador(view.getPosicioJugador().getText());
                        obj.set4_golsJugador(Integer.parseInt(view.getGolsJugador().getText()));
                        obj.set5_partitsJugador(Integer.parseInt(view.getPartitsJugador().getText()));
                        tcm.removeColumn(tc2);
                        carregarTaulaJugadorActual();
                        //Aqui li donem el valor de -1 ja que sinos al editar ens deseleccionara la fila de la taula
                        //pero si li tornem a donar a editar ens editara igual sense tenir la fila seleccionada
                        //aixi que per evitar aixo li fiquem el valor -1.
                        filaSel2 = -1;
                    } else {
                        JOptionPane.showMessageDialog(view, "Has de seleccionar una fila de la taula!!");
                    }
                }
        );
        view.getPuntuacio().addItemListener(
                e -> {
                    if (view.getPuntuacio().getSelectedIndex() == 0) {
                        filtroEquip = 0;
                        carregarTaulaEquipActual();
                    }
                    if (view.getPuntuacio().getSelectedIndex() == 1) {
                        filtroEquip = 1;
                        carregarTaulaEquipActual();
                    }

                }
        );

        view.getFiltroJugadors().addItemListener(
                e -> {
                    if (view.getFiltroJugadors().getSelectedIndex() == 0) {

                        filtroJugador = 0;
                        carregarTaulaJugadorActual();

                    }
                    if (view.getFiltroJugadors().getSelectedIndex() == 1) {
                        filtroJugador = 1;
                        carregarTaulaJugadorActual();

                    }

                }
        );
    }
}
