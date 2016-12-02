/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.DAO;

import com.model.entidades.Modelo;
import com.model.entidades.Montadora;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Marcel
 */
public class ModeloDao extends GenericDao<Modelo, Long>{

    public ModeloDao(Class<Modelo> persistedClass) {
        super(Modelo.class);
    }
    
   
}
