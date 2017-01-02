/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.crud;

import com.model.DAO.GrupoDAO;
import com.model.entidades.Grupo;
import com.model.entidades.IEntidades;

/**
 *
 * @author Marcel
 */
public class GrupoCRUD implements ICRUD<Grupo> {

    private GrupoCRUD() {
    }

    public static GrupoCRUD getInstance() {
        return GrupoCRUDHolder.INSTANCE;
    }

    public void criar(IEntidades e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Grupo ler(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Grupo e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagar(Grupo e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class GrupoCRUDHolder {

        private static final GrupoCRUD INSTANCE = new GrupoCRUD();
    }

    GrupoDAO dao = new GrupoDAO();

    public GrupoDAO getDao() {
        return dao;
    }

}
