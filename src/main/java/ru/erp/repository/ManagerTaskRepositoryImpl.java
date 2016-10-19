package ru.erp.repository;

import ru.erp.model.Task;

import java.time.LocalDateTime;
import java.util.Collection;

public class ManagerTaskRepositoryImpl implements ManagerTaskRepository {

    public void update(Task t) {

    }

    public Task save(Task t, int ownerId) {
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
