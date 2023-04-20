package org.learn.hibernate.datasource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.learn.hibernate.domain.Employee;
import org.learn.hibernate.domain.Store;

public class DataSource {
    static SessionFactory SESSION_FACTORY = null;

    public static SessionFactory getSessionFactory() {
        if (SESSION_FACTORY != null) {
            return SESSION_FACTORY;
        } else {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Employee.class).addAnnotatedClass(Store.class);
            SESSION_FACTORY = configuration.buildSessionFactory();
            return SESSION_FACTORY;
        }
    }

    public static void closeSessionFactory(){
        if (SESSION_FACTORY != null){
            SESSION_FACTORY.close();
        }
    }
}

