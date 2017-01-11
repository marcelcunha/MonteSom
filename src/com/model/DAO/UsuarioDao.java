/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.DAO;

import com.model.entidades.Usuario;

/**
 *
 * @author Marcel
 */
public class UsuarioDao extends GenericDao<Usuario, Long> {

    public UsuarioDao() {
        super(Usuario.class);
    }

    public Usuario encontrar(String usr) {

        return entityManager.createNamedQuery("Usuario.findByUserUsr", Usuario.class)
                .setParameter("userUsr", usr).getSingleResult();
    }

}
