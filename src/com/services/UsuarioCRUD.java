/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.model.DAO.UsuarioDao;
import com.model.entidades.Usuario;

/**
 *
 * @author Marcel
 */
public class UsuarioCRUD implements ICRUD<Usuario> {

    private final UsuarioDao dao = new UsuarioDao();

    private UsuarioCRUD() {
    }

    public static UsuarioCRUD getInstance() {
        return UsuarioCRUDHolder.INSTANCE;
    }

    @Override
    public void inserir(Usuario e) {
        dao.salvar(e);
    }

    @Override
    public Usuario ler(String nome) {
        return dao.encontrar(nome);
    }

    @Override
    public void editar(Usuario e) {
       dao.atualizar(e);
    }

    @Override
    public void apagar(Usuario e) {
        dao.remover(e);
    }

    private static class UsuarioCRUDHolder {

        private static final UsuarioCRUD INSTANCE = new UsuarioCRUD();
    }
}
