package com.ewaiter.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;

    private static void initSession() {
        registry = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources sources = new MetadataSources(registry);
        Metadata metadata = sources.getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public synchronized static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            initSession();
        }
        return sessionFactory;
    }

    public synchronized static void close(){
        if(sessionFactory != null){
            sessionFactory.close();
            sessionFactory = null;
            registry.close();
        }
    }

}
