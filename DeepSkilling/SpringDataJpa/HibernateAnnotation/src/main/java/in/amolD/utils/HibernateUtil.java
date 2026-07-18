package in.amolD.utils;

import in.amolD.model.Country;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            sessionFactory = new Configuration()
                                                .configure().addAnnotatedClass(Country.class)
                                                .buildSessionFactory();
        }

        return sessionFactory;
    }

}
