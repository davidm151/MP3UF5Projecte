/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import model.Jugador;

/**
 *
 * @author profe
 */
public class Model implements Serializable{

    private static Collection<Equip> dades = new TreeSet<>();
    private static Collection<Equip> dades2 = new TreeSet<>(new EquipOrdenaPuntuacio());
    private static Collection<Jugador> dadesJugador = new TreeSet<>();
    private static Collection<Jugador> dadesJugador2 = new TreeSet<>(new JugadorOrdena());
    private static Collection<Jugador> dadesJugadorCopia = new TreeSet<>();

    private static int prBuida = 0;

    public static Collection<Jugador> getDadesJugadorCopia() {
        return dadesJugadorCopia;
    }

    public static Collection<Jugador> getDadesJugador2() {
        return dadesJugador2;
    }

    public static Collection<Equip> getDades2() {
        return dades2;

    }

    public static Collection<Equip> getDades() {
        return dades;
    }

    public static Collection<Jugador> getDadesJugador() {
        return dadesJugador;
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
        
        //Collection<Jugador> 9_jug = Equip.get9_jug();
    }
    
//     private void escriureFitxer() {
//        ObjectOutputStream output = null;
//        try {
//            //Anem a guardar el objectes continguts al vector dins d'un fitxer --> escriptura --> Output
//            output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fitxer)));
//            
//            output.writeObject(data);
//            
//         }   catch (FileNotFoundException ex) {
//
//        } catch (IOException ex) {
//
//        } finally {
//            try {
//                //Tanquem els recursos
//                output.close();
//            } catch (IOException ex) {
//
//            } catch (NullPointerException ex) {
//
//            }
//        }
//    }
//
//    private void escriureFitxerJugador() {
//        ObjectOutputStream output = null;
//        try {
//            //Anem a guardar el objectes continguts al vector dins d'un fitxer --> escriptura --> Output
//            output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fitxer2)));
//            for (Jugador eq : model.getDadesJugador()) {
////System.out.println(eq.get9_jug());
//               output.writeObject(eq);
//               
////                output.writeObject(eq.get1_nomcognoms());
////                output.writeObject(eq.get2_equip());
////                output.writeObject(eq.get3_posicio());
////                output.writeObject(eq.get4_gols());
////                output.writeObject(eq.get5_partits());
//            }
//        } catch (FileNotFoundException ex) {
//
//        } catch (IOException ex) {
//
//        } finally {
//            try {
//                //Tanquem els recursos
//                output.close();
//            } catch (IOException ex) {
//
//            } catch (NullPointerException ex) {
//
//            }
//        }
//    }
//
//    private void llegirFitxer() {
//        if (fitxer.exists()) {
//            //LLegim el fitxer --> lectura --> Input
//            ObjectInputStream input = null;
//
//            //Anem a mostrar el contingut del vector dins de la taula
//            // DefaultTableModel model = (DefaultTableModel) taulaJugadors.getModel();
//            try {
////                System.out.println("hola");
//                //Anem a llegir els objectes continguts al fitxer i els guardem al vector
//                input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fitxer)));
//
//                int i = 0;
//
//                String a = "";
//                int b1 = 0;
//                int b2 = 0;
//                int b3 = 0;
//                int b4 = 0;
//                int b5 = 0;
//                int b6 = 0;
//                int b7 = 0;
//                Equip obj;
//                Jugador obj2;
//                while (input!=null) {
//                    //  System.out.println("hola");
////                    Equip obj =(Equip)input.readObject();
////                    a=input.readUTF();
////                    b1=input.readInt();
////                    b2=input.readInt();
////                    b3=input.readInt();
////                    b4=input.readInt();
////                    b5=input.readInt();
////                    b6=input.readInt();
////                    b7=input.readInt();
//                    obj = (Equip) input.readObject();
//                    System.out.println(obj.toString());
//                    Model.<Equip>insertar(obj, model.getDades());
//                    carregarTaulaEquip();
////                    obj2 = (Jugador) input.readObject();
////                    System.out.println(obj2.toString());
////                    Model.<Jugador>insertar(obj2, model.getDadesJugador());
////                    carregarTaulaJugador();
////                    System.out.println(input.readUTF());
////                    System.out.println(input.readInt());
////                    System.out.println(input.readInt());
////                    System.out.println(input.readInt());
////                    System.out.println(input.readInt());
////                    System.out.println(input.readInt());
////                    System.out.println(input.readInt());
////                    System.out.println(input.readInt());
////                    System.out.println(input.readObject());
////                    System.out.println("holaaa");
//                    // model.obtenirEquip((Equip)input.readObject());
//                    //   Model.<Equip>insertar((Equip)input.readObject(), model.getDades());
//                    //  carregarTaulaEquip();
//                }
//
//            } catch (ArrayIndexOutOfBoundsException ex) {
//                System.out.println("Atenció, tens més objectes que esl que pot administrar l'aplicació...");
//            } catch (FileNotFoundException ex) {
//
//            } catch (IOException ex) {
//                System.out.println("Hem acabat de llegir el fitxer...");
//            } catch (ClassNotFoundException ex) {
//
//            } finally {
//                try {
//                    input.close();
//                } catch (IOException ex) {
//
//                } catch (NullPointerException ex) {
//
//                }
//            }
//        }
//    }
//
//    private void llegirFitxerJugadors() {
//        if (fitxer2.exists()) {
//            //LLegim el fitxer --> lectura --> Input
//            ObjectInputStream input = null;
//
//            //Anem a mostrar el contingut del vector dins de la taula
//            // DefaultTableModel model = (DefaultTableModel) taulaJugadors.getModel();
//            try {
//                //Anem a llegir els objectes continguts al fitxer i els guardem al vector
//                input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fitxer2)));
//
//                int i = 0;
//
//                Jugador obj;
//                while (input!=null) {
//                    obj = (Jugador) input.readObject();
//                    System.out.println(obj.toString());
//                    Model.<Jugador>insertar(obj, model.getDadesJugador());
//                    carregarTaulaJugador();
//                }
//
//            } catch (ArrayIndexOutOfBoundsException ex) {
//                System.out.println("Atenció, tens més objectes que esl que pot administrar l'aplicació...");
//            } catch (FileNotFoundException ex) {
//
//            } catch (IOException ex) {
//                System.out.println("Hem acabat de llegir el fitxer...");
//            } catch (ClassNotFoundException ex) {
//
//            } finally {
//                try {
//                    input.close();
//                } catch (IOException ex) {
//
//                } catch (NullPointerException ex) {
//
//                }
//            }
//        }
//    }


