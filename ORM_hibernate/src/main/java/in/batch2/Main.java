package in.batch2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.security.auth.login.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1,"Ajay","SOT");

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        persists(s1);//it is present inside the session

    }
}
