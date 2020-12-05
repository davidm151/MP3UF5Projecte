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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;
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
    private TableColumn tc3;
    private TableColumn tc4;
    private int filaSel = -1;
    private int filaSel2 = -1;
    private int filtroEquip = 0;
    private int filtroJugador = 0;
    private String equip = "";

    public Controller(Model m, View v) {
        model = m;
        view = v;
        controlador();
    }

    public void carregarTaulaEquip() {
        if (filtroEquip == 0) {
            tc = Utils.<Equip>loadTable(model.getDades(), view.getTaulaEquips(), Equip.class, true, true);
            Utils.<Equip>loadCombo(model.getDades(), view.getjComboBox1());
        } else if (filtroEquip == 1) {
            model.getDades2().addAll(model.getDades());
            tc = Utils.<Equip>loadTable(model.getDades2(), view.getTaulaEquips(), Equip.class, true, true);
            Utils.<Equip>loadCombo(model.getDades(), view.getjComboBox1());
        }
    }

    public void carregarTaulaJugador() {
        if (filtroJugador == 0) {
            tc2 = Utils.<Jugador>loadTable(model.getDadesJugador(), view.getTaulaJugadors(), Jugador.class, true, true);

        } else if (filtroJugador == 1) {
            model.getDadesJugador2().addAll(model.getDadesJugador());
            tc2 = Utils.<Jugador>loadTable(model.getDadesJugador2(), view.getTaulaJugadors(), Jugador.class, true, true);
        }
    }

    private void controlador() {

        //Codi que inicilitza la vista
        // model.dasd();
        view.setVisible(true);

        //Codi que assigna els listeners als components de la vista
        //Combo Puntuacio
        view.getPuntuacio().addItem("Puntuacio de menor a major");
        view.getPuntuacio().addItem("Ordenar alfabeticament equips");
        view.getFiltroJugadors().addItem("Gols de menor a major");
        view.getFiltroJugadors().addItem("Ordenar alfabeticament Jugadors");

        carregarTaulaJugador();
        carregarTaulaEquip();

        view.getAfegirEquip().addActionListener(
                e -> {
                    model.obtenirEquip(view.getNomEquip().getText(), Integer.parseInt(view.getGolsEnContra().getText()), Integer.parseInt(view.getGolsAfavor().getText()), Integer.parseInt(view.getPartitsGuanyats().getText()), Integer.parseInt(view.getPartitsPerduts().getText()), Integer.parseInt(view.getPartitsEmpats().getText()), Integer.parseInt(view.getPuntsEquip().getText()), Integer.parseInt(view.getJornada().getText()));
                    //model.<Equip>insertar(obj, model.getDades());
                    carregarTaulaJugador();
                    carregarTaulaEquip();
                }
        );

        view.getAfegirJugador().addActionListener(
                e -> {
                    Equip obj1 = (Equip) view.getjComboBox1().getSelectedItem();
                    model.obtenirJugador(view.getNomJugador().getText(), obj1, view.getPosicioJugador().getText(), Integer.parseInt(view.getGolsJugador().getText()), Integer.parseInt(view.getPartitsJugador().getText()));
                    //Model.<Jugador>insertar(obj, Model.getDadesJugador());
                    carregarTaulaJugador();
                    carregarTaulaEquip();
                }
        );

        view.getTaulaEquips().addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filaSel = view.getTaulaEquips().getSelectedRow();
                if (filaSel != -1) {
                    DefaultTableModel model1 = (DefaultTableModel) view.getTaulaEquips().getModel();
                    String nom = model1.getValueAt(filaSel, 0).toString();
                    String golsEncontra = model1.getValueAt(filaSel, 1).toString();
                    String golsAfavor = model1.getValueAt(filaSel, 2).toString();
                    String partitsGuanyats = model1.getValueAt(filaSel, 3).toString();
                    String partitsPerduts = model1.getValueAt(filaSel, 4).toString();
                    String partitsEmpatats = model1.getValueAt(filaSel, 5).toString();
                    String puntsEquip = model1.getValueAt(filaSel, 6).toString();
                    String jornada = model1.getValueAt(filaSel, 7).toString();
                    view.getNomEquip().setText(nom);
                    view.getJornada().setText(jornada);
                    view.getPuntsEquip().setText(puntsEquip);
                    view.getPartitsEmpats().setText(partitsEmpatats);
                    view.getPartitsPerduts().setText(partitsPerduts);
                    view.getPartitsGuanyats().setText(partitsGuanyats);
                    view.getGolsAfavor().setText(golsAfavor);
                    view.getGolsEnContra().setText(golsEncontra);
                } else {
                    carregarTaulaJugador();
                }
                if (view.getjCheckBox1().isSelected() == true && filaSel != -1) {
                    TableColumnModel tcm = view.getTaulaEquips().getColumnModel();
                    tcm.addColumn(tc);
                    Equip obj = (Equip) view.getTaulaEquips().getValueAt(filaSel, tcm.getColumnCount() - 1);
                    view.getNomEquip().setText(obj.toString());
                    tcm.removeColumn(tc);
                    carregarTaulaEquip();
                    tc2 = Utils.<Jugador>loadTable(obj.get9_jug(), view.getTaulaJugadors(), Jugador.class, true, true);
                }
            }
        });

        view.getjCheckBox1().addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filaSel = view.getTaulaEquips().getSelectedRow();
                if (filaSel != -1) {
                    TableColumnModel tcm = view.getTaulaEquips().getColumnModel();
                    tcm.addColumn(tc);
                    Equip obj = (Equip) view.getTaulaEquips().getValueAt(filaSel, tcm.getColumnCount() - 1);
                    tcm.removeColumn(tc);
                    view.getNomEquip().setText(obj.toString());
                    if (view.getjCheckBox1().isSelected() == true) {
                        view.getNomEquip().setText(obj.toString());
                        carregarTaulaEquip();
                        tc3 = Utils.<Jugador>loadTable(obj.get9_jug(), view.getTaulaJugadors(), Jugador.class, true, true);
                    } else {
                        carregarTaulaEquip();
                        carregarTaulaJugador();
                    }
                } else {
                    carregarTaulaJugador();
                }
            }
        }
        );

        view.getjCheckBox2().addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filaSel2 = view.getTaulaJugadors().getSelectedRow();
                if (filaSel2 != -1) {
                    TableColumnModel tcm2 = view.getTaulaJugadors().getColumnModel();
                    tcm2.addColumn(tc2);
                    Jugador obj2 = (Jugador) view.getTaulaJugadors().getValueAt(filaSel2, tcm2.getColumnCount() - 1);
                    tcm2.removeColumn(tc2);
                    Equip eq1 = obj2.get2_equip();
                    if (view.getjCheckBox2().isSelected() == true) {
                        Collection<Equip> prova = new TreeSet<>();
                        prova.add(eq1);
                        tc = Utils.<Equip>loadTable(prova, view.getTaulaEquips(), Equip.class, true, true);
                    } else {
                        carregarTaulaEquip();
                        carregarTaulaJugador();
                    }
                } else {
                    carregarTaulaJugador();
                }
            }
        }
        );

        view.getTaulaJugadors()
                .addMouseListener(
                        new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e
                    ) {

                        filaSel2 = view.getTaulaJugadors().getSelectedRow();
                        if (filaSel2 != -1) {
                            DefaultTableModel model1 = (DefaultTableModel) view.getTaulaJugadors().getModel();
                            String nomcognoms = model1.getValueAt(view.getTaulaJugadors().getSelectedRow(), 0).toString();
                            String equip = model1.getValueAt(view.getTaulaJugadors().getSelectedRow(), 1).toString();
                            String posicioJugador = model1.getValueAt(view.getTaulaJugadors().getSelectedRow(), 2).toString();
                            String golsJugador = model1.getValueAt(view.getTaulaJugadors().getSelectedRow(), 3).toString();
                            String partitsJugador = model1.getValueAt(view.getTaulaJugadors().getSelectedRow(), 4).toString();
                            view.getPartitsJugador().setText(partitsJugador);
                            view.getGolsJugador().setText(golsJugador);
                            view.getPosicioJugador().setText(posicioJugador);
                            view.getNomJugador().setText(nomcognoms);
                            if (view.getjCheckBox2().isSelected() == true && filaSel2 != -1) {
                                TableColumnModel tcm2 = view.getTaulaJugadors().getColumnModel();
                                tcm2.addColumn(tc2);
                                Jugador obj2 = (Jugador) view.getTaulaJugadors().getValueAt(filaSel2, tcm2.getColumnCount() - 1);
                                tcm2.removeColumn(tc2);
                                Equip eq1 = obj2.get2_equip();
                                Collection<Equip> prova = new TreeSet<>();
                                prova.add(eq1);
                                tc = Utils.<Equip>loadTable(prova, view.getTaulaEquips(), Equip.class, true, true);
                            }
                        } else {
                            return;
                        }
                    }

                }
                );

        view.getEliminarEquip()
                .addActionListener(
                        e -> {
                            if (filaSel != -1) {
                                TableColumnModel tcm = view.getTaulaEquips().getColumnModel();
                                tcm.addColumn(tc);
                                Equip obj = (Equip) view.getTaulaEquips().getValueAt(filaSel, tcm.getColumnCount() - 1);
                                tcm.removeColumn(tc);
                                Model.<Equip>eliminar(obj, Model.getDades());
                                Model.<Equip>eliminar(obj, Model.getDades2());
                                carregarTaulaEquip();
                                carregarTaulaJugador();
                                filaSel = -1;

                            } else {
                                JOptionPane.showMessageDialog(view, "Has de seleccionar una fila de la taula!!");
                            }

                        }
                );
        view.getEliminarJugador()
                .addActionListener(
                        e -> {
                            if (filaSel2 != -1) {
                                TableColumnModel tcm = view.getTaulaJugadors().getColumnModel();
                                tcm.addColumn(tc2);
                                Jugador obj = (Jugador) view.getTaulaJugadors().getValueAt(filaSel2, tcm.getColumnCount() - 1);
                                tcm.removeColumn(tc2);
                                Model.<Jugador>eliminar(obj, Model.getDadesJugador());
                                Model.<Jugador>eliminar(obj, Model.getDadesJugador2());
                                carregarTaulaJugador();
                                carregarTaulaEquip();
                                filaSel2 = -1;

                            } else {
                                JOptionPane.showMessageDialog(view, "Has de seleccionar una fila de la taula!!");
                            }

                        }
                );

        view.getBotoEditar()
                .addActionListener(
                        e -> {
                            if (filaSel != -1) {

                                TableColumnModel tcm = view.getTaulaEquips().getColumnModel();
                                tcm.addColumn(tc);
                                Equip obj = (Equip) view.getTaulaEquips().getValueAt(filaSel, tcm.getColumnCount() - 1);
                                obj.set1_nom(view.getNomEquip().getText());
                                obj.set2_golsEnContra(Integer.parseInt(view.getGolsEnContra().getText()));
                                obj.set3_golsAfavor(Integer.parseInt(view.getGolsAfavor().getText()));
                                obj.set4_partitsGuanyats(Integer.parseInt(view.getPartitsGuanyats().getText()));
                                obj.set5_partitsPerduts(Integer.parseInt(view.getPartitsPerduts().getText()));
                                obj.set6_partitsEmpatats(Integer.parseInt(view.getPartitsEmpats().getText()));
                                obj.set7_punts(Integer.parseInt(view.getPuntsEquip().getText()));
                                obj.set8_jornada(Integer.parseInt(view.getJornada().getText()));
                                tcm.removeColumn(tc);
                                carregarTaulaEquip();
                                carregarTaulaJugador();
                               filaSel = -1;
                            } else {
                                JOptionPane.showMessageDialog(view, "Has de seleccionar una fila de la taula!!");
                            }
                        }
                );

        view.getEditarJugador()
                .addActionListener(
                        e -> {
                            if (filaSel2 != -1) {
                                TableColumnModel tcm2 = view.getTaulaJugadors().getColumnModel();
                                tcm2.addColumn(tc2);
                                Jugador obj = (Jugador) view.getTaulaJugadors().getValueAt(filaSel2, tcm2.getColumnCount() - 1);
                                TableColumnModel tcm20 = view.getTaulaEquips().getColumnModel();
                                tcm20.addColumn(tc);
                                tcm20.removeColumn(tc);
                                obj.set1_nomcognoms(view.getNomJugador().getText());
                                Equip obj1 = (Equip) view.getjComboBox1().getSelectedItem();
                                obj.set2_equip(obj1);
                                obj.set3_posicio(view.getPosicioJugador().getText());
                                obj.set4_gols(Integer.parseInt(view.getGolsJugador().getText()));
                                obj.set5_partits(Integer.parseInt(view.getPartitsJugador().getText()));
                                tcm2.removeColumn(tc2);
                                carregarTaulaJugador();
                                carregarTaulaEquip();
                                //Aqui li donem el valor de -1 ja que sinos al editar ens deseleccionara la fila de la taula
                                //pero si li tornem a donar a editar ens editara igual sense tenir la fila seleccionada
                                //aixi que per evitar aixo li fiquem el valor -1.
                                filaSel2 = -1;
                            } else {
                                JOptionPane.showMessageDialog(view, "Has de seleccionar una fila de la taula !!");
                            }
                        }
                );
        view.getPuntuacio()
                .addItemListener(
                        e -> {
                            if (view.getPuntuacio().getSelectedIndex() == 0) {
                                filtroEquip = 0;
                                carregarTaulaEquip();
                            }
                            if (view.getPuntuacio().getSelectedIndex() == 1) {
                                filtroEquip = 1;
                                carregarTaulaEquip();
                            }

                        }
                );

        view.getFiltroJugadors()
                .addItemListener(
                        e -> {
                            if (view.getFiltroJugadors().getSelectedIndex() == 0) {
                                filtroJugador = 0;
                                carregarTaulaJugador();
                            }
                            if (view.getFiltroJugadors().getSelectedIndex() == 1) {
                                filtroJugador = 1;
                                carregarTaulaJugador();

                            }

                        }
                );
    }
}
