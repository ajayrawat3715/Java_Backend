package in.batch2.EmployeeDAO;

import in.batch2.HibernateUtil.HibernateUtil;
import in.batch2.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAO {

    public List<Employee> findAll(){
         try(Session session =
                     HibernateUtil.getSessionFactory().openSession()){
             return session.createQuery(
                     "from Employee order by id",
                     Employee.class
             ).list();
         }catch(Exception e){
             throw e;
         }
    }

    public Employee findById(Long id){
        try(Session session =
                HibernateUtil.getSessionFactory().openSession()){
            return session.find(Employee.class,id);
        } catch (Exception e) {
            throw e;
        }
    }

    public void create(Employee employee){
        try(Session session =
                    HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            try{
                if (employee == null) {
                    return;
                }
            session.persist(employee);
            transaction.commit();
           }catch(Exception e){
                transaction.rollback();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Long id){
        try(Session session =
                    HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try{
                Employee employee = session.find(Employee.class,id);
                if(employee==null) return;
                session.remove(employee);
                transaction.commit();
            }catch(Exception e){
                transaction.rollback();
                throw e;
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void update(Employee employee){
        try(Session session =
                    HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try{
                if(employee == null) return;
                session.merge(employee);
                transaction.commit();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
