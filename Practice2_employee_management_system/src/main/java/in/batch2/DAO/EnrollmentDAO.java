package in.batch2.DAO;

import in.batch2.Util.HibernateUtil;
import in.batch2.model.Enrollment;

import jakarta.persistence.Id;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EnrollmentDAO {

    // 1. Enrollment save karna
    public void save(Enrollment enrollment) {
        Transaction tx = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.persist(enrollment);

            tx.commit();

        } catch (Exception ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            ex.printStackTrace();
        }
    }

    // 2. Saare enrollments fetch karna
    public List<Enrollment> getAllEnrollments() {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            return session
                    .createQuery("FROM Enrollment", Enrollment.class)
                    .getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
            return List.of();
        }
    }

    // 3. ID se enrollment find karna
    public Enrollment getEnrollmentById(int enrollmentId) {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Enrollment.class, enrollmentId);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // 4. ID se enrollment delete karna
    public void delete(int enrollmentId) {
        Transaction tx = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Enrollment enrollment =
                    session.get(Enrollment.class, enrollmentId);

            if (enrollment != null) {
                session.remove(enrollment);
            }

            tx.commit();

        } catch (Exception ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            ex.printStackTrace();
        }
    }
}