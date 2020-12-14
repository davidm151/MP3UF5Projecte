/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author davidmarsal
 */
public class Excepcio extends Exception {

    private Map<Integer, String> missatges = new TreeMap<>();
    private int valor;

    private Excepcio() {
        missatges.put(1, "On tenies d'introduir un numero has introduit lletres o caracters o no has introduit res");
    }

    public Excepcio(int valor) {
        this();
        this.valor = valor;
    }

    public String retornaMissatge() {
        return missatges.get(this.valor);
    }

}
