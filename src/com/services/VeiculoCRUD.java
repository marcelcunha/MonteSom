/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.model.DAO.VeiculoDao;
import com.model.entidades.Veiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel
 */
public class VeiculoCRUD implements ICRUD<Veiculo> {

    private VeiculoDao dao = new VeiculoDao();

    private VeiculoCRUD() {
    }

    public static VeiculoCRUD getInstance() {
        return VeiculoCRUDHolder.INSTANCE;
    }

    @Override
    public void inserir(Veiculo e) {
        dao.salvar(e);
    }

    @Override

    public Veiculo ler(String nome) {
        return dao.encontrarPorDesc(nome);
    }

    @Override
    public void editar(Veiculo e) {
        dao.atualizar(e);
    }

    @Override
    public void apagar(Veiculo e) {
        dao.remover(e);
    }

    private static class VeiculoCRUDHolder {

        private static final VeiculoCRUD INSTANCE = new VeiculoCRUD();
    }
    List<String> list = new ArrayList<>();

    public VeiculoDao getDao() {
        return dao;
    }

}
