package com.sda.dao;

import com.sda.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDao<T> {
    public void createEntity(T entity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
    }

    public T getEntityById(Long id, Class<T> aClass) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        T newEntity = session.get(aClass, id);
        transaction.commit();
        session.close();
        return newEntity;
    }

    public void updateEntity(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    public void deleteEntity(T entity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }
}
