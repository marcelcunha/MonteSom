/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.DAO;

import com.model.entidades.Modelo;

/**
 *
 * @author Marcel
 */
public class ModeloDao extends GenericDao<Modelo, Long>{

    public ModeloDao(Class<Modelo> persistedClass) {
        super(Modelo.class);
    }
    
   
}
