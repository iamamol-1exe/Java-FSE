package in.amolD;


import in.amolD.model.Country;
import in.amolD.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Time;
import java.util.TimeZone;

class Main{
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        Country country = new Country();
        country.setCode("IN");
        country.setName("India");

        Transaction tx = session.beginTransaction();

        session.persist(country);

        tx.commit();
        session.close();

        sessionFactory.close();
    }
}