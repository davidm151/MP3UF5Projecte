/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.View;

/**
 *
 * @author davidmarsal
 */
public class Equip implements Comparable<Equip> {

    private String _1_nom;
    private int _2_golsEnContra;
    private int _3_golsAfavor;
    private int _4_partitsGuanyats;
    private int _5_partitsPerduts;
    private int _6_partitsEmpatats;
    private int _7_punts;
    private int _8_jornada;
    private Collection <Jugador> _9_jug=new TreeSet<>();

    public Equip(String _1_nom, int _2_golsEnContra, int _3_golsAfavor, int _4_partitsGuanyats, int _5_partitsPerduts, int _6_partitsEmpatats, int _7_punts, int _8_jornada) {
        this._1_nom = _1_nom;
        this._2_golsEnContra = _2_golsEnContra;
        this._3_golsAfavor = _3_golsAfavor;
        this._4_partitsGuanyats = _4_partitsGuanyats;
        this._5_partitsPerduts = _5_partitsPerduts;
        this._6_partitsEmpatats = _6_partitsEmpatats;
        this._7_punts = _7_punts;
        this._8_jornada = _8_jornada;
    }

    public Collection<Jugador> get9_jug() {
        return _9_jug;
    }

    public void set9_jug(Collection<Jugador> _9_jug) {
        this._9_jug = _9_jug;
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

    public int get8_jornada() {
        return _8_jornada;
    }

    public void set8_jornada(int _8_jornada) {
        this._8_jornada = _8_jornada;
    }

    public String get1_nom() {
        return _1_nom;
    }

    public void set1_nom(String _1_nom) {
        this._1_nom = _1_nom;
    }

    public int get7_punts() {
        return _7_punts;
    }

    public void set7_punts(int _7_punts) {
        this._7_punts = _7_punts;
    }
    
    

    @Override
    public String toString() {
        return _1_nom;
    }
    

    @Override
    public int compareTo(Equip o) {
        return Comparator.comparing(Equip::get7_punts).thenComparing(Equip::get1_nom).compare(this, o);
    }

}
