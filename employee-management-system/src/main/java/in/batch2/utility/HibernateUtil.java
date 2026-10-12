package in.batch2.utility;

import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            //return new Configuration().configure().buildSessionFactory();
        }

        return sessionFactory;
    }
    public static void closeSessionFactory(){
        if(sessionFactory ==null){
            return;
        }
        sessionFactory.close();
        sessionFactory=null;
    }
}
