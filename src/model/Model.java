/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import view.View;

/**
 *
 * @author profe
 */
public class Model implements Serializable {
    private static View view;
    private static Collection<Equip> dades = new TreeSet<>();
    private static Collection<Equip> dades2 = new TreeSet<>(new EquipOrdenaPuntuacio());
    private static Collection<Jugador> dadesJugador = new TreeSet<>();
    private static Collection<Jugador> dadesJugador2 = new TreeSet<>(new JugadorOrdena());
    private static String fitxerEquip = "";
    private static String fitxerJugador = "";
    private static File fitxer;
    private static File fitxer2;
    private static File fitxerConfiguracio = new File("configuracio.db");
    private static File fitxerConf2 = new File("output.txt");

    public static Collection<Equip> getDades() {
        return dades;
    }

    public static Collection<Equip> getDades2() {
        return dades2;
    }

    public static Collection<Jugador> getDadesJugador() {
        return dadesJugador;
    }

    public static Collection<Jugador> getDadesJugador2() {
        return dadesJugador2;
    }

    public Model() {
//        StringBuilder s = new StringBuilder();
//        StringBuilder s2 = new StringBuilder();
//        StringBuilder s3 = new StringBuilder();
//        Equip a1 = new Equip(s.append("a"), 1, 2, 3, 4, 5, 6, 0);
//        Equip a2 = new Equip(s2.append("b"), 2, 1, 1, 1, 1, 1, 2);
//        Equip a3 = new Equip(s3.append("c"), 2, 1, 1, 1, 1, 1, 2);
//
//        dades.add(a1);
//        dades.add(a2);
//        dades.add(a3);
//
//        String[] a = {"delanter"};
//        String[] ab = {"defensa"};
//        dadesJugador.add(new Jugador("a", a1, a, 10, 10));
//        dadesJugador.add(new Jugador("b", a1, a, 9, 9));
//        dadesJugador.add(new Jugador("c", a2, a, 8, 8));
//        dadesJugador.add(new Jugador("d", a2, ab, 7, 7));
//        dadesJugador.add(new Jugador("e", a2, ab, 6, 6));
    }

