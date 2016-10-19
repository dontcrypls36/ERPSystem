package ru.erp.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.erp.model.User;

import java.util.Collection;


@Repository
public class UserRepositoryImpl implements UserRepository{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User save(User u) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        if (u.isNew()){
            session.persist(u);
        }
        else{
            session.merge(u);
        }
        session.getTransaction().commit();
        return u;
    }

    public boolean delete(int userId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.getNamedQuery(User.DELETE).setInteger("id", userId);
        boolean result = query.executeUpdate() > 0;
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public User get(int userId) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, userId);
        session.close();
        return user;
    }

    public Collection<User> getAll() {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery(User.GET_ALL_SORTED);
        return query.list();
    }

    public Collection<User> getByDepartment(String department) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery(User.GET_ALL_BY_DEPARTMENT).setString("department", department);
        return query.list();
    }
}
