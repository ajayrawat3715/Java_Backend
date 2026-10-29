package in.batch2.Utility;

import in.batch2.model.Course;
import in.batch2.model.Department;
import in.batch2.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory = new Configuration().configure()
            .addAnnotatedClass(Department.class)
            .addAnnotatedClass(Student.class)
            .addAnnotatedClass(Course.class)
            .addAnnotatedClass(Enrollment.class)
            .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutDown(){
        sessionFactory.close();
    }
}
