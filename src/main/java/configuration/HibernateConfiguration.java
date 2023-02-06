package configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfiguration {
    private static SessionFactory sessionFactory;
    private HibernateConfiguration() throws IllegalAccessException {
        throw new IllegalAccessException("This class does not need to be instantiated");
    }
    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null || sessionFactory.isClosed()){
            buildSessionFactory();
        }
        return sessionFactory;
    }

    private static void buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

}
