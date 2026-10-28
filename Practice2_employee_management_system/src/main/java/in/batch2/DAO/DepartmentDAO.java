package in.batch2.DAO;

import in.batch2.Util.HibernateUtil;
import in.batch2.model.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartmentDAO {

    // 1. Department save karna
    public static void save(Department department) {
        Transaction tx = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();
            session.persist(department);
            tx.commit();

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    // 2. Department update karna
    public static void update(Department department) {
        Transaction tx = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();
            session.merge(department);
            tx.commit();

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    // 3. ID se department find karna
    public static Department findById(int id) {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Department.class, id);

        }
    }

    // 4. Department delete karna
    public static void delete(int id) {
        Transaction tx = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Department department =
                    session.get(Department.class, id);

            if (department != null) {
                session.remove(department);
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