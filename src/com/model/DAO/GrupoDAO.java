/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.DAO;

import com.model.entidades.Grupo;

/**
 *
 * @author Marcel
 */
public class GrupoDAO extends GenericDao<Grupo, Long> {

    public GrupoDAO() {
        super(Grupo.class);
    }

}
