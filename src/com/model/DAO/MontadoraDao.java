/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.DAO;

import com.model.entidades.Montadora;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Marcel
 */
public class MontadoraDao extends GenericDao<Montadora, Long>{

    public MontadoraDao() {
        super(Montadora.class);
    }
    
    @Override
     public List<Montadora> getList() {
       CriteriaBuilder builder = entityManager.getCriteriaBuilder();
       CriteriaQuery<Montadora> query = builder.createQuery(Montadora.class);
       Root<Montadora>  root = query.from(Montadora.class);
       query.orderBy(builder.asc(root.get("nomeMarca")));
       return entityManager.createQuery(query).getResultList();
   }
}