    public static void escriureFitxer() throws FileNotFoundException, IOException {
        //ObjectOutputStream output = null;
        
        try(ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fitxerEquip)))) {
            for (Equip eq : Model.getDades()) {
                output.writeObject(eq);
            }
        }
    }

    public static void escriureFitxerJugador() throws IOException {
        try(ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fitxerJugador)))) {
            //Anem a guardar el objectes continguts al vector dins d'un fitxer --> escriptura --> Output
            
            for (Jugador eq : Model.getDadesJugador()) {
                if (eq.get2_equip() == null) {
                    output.writeObject(eq);
                }
            }
        }
    }

    public static void llegirFitxer() {
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fitxerEquip)));
            Equip obj;
            Jugador obj2;
            while (input != null) {
                obj = (Equip) input.readObject();
                System.out.println(obj.toString());
                Model.<Equip>insertar(obj, Model.getDades());
                for (Jugador eq : obj._9_jug) {
                    Model.<Jugador>insertar(eq, Model.getDadesJugador());
                }
            }
        }catch (FileNotFoundException ex) {
        } catch (IOException ex) {
            System.out.println("Hem acabat de llegir el fitxer...");
        } catch (ClassNotFoundException ex) {
        } catch (NullPointerException ex) {
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
            } catch (NullPointerException ex) {
            }
        }
    }

    public static void llegirFitxerJugadors() {
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fitxerJugador)));
            Jugador obj;
            while (input != null) {
                obj = (Jugador) input.readObject();
                System.out.println(obj.toString());
                Model.<Jugador>insertar(obj, Model.getDadesJugador());
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
            System.out.println("Hem acabat de llegir el fitxer...");
        } catch (ClassNotFoundException ex) {

        } finally {
            try {
                input.close();
            } catch (IOException ex) {

            } catch (NullPointerException ex) {

            }
        }
    }

    public static void guardarContrasenya() throws FileNotFoundException, IOException {
        Random rn = new Random();
        int offset = rn.nextInt(101 - 2);
        int contrasenya = 12345678;
        try (RandomAccessFile fitxerR = new RandomAccessFile(fitxerConfiguracio, "rw")) {
            fitxerR.seek(0);
            fitxerR.writeInt(offset);
            fitxerR.seek(offset);
            fitxerR.writeInt(contrasenya);
        }
    }

    public static int llegirContrasenya() throws FileNotFoundException, IOException {
        try (RandomAccessFile fitxerR1 = new RandomAccessFile(fitxerConfiguracio, "rw")) {
            fitxerR1.seek(0);
            int x = fitxerR1.readInt();
            fitxerR1.seek(x);
            return fitxerR1.readInt();
        }
    }

    public static void nomFitxerEquip_Jugador() throws FileNotFoundException, IOException {
        if (fitxerConf2.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(fitxerConf2))) {
                String[] textData = new String[2];
                String line = br.readLine();
                for (int i = 0; i <= 1; i++) {
                    textData[i] = br.readLine();
                    System.out.println(textData[i]);
                }
                fitxerEquip = textData[0];
                fitxer = new File(fitxerEquip);
                fitxerJugador = textData[1];
                fitxer2 = new File(fitxerJugador);
            }
        }
    }

    public static void guardarFitxers() throws IOException {
        if (!fitxerConf2.exists()) {
            Box box1 = Box.createHorizontalBox();
            JLabel jl1 = new JLabel("Nom Fitxer Equip: ");
            box1.add(jl1);
            JTextField f1 = new JTextField(24);
            box1.add(f1);
            JLabel jl11 = new JLabel("Nom Fitxer Jugador: ");
            box1.add(jl11);
            JTextField f11 = new JTextField(24);
            box1.add(f11);
            int button = JOptionPane.showConfirmDialog(null, box1, "Introdueix el nom dels fitxers", JOptionPane.OK_CANCEL_OPTION);
            if (button == JOptionPane.OK_OPTION) {
                fitxerEquip = f1.getText();
                fitxerJugador = f11.getText();
                System.out.println(fitxerEquip);
                System.out.println(fitxerJugador);
                String fitxer1_senseEspais = fitxerEquip.replace(" ", "");
                String fitxer2_senseEspais = fitxerJugador.replace(" ", "");
                if (!fitxer1_senseEspais.equals("") && !fitxer2_senseEspais.equals("") && !Objects.equals(fitxerEquip, fitxerJugador)) {
                    try(FileWriter writer = new FileWriter(fitxerConf2, true)){
                        writer.write("\r\n");
                        writer.write(fitxerEquip);
                        writer.write("\r\n");   // write new line
                        writer.write(fitxerJugador);
                        writer.close();
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Has introduit algo malament es tancara lo programa");
                    System.exit(0);
                }
            } else {
                System.exit(0);
            }
        }
    }

    public static void comprovarContrasenya() throws IOException {
        Box box = Box.createHorizontalBox();
        JLabel jl = new JLabel("Contrasenya: ");
        box.add(jl);

        JPasswordField jpf = new JPasswordField(24);
        box.add(jpf);
        int button = JOptionPane.showConfirmDialog(null, box, "Introdueix  la contrasenya", JOptionPane.OK_CANCEL_OPTION);
        int x = 0;
        if (!fitxerConfiguracio.exists()) {
            guardarContrasenya();
        }

        x = llegirContrasenya();
        if (button == JOptionPane.OK_OPTION) {
            char[] input = jpf.getPassword();
            String pass = String.valueOf(input);
            System.out.println(pass);

            System.out.println(String.valueOf(x));
            if (fitxerConfiguracio.exists() && pass.matches(String.valueOf(x))) {
                JOptionPane.showMessageDialog(view, "Contrasenya correcta ");
            } else {
                JOptionPane.showMessageDialog(view, "Contrasenya incorrecta ");
                System.exit(0);
            }

        } else {
            System.exit(0);
        }

    }

    public static <T> void insertar(T eq1, Collection<T> coleccion) {
        coleccion.add(eq1);
    }

    public static void borrarEquip(Equip eq1) {
        dades.remove(eq1);
        dades2.remove(eq1);
        for (Jugador j : eq1.get9_jug()) {
            j.set2_equip(null);
        }
    }

    public static void borrarJugador(Jugador j1) {
        dadesJugador.remove(j1);
        dadesJugador2.remove(j1);

        if (j1.get2_equip() != null) {
            j1.get2_equip().get9_jug().remove(j1);
        }
    }

    public static void obtenirEquip(StringBuilder _1_nomEquip, int _2_golsEnContra, int _3_golsAfavor, int _4_partitsGuanyats, int _5_partitsPerduts, int _6_partitsEmpatats, int _7_puntsEquip, int _8_jornada) {
        Equip eq1 = new Equip(
                _1_nomEquip,
                _2_golsEnContra,
                _3_golsAfavor,
                _4_partitsGuanyats,
                _5_partitsPerduts,
                _6_partitsEmpatats,
                _7_puntsEquip,
                _8_jornada
        );
        Model.insertar(eq1, dades);
        Model.insertar(eq1, dades2);
    }

    public static void obtenirJugador(String _1_nomcognomsJugador, Equip _2_equipJugador, String[] _3_posicioJugador, int _4_golsJugador, int _5_partitsJugador) {
        Jugador jug1 = new Jugador(
                _1_nomcognomsJugador,
                _2_equipJugador,
                _3_posicioJugador,
                _4_golsJugador,
                _5_partitsJugador
        );
        Model.insertar(jug1, dadesJugador);
        Model.insertar(jug1, dadesJugador);

    }
}

class EquipOrdenaPuntuacio implements Comparator<Equip> {

    @Override
    public int compare(Equip o1, Equip o2) {
        return o1.get1_nom().compareTo(o2.get1_nom());
    }

}

class JugadorOrdena implements Comparator<Jugador> {

    @Override
    public int compare(Jugador o1, Jugador o2) {
        return o1.get1_nomcognoms().compareTo(o2.get1_nomcognoms());
    }
}
