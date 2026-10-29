package in.batch2.dao;

import in.batch2.utility.HibernateUtil;
import in.batch2.model.Project;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {


    public void save(Project project) {
        Transaction tx = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.persist(project);

            tx.commit();

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }


    public Project findById(int id) {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            return session.getById(Student.class, id);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<Project> findAll() {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            return session
                    .createQuery("FROM Project", Project.class)
                    .getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    // 4. Student update karna
    public void update(Project project) {
        Transaction tx = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.merge(project);

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

            Project project = session.get(Project.class, id);

            if (project != null) {
                session.remove(project);
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