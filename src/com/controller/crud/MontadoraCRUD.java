/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.crud;

import com.model.DAO.MontadoraDao;
import com.model.entidades.IEntidades;
import com.model.entidades.Montadora;

/**
 *
 * @author Marcel
 */
public class MontadoraCRUD implements ICRUD<Montadora> {

    private final MontadoraDao dao = new MontadoraDao();

    private MontadoraCRUD() {
    }

    public static MontadoraCRUD getInstance() {
        return MontadoraCRUDHolder.INSTANCE;
    }

    public void criar(String nome) {
        Montadora montadora = new Montadora(nome);
        dao.salvar(montadora);
    }

    @Override
    public Montadora ler(String nome) {
        return dao.encontrar(nome);
    }

    @Override
    public void editar(Montadora e) {
        dao.atualizar(e);
    }

    @Override
    public void apagar(Montadora e) {
        dao.remover(e);
    }

    private static class MontadoraCRUDHolder {

        private static final MontadoraCRUD INSTANCE = new MontadoraCRUD();
    }
}
