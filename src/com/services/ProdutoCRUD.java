/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.model.DAO.ProdutoDao;
import com.model.entidades.Produto;

/**
 *
 * @author Marcel
 */
public class ProdutoCRUD implements ICRUD<Produto> {

    ProdutoDao dao = new ProdutoDao();

    private ProdutoCRUD() {
    }

    public static ProdutoCRUD getInstance() {
        return ProdutoCRUDHolder.INSTANCE;
    }

    @Override
    public void inserir(Produto e) {
        dao.salvar(e);
    }

    @Override
    public Produto ler(String nome) {
        return dao.encontrar(nome);
    }

    @Override
    public void editar(Produto e) {
        dao.atualizar(e);
    }

    @Override
    public void apagar(Produto e) {
        dao.remover(e);
    }

    private static class ProdutoCRUDHolder {

        private static final ProdutoCRUD INSTANCE = new ProdutoCRUD();
    }
}
