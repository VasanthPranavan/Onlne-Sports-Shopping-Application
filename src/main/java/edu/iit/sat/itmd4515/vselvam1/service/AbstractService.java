/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.vselvam1.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vasanth Pranavan
 * @param <T>
 */
public abstract class AbstractService<T> {

    @PersistenceContext(name = "itmd4515PU")
    protected EntityManager em;

    protected final Class<T> entityClass;

    public AbstractService(Class entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        em.persist(entity);

    }

    public T find(Long id) {
        return em.find(entityClass, id);
    }

    public abstract List<T> findAll();

    public void update(T entity) {
        em.merge(entity);
    }

    public void delete(T entity) {
        em.remove(em.merge(entity));
    }

}