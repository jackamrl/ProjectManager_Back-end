package com.mycompany.projectmanager.dao.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.projectmanager.dao.GenericDAO;
import com.mycompany.projectmanager.entities.EntityItem;
import java.io.Serializable;

/**
 *
 * @author fgotl
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @PersistenceContext //(unitName = "tttPU")
    protected EntityManager em;
    private final Class<T> type;

    public GenericDAOImpl(Class<T> type1) {
        this.type = type1;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public T find(ID id) {
        return (T) em.find(type, id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void persist(T o) {
        em.persist(o);
        em.flush();
        if (o instanceof EntityItem) {
            EntityItem<ID> item = (EntityItem<ID>) o;
            ID id = item.getId();
            logger.info("The " + o.getClass().getName() + "record with ID=" + id + " has been inserted");
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public T merge(T o) {
        o = em.merge(o);
        em.flush();
        return o;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void remove(T o) {
        o = merge(o);
        em.remove(o);
    }

}
