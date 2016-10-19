package ru.erp.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.erp.model.Task;

import java.time.LocalDateTime;
import java.util.Collection;


@Repository
public class ManagerTaskRepositoryImpl implements ManagerTaskRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Task save(Task t, int ownerId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(t);
        session.getTransaction().commit();
        session.close();
        return null;
    }

    public boolean delete(int taskId, int ownerId) {
        return false;
    }

    public Task get(int taskId, int ownerId) {
        return null;
    }

    public Collection<Task> getAll(int ownerId) {
        return null;
    }

    public Collection<Task> getAllUserTask(int userId, int ownerId) {
        return null;
    }

    public Collection<Task> getAllTaskByStatus(boolean complete, int ownerId) {
        return null;
    }

    public Collection<Task> getAllTaskCreateBetween(LocalDateTime startTime, LocalDateTime endTime, int ownerId) {
        return null;
    }

    public Collection<Task> getAllTaskCompleteBetween(LocalDateTime startTime, LocalDateTime endTime, int ownerId) {
        return null;
    }
}
