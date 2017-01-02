/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.crud;

import com.model.entidades.IEntidades;

/**
 *
 * @author Marcel
 */
public  interface  ICRUD<T> {
   
    public T ler(String nome);
    public void editar(T e);
    public void apagar(T e);
}