    public static <T> void insertar(T eq1, Collection<T> coleccion) {
        coleccion.add(eq1);
    }

//    public static <T> void eliminar(T eq1, Collection<T> coleccion) {
//        coleccion.remove(eq1);
//        //Jugador.get2_equip().get9_jug().remove(eq1);
//    }
    public static void borrarEquip(Equip eq1) {
        dades.remove(eq1);
        dades2.remove(eq1);
//        if (j1.get2_equip() != null && j1.get2_equip().compareTo(eq1) == 0) {
//            j1.set2_equip(null);
//        }
        
        for(Jugador j:eq1.get9_jug()) j.set2_equip(null);

    }

    public static void borrarJugador(Jugador j1) {
        dadesJugador.remove(j1);
        dadesJugador2.remove(j1);

        if (j1.get2_equip() != null) {
            j1.get2_equip().get9_jug().remove(j1);
        }
        //  if(j1.get2_equip()!=null)j1.get2_equip().get9_jug().remove(j1);

    }

    public static void obtenirEquip(StringBuilder _1_nomEquip, int _2_golsEnContra, int _3_golsAfavor, int _4_partitsGuanyats, int _5_partitsPerduts, int _6_partitsEmpatats, int _7_puntsEquip, int _8_jornada){
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

    public static void obtenirJugador(String _1_nomcognomsJugador, Equip _2_equipJugador, String[] _3_posicioJugador, int _4_golsJugador, int _5_partitsJugador){
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
//    public static void buscarEquipEnJugador(){
//    while(dades.contains(dades)) {
//             /*En este caso se posiciona en el objeto y se accede al  método del objeto que contiene el valor buscado*/
//	        System.out.println(it.next().getNombre());
//
//		}
//    }

//    public void dasd() {
//        String a[] = new String[]{"A", "B", "C", "D"};
//        List<String> list = Arrays.asList(a);
//        System.out.println("The list is: " + list);
//    }
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
