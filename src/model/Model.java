/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import javax.swing.JTable;

/**
 *
 * @author profe
 */
public class Model {

    private static Collection<Equip> dades = new TreeSet<>();
    private static Collection<Equip> dades2 = new TreeSet<>(new EquipOrdenaPuntuacio());
    private static Collection<Jugador> dadesJugador = new TreeSet<>();
    private static Collection<Jugador> dadesJugador2 = new TreeSet<>(new JugadorOrdena());
    private static Collection<Jugador> dadesJugadorCopia = new TreeSet<>();

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
        Equip a1=new Equip("a1", 1, 2, 3, 4, 5, 6, 0);
        Equip a2=new Equip("a2", 2, 1, 1, 1, 1, 1, 2);
        dades.add(a1);
        dades.add(a2);

        dadesJugador.add(new Jugador("a", a1, "a1", 10, 10));
        dadesJugador.add(new Jugador("b", a1, "a2", 9, 9));
        dadesJugador.add(new Jugador("c", a2, "a3", 8, 8));
        dadesJugador.add(new Jugador("d", a2, "a4", 7, 7));
        dadesJugador.add(new Jugador("e", a2, "a5", 6, 6));

    }

    public static Equip afegirEquip(String _1_nomEquip, int _2_golsEnContra, int _3_golsAfavor, int _4_partitsGuanyats, int _5_partitsPerduts, int _6_partitsEmpatats, int _7_puntsEquip, int _8_jornada) {
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
        dades.add(eq1);
        dades2.add(eq1);

        return null;
    }

    public static Equip afegirJugador(String _1_nomcognomsJugador, Equip _2_equipJugador, String _3_posicioJugador, int _4_golsJugador, int _5_partitsJugador) {
        Jugador jug1 = new Jugador(
                _1_nomcognomsJugador,
                _2_equipJugador,
                _3_posicioJugador,
                _4_golsJugador,
                _5_partitsJugador
        );
        dadesJugador.add(jug1);
        dadesJugador2.add(jug1);
        dadesJugadorCopia.add(jug1);
        return null;
    }

    public void borrarEquip(Equip eq1) {
        dades.remove(eq1);
        dades2.remove(eq1);
    }

    public void borrarJugador(Jugador j1) {
        dadesJugador.remove(j1);
        dadesJugador2.remove(j1);
    }
//    public void FicarEnBlancTaula(){
//    dadesJugadorCopia.removeAll(dadesJugador);
//    }
//    
//    public void buscarEquip(String j1) {
//        for (Jugador jug : dadesJugador) {
//            if (jug.get2_equipJugador().matches(j1)) {
//                dadesJugadorCopia.add(jug);
//            }
//        }
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
