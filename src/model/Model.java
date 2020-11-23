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
        
            dades.add(new Equip("Algo", 1, 2, 3, 4, 5, 6, 0));
            dades.add(new Equip("b", 2, 1, 1, 1, 1, 1, 2));

        
            dadesJugador.add(new Jugador("a", "a1", "a1", "a1", 10, 10));
            dadesJugador.add(new Jugador("b", "a2", "a2", "a2", 9, 9));
            dadesJugador.add(new Jugador("c", "a3", "a3", "a3", 8, 8));
            dadesJugador.add(new Jugador("d", "a4", "a4", "a4", 7, 7));
            dadesJugador.add(new Jugador("e", "a5", "a5", "a5", 6, 6));


        

    }

    public static Equip afegirEquip(String _1_nomEquip, int _2_golsEnContra, int _3_golsAfavor, int _4_partitsGuanyats, int _5_partitsPerduts, int _6_partitsEmpatats, int _7_puntsEquip, int _8_jornada) {
        dades.add(new Equip(
                _1_nomEquip,
                _2_golsEnContra,
                _3_golsAfavor,
                _4_partitsGuanyats,
                _5_partitsPerduts,
                _6_partitsEmpatats,
                _7_puntsEquip,
                _8_jornada
        ));
        return null;
    }

    public static Equip afegirJugador(String _1_nomJugador, String _2_cognomsJugador, String _3_equipJugador, String _4_posicioJugador, int _5_golsJugador, int _6_partitsJugador) {
        dadesJugador.add(new Jugador(
                _1_nomJugador,
                _2_cognomsJugador,
                _3_equipJugador,
                _4_posicioJugador,
                _5_golsJugador,
                _6_partitsJugador
        ));
        return null;
    }

    public void borrarEquip(Equip eq1) {
        dades.remove(eq1);
    }

    public void borrarJugador(Jugador j1) {
        dadesJugador.remove(j1);
    }

    public void modificarEquip(Equip eq1) {
        dades.add(eq1);
//         ArrayList<String> arrayList2 = new ArrayList<String>();
//        for(int i = 0;i<dades.size();i++)
//        {
//            String test = dades.get(i);
//            test += "java";
//            arrayList2.add(test); 
//        }
//        System.out.println(arrayList2);
        
        
    }

}

class EquipOrdenaPuntuacio implements Comparator<Equip> {

    @Override
    public int compare(Equip o1, Equip o2) {
        return o1.get1_nomEquip().compareTo(o2.get1_nomEquip());
    }

}

class JugadorOrdena implements Comparator<Jugador> {

    @Override
    public int compare(Jugador o1, Jugador o2) {
        return o1.get1_nomJugador().compareTo(o2.get1_nomJugador());

    }
}
