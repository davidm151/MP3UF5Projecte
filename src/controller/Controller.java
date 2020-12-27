/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
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
    private int filaSel = -1;
    private int filaSel2 = -1;
    private int filtroEquip = 0;
    private int filtroJugador = 0;
    
    public Controller(Model m, View v) throws IOException, FileNotFoundException, ClassNotFoundException {
        model = m;
        view = v;
        controlador();
    }

    public void carregarTaulaEquip() {
        if (filtroEquip == 0) {
            tc = Utils.<Equip>loadTable(model.getDades(), view.getTaulaEquips(), Equip.class, true, true);
            view.getTaulaEquips().removeColumn(view.getTaulaEquips().getColumnModel().getColumn(8));
            Utils.<Equip>loadCombo(model.getDades(), view.getjComboBox1());
        } else if (filtroEquip == 1) {
            model.getDades2().addAll(model.getDades());
            tc = Utils.<Equip>loadTable(model.getDades2(), view.getTaulaEquips(), Equip.class, true, true);
            view.getTaulaEquips().removeColumn(view.getTaulaEquips().getColumnModel().getColumn(8));
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

    private void controlador() throws IOException, FileNotFoundException, ClassNotFoundException {

       model.comprovarContrasenya();
       view.setVisible(true);
       model.nomFitxerEquip_Jugador();
        //Combo Puntuacio
        view.getPuntuacio().addItem("Puntuacio de menor a major");
        view.getPuntuacio().addItem("Ordenar alfabeticament equips");
        view.getFiltroJugadors().addItem("Gols de menor a major");
        view.getFiltroJugadors().addItem("Ordenar alfabeticament Jugadors");

       // escriureFitxer();
        model.llegirFitxer();
        model.escriureFitxerJugador();
        model.llegirFitxerJugadors();
        carregarTaulaJugador();
        carregarTaulaEquip();
        view.getAfegirEquip().addActionListener(
                e -> {
                    Pattern pattern = null;
                    pattern = Pattern.compile("^[a-zA-Z]*$");
                    StringBuilder a = new StringBuilder();

                    while (true) {
                        String text = view.getNomEquip().getText().replace(" ", "");
                        boolean found = false;
                        if (text.isEmpty()) {
                            found = false;
                            JOptionPane.showMessageDialog(view, "No has introduit res, esta buit!!!");
                            break;
                        }
                        Matcher matcher = pattern.matcher(text);

                        if (matcher.find()) {
                            try {
                                if (Integer.parseInt(view.getGolsEnContra().getText()) < 0 || Integer.parseInt(view.getGolsAfavor().getText()) < 0 || Integer.parseInt(view.getPartitsGuanyats().getText()) < 0 || Integer.parseInt(view.getPartitsPerduts().getText()) < 0 || Integer.parseInt(view.getPartitsEmpats().getText()) < 0 || Integer.parseInt(view.getJornada().getText()) < 0) {
                                    JOptionPane.showMessageDialog(view, "Has introduit un numero negatiu!!!");
                                    found = true;
                                    break;
                                }
                                model.obtenirEquip(a.append(view.getNomEquip().getText()), Integer.parseInt(view.getGolsEnContra().getText()), Integer.parseInt(view.getGolsAfavor().getText()), Integer.parseInt(view.getPartitsGuanyats().getText()), Integer.parseInt(view.getPartitsPerduts().getText()), Integer.parseInt(view.getPartitsEmpats().getText()), Integer.parseInt(view.getPuntsEquip().getText()), Integer.parseInt(view.getJornada().getText()));

                            } catch (NumberFormatException exception) {
                                JOptionPane.showMessageDialog(view, "On tenies d'introduir un numero has introduit lletres o caracters o no has introduit res");
                                found = true;
                                break;
                            }
                            found = true;
                            carregarTaulaJugador();
                            carregarTaulaEquip();
                            break;
                        }
                        if (!found) {
                            JOptionPane.showMessageDialog(view, "No has introduit un nom de equip correcte has introduit algo mes apart de lletres");
                            break;
                        }
                        break;
                    }
                }
        );

        view.getAfegirJugador().addActionListener(
                e -> {
                    Equip obj1 = (Equip) view.getjComboBox1().getSelectedItem();
                    String[] a = new String[1];
                    a[0] = view.getPosicioJugador().getText();

                    String[] a1 = {"Defensa"};
                    String[] b = {"Delanter"};
                    String[] c = {"Porter"};
                    String[] d = {"Mitg camp"};
                    String[] a2 = {"defensa"};
                    String[] b2 = {"delanter"};
                    String[] c2 = {"porter"};
                    String[] d2 = {"mitg camp"};
                    if (Arrays.compare(a, a1) == 0 || Arrays.compare(a, b) == 0 || Arrays.compare(a, c) == 0 || Arrays.compare(a, d) == 0 || Arrays.compare(a, a2) == 0 || Arrays.compare(a, b2) == 0 || Arrays.compare(a, c2) == 0 || Arrays.compare(a, d2) == 0) {
                        Pattern pattern = null;
                        pattern = Pattern.compile("^[a-zA-Z]*$");
                        while (true) {
                            String text = view.getNomJugador().getText().replace(" ", "");
                            if (text.isEmpty()) {
                                JOptionPane.showMessageDialog(view, "No has introduit res, esta buit!!!");
                                break;
                            }
                            Matcher matcher = pattern.matcher(text);
                            boolean found = false;
                            if (matcher.find()) {
                                try {
                                    if (Integer.parseInt(view.getGolsJugador().getText()) < 0 || Integer.parseInt(view.getPartitsJugador().getText()) < 0) {
                                        JOptionPane.showMessageDialog(view, "Has introduit un numero negatiu!!!");
                                        found = true;
                                        break;
                                    }
                                    model.obtenirJugador(view.getNomJugador().getText(), obj1, a, Integer.parseInt(view.getGolsJugador().getText()), Integer.parseInt(view.getPartitsJugador().getText()));
                                } catch (NumberFormatException exception) {
                                    JOptionPane.showMessageDialog(view, "On tenies d'introduir un numero has introduit lletres o caracters o no has introduit res");
                                    found = true;
                                    break;
                                } catch (NullPointerException exception) {
                                    JOptionPane.showMessageDialog(view, "El jugador te de tenir un equip.");
                                    found = true;
                                    break;
                                }

                                found = true;
                                carregarTaulaJugador();
                                carregarTaulaEquip();
                                break;
                            }
                            if (!found) {
                                JOptionPane.showMessageDialog(view, "No has introduit un nom de jugador correcte has introduit algo mes apart de lletres");
                                break;
                            }
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(view, "No has introduit una posicio correcta te de ser Defensa o Delanter o Porter o mitg camp");

                    }

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
                            //  String equip = model1.getValueAt(view.getTaulaJugadors().getSelectedRow(), 1).toString();
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
                                TableColumnModel tcm2 = view.getTaulaJugadors().getColumnModel();
                                tcm2.addColumn(tc2);
                                Model.borrarEquip(obj);
                                tcm2.removeColumn(tc2);
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
                                Jugador obj;
                                obj = (Jugador) view.getTaulaJugadors().getValueAt(filaSel2, tcm.getColumnCount() - 1);
                                tcm.removeColumn(tc2);
                                //   Equip.EliminarJugadorDelEquip(obj);

                                //   Model.<Jugador>eliminar(obj, Model.getDadesJugador());
                                //  Model.<Jugador>eliminar(obj, Model.getDadesJugador2());
                                Model.borrarJugador(obj);

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
                                Pattern pattern = null;
                                pattern = Pattern.compile("^[a-zA-Z]*$");
                                StringBuilder a = new StringBuilder();
                                tcm.removeColumn(tc);
                                while (true) {
                                    String text = view.getNomEquip().getText().replace(" ", "");
                                    if (text.isEmpty()) {
                                        JOptionPane.showMessageDialog(view, "No has introduit res, esta buit!!!");
                                        break;
                                    }
                                    Matcher matcher = pattern.matcher(text);
                                    boolean found = false;
                                    if (matcher.find()) {
                                        try {
                                            if (Integer.parseInt(view.getGolsEnContra().getText()) < 0 || Integer.parseInt(view.getGolsAfavor().getText()) < 0 || Integer.parseInt(view.getPartitsGuanyats().getText()) < 0 || Integer.parseInt(view.getPartitsPerduts().getText()) < 0 || Integer.parseInt(view.getPartitsEmpats().getText()) < 0 || Integer.parseInt(view.getJornada().getText()) < 0) {
                                                JOptionPane.showMessageDialog(view, "Has introduit un numero negatiu!!!");
                                                found = true;
                                                break;
                                            }
                                            obj.set1_nom(a.append(view.getNomEquip().getText()));
                                            obj.set2_golsEnContra(Integer.parseInt(view.getGolsEnContra().getText()));
                                            obj.set3_golsAfavor(Integer.parseInt(view.getGolsAfavor().getText()));
                                            obj.set4_partitsGuanyats(Integer.parseInt(view.getPartitsGuanyats().getText()));
                                            obj.set5_partitsPerduts(Integer.parseInt(view.getPartitsPerduts().getText()));
                                            obj.set6_partitsEmpatats(Integer.parseInt(view.getPartitsEmpats().getText()));
                                            obj.set7_punts(Integer.parseInt(view.getPuntsEquip().getText()));
                                            obj.set8_jornada(Integer.parseInt(view.getJornada().getText()));
                                            carregarTaulaJugador();
                                            carregarTaulaEquip();

                                        } catch (NumberFormatException exception) {
                                            JOptionPane.showMessageDialog(view, "On tenies d'introduir un numero has introduit lletres o caracters o no has introduit res");
                                        }
                                        found = true;
                                        carregarTaulaJugador();
                                        carregarTaulaEquip();

                                        //  break;
                                    }
                                    if (!found) {
                                        JOptionPane.showMessageDialog(view, "No has introduit un nom de equip correcte has introduit algo mes apart de lletres");
                                        // break;
                                    }
                                    break;
                                }
                            } else {
                                JOptionPane.showMessageDialog(view, "Has de seleccionar una fila de la taula!!");
                            }
                        }
                );

        view.getEditarJugador()
                .addActionListener(
                        e -> {
                            if (filaSel2 != -1) {
                                String[] a = new String[1];
                                a[0] = view.getPosicioJugador().getText();

                                String[] a1 = {"Defensa"};
                                String[] b = {"Delanter"};
                                String[] c = {"Porter"};
                                String[] d = {"Mitg camp"};
                                String[] a2 = {"defensa"};
                                String[] b2 = {"delanter"};
                                String[] c2 = {"porter"};
                                String[] d2 = {"mitg camp"};
                                if (Arrays.compare(a, a1) == 0 || Arrays.compare(a, b) == 0 || Arrays.compare(a, c) == 0 || Arrays.compare(a, d) == 0 || Arrays.compare(a, a2) == 0 || Arrays.compare(a, b2) == 0 || Arrays.compare(a, c2) == 0 || Arrays.compare(a, d2) == 0) {
                                    Pattern pattern = null;
                                    pattern = Pattern.compile("^[a-zA-Z]*$");
                                    while (true) {
                                        String text = view.getNomJugador().getText().replace(" ", "");
                                        if (text.isEmpty()) {
                                            JOptionPane.showMessageDialog(view, "No has introduit res, esta buit!!!");
                                            break;
                                        }
                                        Matcher matcher = pattern.matcher(text);
                                        boolean found = false;
                                        if (matcher.find()) {

                                            found = true;
                                            TableColumnModel tcm2 = view.getTaulaJugadors().getColumnModel();
                                            tcm2.addColumn(tc2);
                                            Jugador obj = (Jugador) view.getTaulaJugadors().getValueAt(filaSel2, tcm2.getColumnCount() - 1);
                                            TableColumnModel tcm20 = view.getTaulaEquips().getColumnModel();
                                            tcm20.addColumn(tc);
                                            tcm20.removeColumn(tc);
                                            tcm2.removeColumn(tc2);
                                            try {

                                                Equip obj1 = (Equip) view.getjComboBox1().getSelectedItem();
                                                if (obj.get2_equip() == null) {
                                                    obj.set2_equip(obj1);
                                                    obj.get2_equip().get9_jug().add(obj);
                                                } else if (obj.get2_equip() != obj1) {
                                                    obj.get2_equip().get9_jug().remove(obj);
                                                    obj.set2_equip(null);
                                                    obj.set2_equip(obj1);
                                                    obj.get2_equip().get9_jug().add(obj);
                                                }
                                                String[] a3 = new String[1];
                                                a3[0] = view.getPosicioJugador().getText();
                                                obj.set3_posicio(a3);
                                                String nomjugador = view.getNomJugador().getText().replace(" ", "");
                                                obj.set1_nomcognoms(view.getNomJugador().getText());
                                                if (Integer.parseInt(view.getGolsJugador().getText()) < 0 || Integer.parseInt(view.getPartitsJugador().getText()) < 0) {
                                                    JOptionPane.showMessageDialog(view, "Has introduit un numero negatiu!!!");
                                                    found = true;
                                                    break;
                                                }
                                                obj.set4_gols(Integer.parseInt(view.getGolsJugador().getText()));
                                                obj.set5_partits(Integer.parseInt(view.getPartitsJugador().getText()));
                                                // escriureFitxerJugador();

                                            } catch (NumberFormatException exception) {
                                                JOptionPane.showMessageDialog(view, "On tenies d'introduir un numero has introduit lletres o caracters o no has introduit res");
                                                found = true;
                                                break;
                                            }
                                            carregarTaulaJugador();
                                            carregarTaulaEquip();
                                            //Aqui li donem el valor de -1 ja que sinos al editar ens deseleccionara la fila de la taula
                                            //pero si li tornem a donar a editar ens editara igual sense tenir la fila seleccionada
                                            //aixi que per evitar aixo li fiquem el valor -1.
                                            filaSel2 = -1;
                                            break;
                                        }
                                        if (!found) {
                                            JOptionPane.showMessageDialog(view, "No has introduit un nom de jugador correcte has introduit algo mes apart de lletres");
                                            break;
                                        }
                                        break;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(view, "No has introduit una posicio correcta te de ser Defensa o Delanter o Porter o mitg camp");

                                }
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

        view.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int seleccion = JOptionPane.showOptionDialog(
                        view, "Vol guardar les dades antes de sortir?", "Atenció!", 1, 3, null, new Object[]{"Si", "No", "Cancelar"}, "Si");

                switch (seleccion) {
                    case 0: {
                        try {
                            try {
                                model.guardarFitxers();
                            } catch (IOException ex) {
                                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            model.escriureFitxer();
                            model.escriureFitxerJugador();
                            System.exit(0);
                            break;
                        } catch (IOException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    case 1:
                        System.exit(0);
                        break;
                }
            }
        });
    }
}
