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
public class PrateleiraCRUD {
    
    private PrateleiraCRUD() {
    }
    
    public static PrateleiraCRUD getInstance() {
        return PrateleiraCRUDHolder.INSTANCE;
    }
    
    private static class PrateleiraCRUDHolder {

        private static final PrateleiraCRUD INSTANCE = new PrateleiraCRUD();
    }
}
