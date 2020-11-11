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

    private String nomEquip;
    private int golsEnContra;
    private int golsAfavor;
    private int partitsGuanyats;
    private int partitsPerduts;
    private int partitsEmpatats;
    private int puntsEquip;
    private int jornada;
    private String data[][];  
    String column[];  
    JTable jt;   

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
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
    
    public String getNomEquip() {
        return nomEquip;
    }

    public void setNomEquip(String nomEquip) {
        this.nomEquip = nomEquip;
    }

    public int getGolsEnContra() {
        return golsEnContra;
    }

    public void setGolsEnContra(int golsEnContra) {
        this.golsEnContra = golsEnContra;
    }

    public int getGolsAfavor() {
        return golsAfavor;
    }

    public void setGolsAfavor(int golsAfavor) {
        this.golsAfavor = golsAfavor;
    }

    public int getPartitsGuanyats() {
        return partitsGuanyats;
    }

    public void setPartitsGuanyats(int partitsGuanyats) {
        this.partitsGuanyats = partitsGuanyats;
    }

    public int getPartitsPerduts() {
        return partitsPerduts;
    }

    public void setPartitsPerduts(int partitsPerduts) {
        this.partitsPerduts = partitsPerduts;
    }

    public int getPartitsEmpatats() {
        return partitsEmpatats;
    }

    public void setPartitsEmpatats(int partitsEmpatats) {
        this.partitsEmpatats = partitsEmpatats;
    }

    public int getPuntsEquip() {
        return puntsEquip;
    }

    public void setPuntsEquip(int puntsEquip) {
        this.puntsEquip = puntsEquip;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }
    
    

}
