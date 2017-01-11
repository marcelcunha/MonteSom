/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.DAO;

import com.model.entidades.Modelo;
import com.model.entidades.Montadora;
import com.model.entidades.Modelo;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

/**
 *
 * @author Marcel
 */
public class ModeloDao extends GenericDao<Modelo, Long>{

    public ModeloDao(Class<Modelo> persistedClass) {
        super(Modelo.class);
    }
    
    /**
     * Encontra todos modelos cadastrados de uma determinada Montadora
     * @param m - Montadora que fabrica o modelo
     * @return {@code List<Modelo>} Lista com os modelos encontrados
     */
    public List<Modelo> getListFromMarca(Montadora m) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Modelo> query = builder.createQuery(Modelo.class);

        Root<Modelo> root = query.from(Modelo.class);
        query.select(root);
        ParameterExpression<Integer> p = builder.parameter(Integer.class);
        query.where(builder.equal(root.get("codMarca"), m));
        query.orderBy(builder.asc(root.get("nome")));
        return entityManager.createQuery(query).getResultList();
    }
    
   public Modelo encontrarPorNome(String nome){
        return entityManager.createNamedQuery("Modelo.findByNome", Modelo.class)
                .setParameter("nome", nome).getSingleResult();
   }
}