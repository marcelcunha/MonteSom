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
public class FabricanteCRUD {
    
    private FabricanteCRUD() {
    }
    
    public static FabricanteCRUD getInstance() {
        return FabricanteCRUDHolder.INSTANCE;
    }
    
    private static class FabricanteCRUDHolder {

        private static final FabricanteCRUD INSTANCE = new FabricanteCRUD();
    }
}
