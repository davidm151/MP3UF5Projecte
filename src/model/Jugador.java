/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class Jugador implements Comparable<Jugador> {

    private String _1_nomcognomsJugador;
    private String _2_equipJugador;
    private String _3_posicioJugador;
    private int _4_golsJugador;
    private int _5_partitsJugador;

    public Jugador(String _1_nomcognomsJugador, String _2_equipJugador, String _3_posicioJugador, int _4_golsJugador, int _5_partitsJugador) {
        this._1_nomcognomsJugador = _1_nomcognomsJugador;
        this._2_equipJugador = _2_equipJugador;
        this._3_posicioJugador = _3_posicioJugador;
        this._4_golsJugador = _4_golsJugador;
        this._5_partitsJugador = _5_partitsJugador;
    }

    @Override
    public String toString() {
        return "Jugador{" + "_1_nomcognomsJugador=" + _1_nomcognomsJugador + ", _2_equipJugador=" + _2_equipJugador + ", _3_posicioJugador=" + _3_posicioJugador + ", _4_golsJugador=" + _4_golsJugador + ", _5_partitsJugador=" + _5_partitsJugador + '}';
    }

    public String get1_nomcognomsJugador() {
        return _1_nomcognomsJugador;
    }

    public void set1_nomcognomsJugador(String _1_nomcognomsJugador) {
        this._1_nomcognomsJugador = _1_nomcognomsJugador;
    }

    public String get2_equipJugador() {
        return _2_equipJugador;
    }

    public void set2_equipJugador(String _2_equipJugador) {
        this._2_equipJugador = _2_equipJugador;
    }

    public String get3_posicioJugador() {
        return _3_posicioJugador;
    }

    public void set3_posicioJugador(String _3_posicioJugador) {
        this._3_posicioJugador = _3_posicioJugador;
    }

    public int get4_golsJugador() {
        return _4_golsJugador;
    }

    public void set4_golsJugador(int _4_golsJugador) {
        this._4_golsJugador = _4_golsJugador;
    }

    public int get5_partitsJugador() {
        return _5_partitsJugador;
    }

    public void set5_partitsJugador(int _5_partitsJugador) {
        this._5_partitsJugador = _5_partitsJugador;
    }

    @Override
    public int compareTo(Jugador o) {
        return Comparator.comparing(Jugador::get4_golsJugador).thenComparing(Jugador::get1_nomcognomsJugador).compare(this, o);
    }

}
