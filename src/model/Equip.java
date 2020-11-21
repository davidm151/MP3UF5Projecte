/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.View;
/**
 *
 * @author davidmarsal
 */
public class Equip implements Comparable<Equip>{

    private String _1_nomEquip;
    private int _2_golsEnContra;
    private int _3_golsAfavor;
    private int _4_partitsGuanyats;
    private int _5_partitsPerduts;
    private int _6_partitsEmpatats;
    private int _7_puntsEquip;
    private int _8_jornada;

    
    public Equip(String _1_nomEquip, int _2_golsEnContra, int _3_golsAfavor, int _4_partitsGuanyats, int _5_partitsPerduts, int _6_partitsEmpatats, int _7_puntsEquip, int _8_jornada) {
        this._1_nomEquip = _1_nomEquip;
        this._2_golsEnContra = _2_golsEnContra;
        this._3_golsAfavor = _3_golsAfavor;
        this._4_partitsGuanyats = _4_partitsGuanyats;
        this._5_partitsPerduts = _5_partitsPerduts;
        this._6_partitsEmpatats = _6_partitsEmpatats;
        this._7_puntsEquip = _7_puntsEquip;
        this._8_jornada = _8_jornada;
    }

    public String get1_nomEquip() {
        return _1_nomEquip;
    }

    public void set1_nomEquip(String _1_nomEquip) {
        this._1_nomEquip = _1_nomEquip;
    }

    public int get2_golsEnContra() {
        return _2_golsEnContra;
    }

    public void set2_golsEnContra(int _2_golsEnContra) {
        this._2_golsEnContra = _2_golsEnContra;
    }

    public int get3_golsAfavor() {
        return _3_golsAfavor;
    }

    public void set3_golsAfavor(int _3_golsAfavor) {
        this._3_golsAfavor = _3_golsAfavor;
    }

    public int get4_partitsGuanyats() {
        return _4_partitsGuanyats;
    }

    public void set4_partitsGuanyats(int _4_partitsGuanyats) {
        this._4_partitsGuanyats = _4_partitsGuanyats;
    }

    public int get5_partitsPerduts() {
        return _5_partitsPerduts;
    }

    public void set5_partitsPerduts(int _5_partitsPerduts) {
        this._5_partitsPerduts = _5_partitsPerduts;
    }

    public int get6_partitsEmpatats() {
        return _6_partitsEmpatats;
    }

    public void set6_partitsEmpatats(int _6_partitsEmpatats) {
        this._6_partitsEmpatats = _6_partitsEmpatats;
    }

    public int get7_puntsEquip() {
        return _7_puntsEquip;
    }

    public void set7_puntsEquip(int _7_puntsEquip) {
        this._7_puntsEquip = _7_puntsEquip;
    }

    public int get8_jornada() {
        return _8_jornada;
    }

    public void set8_jornada(int _8_jornada) {
        this._8_jornada = _8_jornada;
    }

    @Override
    public String toString() {
        return "Equip{" + "_1_nomEquip=" + _1_nomEquip + ", _2_golsEnContra=" + _2_golsEnContra + ", _3_golsAfavor=" + _3_golsAfavor + ", _4_partitsGuanyats=" + _4_partitsGuanyats + ", _5_partitsPerduts=" + _5_partitsPerduts + ", _6_partitsEmpatats=" + _6_partitsEmpatats + ", _7_puntsEquip=" + _7_puntsEquip + ", _8_jornada=" + _8_jornada + '}';
    }

    @Override
    public int compareTo(Equip o) {
         return this._7_puntsEquip-o._7_puntsEquip; 
    }

}
