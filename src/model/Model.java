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

    private static Collection<Equip> dades=new TreeSet<>();
   private static Collection<Equip> dades2=new TreeSet<>(new EquipOrdenaPuntuacio());
    private static Collection<Jugador> dadesJugador=new ArrayList<>();

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
        for (int i = 0; i < 12; i++) {
            dades.add(new Equip("Algo", 1, 2, 3, 4, 5, 6, i));

        }
        for (int i = 0; i < 12; i++) {
            dades2.add(new Equip("Algo", 1, 2, 3, 4, 5, 6, i));

        }
        for (int i = 0; i < 12; i++) {
            dadesJugador.add(new Jugador("Algo", "a", "a", "a", 4, i));

        }

    }

    public static void afegirEquip(String _1_nomEquip, int _2_golsEnContra, int _3_golsAfavor, int _4_partitsGuanyats, int _5_partitsPerduts, int _6_partitsEmpatats, int _7_puntsEquip, int _8_jornada) {
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
    }

    public static void afegirJugador(String _1_nomJugador, String _2_cognomsJugador, String _3_equipJugador, String _4_posicioJugador, int _5_golsJugador, int _6_partitsJugador) {
        dadesJugador.add(new Jugador(
                _1_nomJugador,
                _2_cognomsJugador,
                _3_equipJugador,
                _4_posicioJugador,
                _5_golsJugador,
                _6_partitsJugador
        ));
    }

    public void borrarEquip(Equip eq1) {
        dades.remove(eq1);
    }
    
    public void borrarJugador(Jugador j1) {
        dadesJugador.remove(j1);
    }

    public Equip modificarEquip(Equip eq1) {

        dades.add(eq1);
        return null;
    }

}

class EquipOrdenaPuntuacio implements Comparator<Equip>{

    @Override
    public int compare(Equip o1, Equip o2) {
 //      return o2.get7_puntsEquip(); 
       return o2.get1_nomEquip().compareTo(o1.get1_nomEquip());
      // return o2.get2_golsEnContra();
    }
    
}
