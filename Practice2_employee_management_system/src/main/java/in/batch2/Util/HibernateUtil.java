package in.batch2.Util;

import in.batch2.model.Course;
import in.batch2.model.Department;
import in.batch2.model.Enrollment;
import in.batch2.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
//    Hibernate ka database connection setup provide karta hai


//    Hibernate ko batata hai ki Student entity ko map karna hai

    private static final SessionFactory sessionFactory =
            new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Enrollment.class)
                    .addAnnotatedClass(Department.class)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Course.class)
                    .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown(){
        sessionFactory.close();
    }
}
