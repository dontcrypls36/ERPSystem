package ru.erp.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.erp.model.Task;
import ru.erp.utils.TimeUtil;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserTaskRepositoryImpl implements UserTaskRepository{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Task get(int id, int executorId) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery(Task.EXECUTOR_GET)
                .setInteger("taskId", id)
                .setInteger("executorId", executorId);
        return (Task) query.list().get(0);
    }

    public List<Task> getAll(int executorId) {
        Session session = sessionFactory.openSession();
        List<Task> tasks = session.getNamedQuery(Task.EXECUTOR_GET_ALL)
                                .setInteger("executorId", executorId)
                                .list();
        session.close();
        return tasks;
    }

    public List<Task> getAllByCompleteStatus(boolean completeStatus, int executorId) {
        Session session = sessionFactory.openSession();
        List<Task> tasks = session.getNamedQuery(Task.EXECUTOR_GET_BY_STATUS)
                                .setBoolean("complete", completeStatus)
                                .setInteger("executorId", executorId)
                                .list();
        session.close();
        return tasks;
    }

    public List<Task> getAllCreateBetween(LocalDateTime startDate, LocalDateTime endDate, int executorId) {
        Session session = sessionFactory.openSession();
        List<Task> tasks = session.getNamedQuery(Task.EXECUTOR_GET_CREATE_BETWEEN)
                .setTimestamp("startDate", TimeUtil.LDTtoDate(startDate))
                .setDate("endDate", TimeUtil.LDTtoDate(endDate))
                .setInteger("executorId", executorId)
                .list();
        session.close();
        return tasks;
    }

    public List<Task> getAllCompleteBetween(LocalDateTime startDate, LocalDateTime endDate, int executorId) {
        Session session = sessionFactory.openSession();
        List<Task> tasks = session.getNamedQuery(Task.EXECUTOR_GET_COMPLETE_BETWEEN)
                .setTimestamp("startDate", TimeUtil.LDTtoDate(startDate))
                .setTimestamp("endDate", TimeUtil.LDTtoDate(endDate))
                .setInteger("executorId", executorId)
                .list();
        session.close();
        return tasks;
    }

    public Task update(Task t, int executorId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        boolean result = session.getNamedQuery(Task.EXECUTOR_UPDATE)
                .setInteger("taskId", t.getId())
                .setInteger("executorId", executorId)
                .executeUpdate() > 0;
        session.getTransaction().commit();
        session.close();
        return result? t : null;
    }
}
