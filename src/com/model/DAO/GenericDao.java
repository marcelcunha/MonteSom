/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.DAO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Marcel
 * @param <T> Entidade que será tratada por essa classe
 * @param <I> Tipo numérico que representa o código da 
 */
public abstract class GenericDao <T, I extends Serializable>{
    
   protected EntityManager entityManager;

   private Class<T> persistedClass;

   protected GenericDao() {
       
   }

   protected GenericDao(Class<T> persistedClass) {
       this.persistedClass = persistedClass;
       this.entityManager = getEntityManager();
   }
   
   protected EntityManager getEntityManager(){
       EntityManagerFactory f = Persistence.createEntityManagerFactory("MonteSomPU");
       return f.createEntityManager();
   }
   public T salvar( T entity) {
       EntityTransaction t = entityManager.getTransaction();
       t.begin();
       entityManager.persist(entity);
       entityManager.flush();
       t.commit();
       return entity;
   }

   public T atualizar( T entity) {
       EntityTransaction t = entityManager.getTransaction();
       t.begin();
       entityManager.merge(entity);
       entityManager.flush();
       t.commit();
       return entity;
   }

   public void remover(T entity) {
       EntityTransaction tx = entityManager.getTransaction();
       tx.begin();
       T mergedEntity = entityManager.merge(entity);
       entityManager.remove(mergedEntity);
       entityManager.flush();
       tx.commit();
   }
   
   /**
    * Retorna uma lista com todos elementos da tabela do banco de dados 
    * @return 
    */
   public List<T> getList() {
       CriteriaBuilder builder = entityManager.getCriteriaBuilder();
       CriteriaQuery<T> query = builder.createQuery(persistedClass);
       query.from(persistedClass);
       List<T> list = entityManager.createQuery(query).getResultList();
       
       return list;
   }

   public T encontrar(I id) {
       return entityManager.find(persistedClass, id);
   }
}

