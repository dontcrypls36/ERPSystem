package ru.erp.repository;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.erp.model.User;

import java.util.Collection;

@Repository
//@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        try{
            return sessionFactory.getCurrentSession();
        }
        catch (HibernateException e){
            return sessionFactory.openSession();
        }
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User save(User u) {
        Session session = getSession();
        session.beginTransaction();
        if (u.isNew()){
            session.persist(u);
       }
        else{
            session.merge(u);
        }
        session.getTransaction().commit();
        session.close();
        return u;
    }

//    @Transactional
    public boolean delete(int userId) {
        Session session = getSession();
        session.beginTransaction();
        Query query = session.getNamedQuery(User.DELETE).setInteger("id", userId);
        boolean result = query.executeUpdate() > 0;
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public User get(int userId) {
        Session session = getSession();
        User user = (User) session.get(User.class, userId);
        session.close();
        return user;
    }

    public Collection<User> getAll() {
        Session session = getSession();
        Query query = session.getNamedQuery(User.GET_ALL_SORTED);
        return (Collection<User>) query.list();
    }

    public Collection<User> getByDepartment(String department) {
        Session session = getSession();
        Query query = session.getNamedQuery(User.GET_ALL_BY_DEPARTMENT)
                .setString("department", department);
        return query.list();
    }
}
