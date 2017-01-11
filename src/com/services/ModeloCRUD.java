/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.model.DAO.ModeloDao;
import com.model.entidades.Modelo;

/**
 *
 * @author Marcel
 */
public class ModeloCRUD implements ICRUD<Modelo>{
    
    private final ModeloDao dao = new ModeloDao(Modelo.class);
    
    private ModeloCRUD() {
    }
    
    public static ModeloCRUD getInstance() {
        return ModeloCRUDHolder.INSTANCE;
    }

    @Override
    public void inserir(Modelo e) {
        dao.salvar(e);
    }

    @Override
    public Modelo ler(String nome) {
        return dao.encontrarPorNome(nome);
    }

    @Override
    public void editar(Modelo e) {
        dao.atualizar(e);
    }

    @Override
    public void apagar(Modelo e) {
        dao.remover(e);
    }

    public ModeloDao getDao() {
        return dao;
    }
    
    private static class ModeloCRUDHolder {

        private static final ModeloCRUD INSTANCE = new ModeloCRUD();
    }
}
