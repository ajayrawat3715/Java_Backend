package in.batch2.DAO;

import in.batch2.Util.HibernateUtil;
import in.batch2.model.Course;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CourseDAO {

    // 1. Course save karna
    public static void save(Course course) {
        Transaction tx = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.persist(course);

            tx.commit();

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    // 2. ID se course find karna
    public static Course findById(int id) {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Course.class, id);

        }
    }

    // 3. Saare courses fetch karna
    public static List<Course> findAll() {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            return session
                    .createQuery("FROM Course", Course.class)
                    .getResultList();

        }
    }

    // 4. Course update karna
    public static void update(Course course) {
        Transaction tx = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.merge(course);

            tx.commit();

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    // 5. ID se course delete karna
    public static void delete(int id) {
        Transaction tx = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Course course = session.get(Course.class, id);

            if (course != null) {
                session.remove(course);
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }
}