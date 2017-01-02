/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.crud;

import com.model.DAO.VeiculoDao;
import com.model.entidades.IEntidades;
import com.model.entidades.Veiculo;

/**
 *
 * @author Marcel
 */
public class VeiculoCRUD implements ICRUD<Veiculo>{
    
    private VeiculoCRUD() {
    }
    
    public static VeiculoCRUD getInstance() {
        return VeiculoCRUDHolder.INSTANCE;
    }

    @Override
    public Veiculo ler(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Veiculo e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagar(Veiculo e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private static class VeiculoCRUDHolder {

        private static final VeiculoCRUD INSTANCE = new VeiculoCRUD();
    }
    
    VeiculoDao dao = new VeiculoDao();

    public VeiculoDao getDao() {
        return dao;
    }
    
    
}
