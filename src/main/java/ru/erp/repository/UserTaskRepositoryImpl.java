package ru.erp.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.erp.utils.TimeUtil;
import ru.erp.model.Task;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public class UserTaskRepositoryImpl implements UserTaskRepository{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Task get(int id, int executorId) {
        Session session = sessionFactory.openSession();
        Query query = session.getNamedQuery(Task.EXECUTOR_GET).
                setInteger("taskId", id).setInteger("executorId", executorId);
        return (Task) query.list().get(0);
    }

    public Collection<Task> getAll(int executorId) {
        Session session = sessionFactory.openSession();
        return session.getNamedQuery(Task.EXECUTOR_GET_ALL)
                .setInteger("executorId", executorId).list();
    }

    public Collection<Task> getAllByCompleteStatus(boolean completeStatus, int executorId) {
        Session session = sessionFactory.openSession();
        return session.getNamedQuery(Task.EXECUTOR_GET_BY_STATUS)
                .setBoolean("complete", completeStatus)
                .setInteger("executorId", executorId).list();
    }

    public Collection<Task> getAllCreateBetween(LocalDateTime startDate, LocalDateTime endDate, int executorId) {
        Session session = sessionFactory.openSession();
        return session.getNamedQuery(Task.EXECUTOR_GET_CREATE_BETWEEN)
                .setTimestamp("startDate", TimeUtil.LDTtoDate(startDate))
                .setDate("endDate", TimeUtil.LDTtoDate(endDate))
                .setInteger("executorId", executorId).list();
    }

    public Collection<Task> getAllCompleteBetween(LocalDateTime startDate, LocalDateTime endDate, int executorId) {
        Session session = sessionFactory.openSession();
        return session.getNamedQuery(Task.EXECUTOR_GET_COMPLETE_BETWEEN)
                .setTimestamp("startDate", TimeUtil.LDTtoDate(startDate))
                .setTimestamp("endDate", TimeUtil.LDTtoDate(endDate))
                .setInteger("executorId", executorId).list();
    }

    public void update(Task t) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Task task = session.get(Task.class, t.getId());
        task.setComplete(t.isComplete());
        task.setCompleteDate(t.getCompleteDate());
        task.setDescription(t.getDescription());
        tr.commit();
        session.close();
    }
}
