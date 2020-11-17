/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.View;
/**
 *
 * @author davidmarsal
 */
public class Equip {

    private String nomEquip;
    private int golsEnContra;
    private int golsAfavor;
    private int partitsGuanyats;
    private int partitsPerduts;
    private int partitsEmpatats;
    private int puntsEquip;
    private int jornada;

    
    public Equip(String nomEquip, int golsEnContra, int golsAfavor, int partitsGuanyats, int partitsPerduts, int partitsEmpatats, int puntsEquip, int jornada) {
        this.nomEquip = nomEquip;
        this.golsEnContra = golsEnContra;
        this.golsAfavor = golsAfavor;
        this.partitsGuanyats = partitsGuanyats;
        this.partitsPerduts = partitsPerduts;
        this.partitsEmpatats = partitsEmpatats;
        this.puntsEquip = puntsEquip;
        this.jornada = jornada;
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

      public Object[] toArray(){
        return new Object[]{nomEquip, golsEnContra, golsAfavor, partitsGuanyats, partitsPerduts, partitsEmpatats, puntsEquip,jornada};
    }

}
