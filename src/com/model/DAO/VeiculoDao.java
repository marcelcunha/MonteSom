/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.DAO;

import com.model.entidades.Modelo;
import com.model.entidades.Veiculo;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Marcel
 */
public class VeiculoDao extends GenericDao<Veiculo, Long> {
    
    public VeiculoDao() {
        super(Veiculo.class);
    }
    
     public List<Veiculo> getListFromMarca(Integer id) {
       CriteriaBuilder builder = entityManager.getCriteriaBuilder();
       CriteriaQuery<Veiculo> query = builder.createQuery(Veiculo.class);
       
       Root<Veiculo>  root = query.from(Veiculo.class);
       query.where(builder.equal(root.get("codMarca"), id));
       query.orderBy(builder.asc(root.get("nomeMarca")));
       return entityManager.createQuery(query).getResultList();
   }
}
