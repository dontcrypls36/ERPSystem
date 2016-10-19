package ru.erp.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.erp.model.Task;
import ru.erp.utils.TimeUtil;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public class ManagerTaskRepositoryImpl implements ManagerTaskRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Task save(Task t, int ownerId) {
        if (!t.isNew() && get(t.getId(), ownerId) == null){
            return null;
        }
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        if (t.isNew()){
            session.persist(t);
        }
        else{
            session.merge(t);
        }
        session.getTransaction().commit();
        session.close();
        return t;
    }

    public boolean delete(int taskId, int ownerId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        boolean result = session.getNamedQuery(Task.OWNER_DELETE)
                .setInteger("taskId", taskId)
                .setInteger("ownerId", ownerId)
                .executeUpdate() > 0;
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Task get(int taskId, int ownerId) {
        Session session = sessionFactory.openSession();
        Task task = (Task)session.getNamedQuery(Task.OWNER_GET)
                .setInteger("taskId", taskId)
                .setInteger("ownerId", ownerId)
                .uniqueResult();
        session.close();
        return task;
    }

    public List<Task> getAll(int ownerId) {
        Session session = sessionFactory.openSession();
        List<Task> tasks = session.getNamedQuery(Task.OWNER_GET_ALL)
                .setInteger("ownerId", ownerId)
                .list();
        session.close();
        return tasks;
    }

    public List<Task> getAllUserTask(int executorId, int ownerId) {
        Session session = sessionFactory.openSession();
        List<Task> tasks = session.getNamedQuery(Task.OWNER_GET_ALL_USER_TASKS)
                .setInteger("ownerId", ownerId)
                .setInteger("executorId", executorId)
                .list();
        session.close();
        return tasks;
    }

    public List<Task> getAllTaskByStatus(boolean complete, int ownerId) {
        Session session = sessionFactory.openSession();
        List<Task> tasks = session.getNamedQuery(Task.OWNER_GET_BY_STATUS)
                .setBoolean("complete", complete)
                .setInteger("ownerId", ownerId)
                .list();
        session.close();
        return tasks;
    }

    public List<Task> getAllTaskCreateBetween(LocalDateTime startDate, LocalDateTime endDate, int ownerId) {
        Session session = sessionFactory.openSession();
        List<Task> tasks = session.getNamedQuery(Task.OWNER_GET_CREATE_BETWEEN)
                .setDate("startDate", TimeUtil.LDTtoDate(startDate))
                .setDate("endDate", TimeUtil.LDTtoDate(endDate))
                .setInteger("ownerId", ownerId)
                .list();
        session.close();
        return tasks;
    }

    public List<Task> getAllTaskCompleteBetween(LocalDateTime startDate, LocalDateTime endDate, int ownerId) {
        Session session = sessionFactory.openSession();
        List<Task> tasks = session.getNamedQuery(Task.OWNER_GET_COMPLETE_BETWEEN)
                .setDate("startDate", TimeUtil.LDTtoDate(startDate))
                .setDate("endDate", TimeUtil.LDTtoDate(endDate))
                .setInteger("ownerId", ownerId)
                .list();
        session.close();
        return tasks;
    }
}
