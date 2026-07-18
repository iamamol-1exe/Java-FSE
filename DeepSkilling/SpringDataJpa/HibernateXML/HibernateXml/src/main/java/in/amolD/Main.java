package in.amolD;

import in.amolD.model.Employee;
import in.amolD.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.TimeZone;

class Main{
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata "));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee emp = new Employee();

        emp.setName("Amol");
        emp.setDept("IT");
        emp.setSalary(60000);

        session.save(emp);

        transaction.commit();

        session.close();
    }
}
