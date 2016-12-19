/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

/**
 *
 * @author Marcel
 */
public enum Action {
    INSERIR(1),ALTERAR(2), REMOVER(3);
    
    private int valor;

    private Action(int valor) {
        this.valor = valor;
    }
}
