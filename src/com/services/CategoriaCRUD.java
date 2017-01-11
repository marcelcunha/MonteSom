/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

/**
 *
 * @author Marcel
 */
public class CategoriaCRUD {
    
    private CategoriaCRUD() {
    }
    
    public static CategoriaCRUD getInstance() {
        return CategoriaCRUDHolder.INSTANCE;
    }
    
    private static class CategoriaCRUDHolder {

        private static final CategoriaCRUD INSTANCE = new CategoriaCRUD();
    }
}
