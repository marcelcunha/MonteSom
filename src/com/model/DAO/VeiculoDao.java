/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.DAO;

import com.model.entidades.Veiculo;

/**
 *
 * @author Marcel
 */
public class VeiculoDao extends GenericDao<Veiculo, Long> {
    
    public VeiculoDao() {
        super(Veiculo.class);
    }
    
}
