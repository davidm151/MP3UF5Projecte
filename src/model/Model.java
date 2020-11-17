/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author profe
 */
public class Model {
 
    private static final int GRANDARIA = 12;
    private static int prBuida = 0;
    private static Equip[] v = new Equip[GRANDARIA];
    private Collection c=new ArrayList();

    public static int getPrBuida() {
        return prBuida;
    }

    public static void setPrBuida(int prBuida) {
        Model.prBuida = prBuida;
    }

    public static Equip[] getV() {
        return v;
    }

    public static void setV(Equip[] v) {
        Model.v = v;
    }

    public Collection getC() {
        return c;
    }

    public Model() {
        c=new TreeSet();
    }
    public void Model(Collection c) {
        this.c = c;
    }

 public static Object[] afegir(String nomEquip, int golsEnContra, int golsAfavor, int partitsGuanyats, int partitsPerduts, int partitsEmpatats, int puntsEquip, int jornada) {
//Model c=new Model(new ArrayList());
        if (prBuida == v.length) {
            //JOptionPane.showMessageDialog(jt,"Ho sento pero no caben més jugadors!!!");
        } else {
            try {
                Equip eq1 = new Equip(
                nomEquip,
                golsEnContra,
                golsAfavor,
                partitsGuanyats,
                partitsPerduts,
                partitsEmpatats,
                puntsEquip,
                jornada
        );

                //Insertem el nou Jugador al vector
                v[prBuida++] = eq1;

                //Anem a mostrar el contingut del vector dins de la taula
                //DefaultTableModel model = (DefaultTableModel) taulaJugadors.getModel();
                //DefaultTableModel model = (DefaultTableModel) view.getTaulaJugadors().getModel();
                //model.addRow(eq1.toArray());
                //posarEnBlanc();
                 return eq1.toArray();
            } catch (java.lang.NumberFormatException e) {
              //  JOptionPane.showMessageDialog(this, "Hi ha alguna dada incorrecta");
            }
            
           
        };return null;

        
    }
    
    public static void borrar(int x){

        if (x != -1) {
            int i = x;
            for (; i < v.length - 1 && v[i] != null; i++) {
                v[i] = v[i + 1];
            }
            prBuida--;
            v[i] = null;
    }
        
    }
    
    public static Object[] modificar(int x,String nomEquip, int golsEnContra, int golsAfavor, int partitsGuanyats, int partitsPerduts, int partitsEmpatats, int puntsEquip, int jornada){
    

        if (x != -1) {

            
               Equip eq1 = new Equip(
                nomEquip,
                golsEnContra,
                golsAfavor,
                partitsGuanyats,
                partitsPerduts,
                partitsEmpatats,
                puntsEquip,
                jornada
                );

                //Modifiquem el nou Jugador al vector
                v[x] = eq1;
                return eq1.toArray();
                
                

                
    }
        return null;
    }
    

  
    

}
