/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class Jugador {

    private String _1_nomJugador;
    private String _2_cognomsJugador;
    private String _3_equipJugador;
    private String _4_posicioJugador;
    private int _5_golsJugador;
    private int _6_partitsJugador;

    public Jugador(String _1_nomJugador, String _2_cognomsJugador, String _3_equipJugador, String _4_posicioJugador, int _5_golsJugador, int _6_partitsJugador) {
        this._1_nomJugador = _1_nomJugador;
        this._2_cognomsJugador = _2_cognomsJugador;
        this._3_equipJugador = _3_equipJugador;
        this._4_posicioJugador = _4_posicioJugador;
        this._5_golsJugador = _5_golsJugador;
        this._6_partitsJugador = _6_partitsJugador;
    }

    
    
    public String get1_nomJugador() {
        return _1_nomJugador;
    }

    public void set1_nomJugador(String _1_nomJugador) {
        this._1_nomJugador = _1_nomJugador;
    }

    public String get2_cognomsJugador() {
        return _2_cognomsJugador;
    }

    public void set2_cognomsJugador(String _2_cognomsJugador) {
        this._2_cognomsJugador = _2_cognomsJugador;
    }

    public String get3_equipJugador() {
        return _3_equipJugador;
    }

    public void set3_equipJugador(String _3_equipJugador) {
        this._3_equipJugador = _3_equipJugador;
    }

    public String get4_posicioJugador() {
        return _4_posicioJugador;
    }

    public void set4_posicioJugador(String _4_posicioJugador) {
        this._4_posicioJugador = _4_posicioJugador;
    }

    public int get5_golsJugador() {
        return _5_golsJugador;
    }

    public void set5_golsJugador(int _5_golsJugador) {
        this._5_golsJugador = _5_golsJugador;
    }

    public int get6_partitsJugador() {
        return _6_partitsJugador;
    }

    public void set6_partitsJugador(int _6_partitsJugador) {
        this._6_partitsJugador = _6_partitsJugador;
    }

    @Override
    public String toString() {
        return "Jugador{" + "_1_nomJugador=" + _1_nomJugador + ", _2_cognomsJugador=" + _2_cognomsJugador + ", _3_equipJugador=" + _3_equipJugador + ", _4_posicioJugador=" + _4_posicioJugador + ", _5_golsJugador=" + _5_golsJugador + ", _6_partitsJugador=" + _6_partitsJugador + '}';
    }

  
}
