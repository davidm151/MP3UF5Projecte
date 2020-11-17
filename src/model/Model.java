/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JTable;

/**
 *
 * @author profe
 */
public class Model {
 
    private String column[];  
    private JTable jt;
    private Equip[] dades=new Equip[12];

    public Equip[] getDades() {
        return dades;
    }

    public void setDades(Equip[] dades) {
        this.dades = dades;
    }

    public String[] getColumn() {
        return column;
    }

    public void setColumn(String[] column) {
        this.column = column;
    }

    public JTable getJt() {
        return jt;
    }

    public void setJt(JTable jt) {
        this.jt = jt;
    }

    public void list(Equip[] dades){
    for (int x=0;x<dades.length;x++){
        System.out.println(dades[x]);
    }
    }
    

}
