/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.model.DAO.GrupoDAO;
import com.model.entidades.IEntidades;
import com.model.entidades.Grupo;

/**
 *
 * @author Marcel
 */
public class GrupoCRUD implements ICRUD<Grupo> {
    
    private final GrupoDAO dao =  new GrupoDAO();
    
    private GrupoCRUD() {
    }

    public static GrupoCRUD getInstance() {
        return GrupoCRUDHolder.INSTANCE;
    }

       @Override
    public void inserir(Grupo e) {
        dao.salvar(e);
    }

    @Override
    public Grupo ler(String nome) {
        return dao.encontrar(nome);
    }

    @Override
    public void editar(Grupo e) {
       dao.atualizar(e);
    }

    @Override
    public void apagar(Grupo e) {
        dao.remover(e);
    }
    private static class GrupoCRUDHolder {

        private static final GrupoCRUD INSTANCE = new GrupoCRUD();
    }


    public GrupoDAO getDao() {
        return dao;
    }

}
