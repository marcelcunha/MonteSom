/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.model.entidades.IEntidades;

/**
 *
 * @author Marcel
 * @param <T>
 */
public  interface  ICRUD<T extends IEntidades> {
    public void inserir(T e);
    public T ler(String nome);
    public void editar(T e);
    public void apagar(T e);
}
