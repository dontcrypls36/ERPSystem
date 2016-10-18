package ru.erp.repository;

import org.springframework.stereotype.Repository;
import ru.erp.model.Task;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public class UserTaskRepositoryImpl implements UserTaskRepository{

    public Task save(Task t, int executorId) {
        return null;
    }

    public boolean delete(Task t, int executorId) {
        return false;
    }

    public Task get(int id, int executorId) {
        return null;
    }

    public Collection<Task> getAll(int executorId) {
        return null;
    }

    public Collection<Task> getAllByCompleteStatus(boolean completeStatus, int executorId) {
        return null;
    }

    public Collection<Task> getAllCreateBetween(LocalDateTime startTime, LocalDateTime endTime, int executorId) {
        return null;
    }

    public Collection<Task> getAllCompleteBetween(LocalDateTime startTime, LocalDateTime endTime, int executorId) {
        return null;
    }
}
