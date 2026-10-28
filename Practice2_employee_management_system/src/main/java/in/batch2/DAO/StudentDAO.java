package in.batch2.DAO;

import in.batch2.Util.HibernateUtil;
import in.batch2.model.Student;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {

    // 1. Student ko database mein save karna
    public void save(Student student) {
        Transaction tx = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.persist(student);

            tx.commit();

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    // 2. ID se student find karna
    public Student findById(int id) {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            //return session.getById(Student.class, id);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 3. Saare students fetch karna
    public List<Student> findAll() {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            return session
                    .createQuery("FROM Student", Student.class)
                    .getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    // 4. Student update karna
    public void update(Student student) {
        Transaction tx = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.merge(student);

            tx.commit();

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    // 5. ID se student delete karna
    public void delete(int id) {
        Transaction tx = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Student student = session.get(Student.class, id);

            if (student != null) {
                session.remove(student);
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}