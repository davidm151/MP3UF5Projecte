/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class Jugador implements Comparable<Jugador> {

    private String _1_nomcognoms;
    private Equip _2_equip;
    private String[] _3_posicio;
    private int _4_gols;
    private int _5_partits;

    public Jugador(String _1_nomcognoms, Equip _2_equip, String[] _3_posicio, int _4_gols, int _5_partits) {
        this._1_nomcognoms = _1_nomcognoms;
        this._2_equip = _2_equip;
        this._3_posicio = _3_posicio;
        this._4_gols = _4_gols;
        this._5_partits = _5_partits;
        this._2_equip.get9_jug().add(this);
        
    }

    public String get1_nomcognoms() {
        return _1_nomcognoms;
    }

    public void set1_nomcognoms(String _1_nomcognoms) {
        this._1_nomcognoms = _1_nomcognoms;
    }

    public Equip get2_equip() {
        return _2_equip;
    }

    public void set2_equip(Equip _2_equip) {
        this._2_equip = _2_equip;
    }

    public String get3_posicio() {
       return Arrays.toString(_3_posicio);
    }

    public void set3_posicio(String[] _3_posicio) {
        this._3_posicio = _3_posicio;
    }

    public int get4_gols() {
        return _4_gols;
    }

    public void set4_gols(int _4_gols) {
        this._4_gols = _4_gols;
    }

    public int get5_partits() {
        return _5_partits;
    }

    public void set5_partits(int _5_partits) {
        this._5_partits = _5_partits;
    }

    @Override
    public String toString() {
        //return "Jugador{" + "_1_nomcognoms=" + _1_nomcognoms + ", _2_equip=" + _2_equip + ", _3_posicio=" + _3_posicio + ", _4_gols=" + _4_gols + ", _5_partits=" + _5_partits + '}';
        return _1_nomcognoms;
    }

    @Override
    public int compareTo(Jugador o) {
        return Comparator.comparing(Jugador::get4_gols).thenComparing(Jugador::get1_nomcognoms).compare(this, o);
    }

}
