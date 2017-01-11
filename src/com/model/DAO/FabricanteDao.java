/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.DAO;

import com.model.entidades.Fabricante;

/**
 *
 * @author Marcel
 */
public class FabricanteDao extends GenericDao<Fabricante, Integer> {

    public FabricanteDao() {
        super(Fabricante.class);
    }

}
