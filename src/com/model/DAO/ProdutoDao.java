/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.DAO;

import com.model.entidades.Produto;

/**
 *
 * @author Marcel
 */
public class ProdutoDao extends GenericDao<Produto, Integer> {

    public ProdutoDao() {
        super(Produto.class);
    }

  
    public Produto encontrar(String nome) {
        return entityManager.createNamedQuery("Produto.findByNomePro", Produto.class)
                .setParameter("nomePro", nome).getSingleResult();
    }
    
    
}
