package ru.erp.repository;

import ru.erp.model.Task;

import java.time.LocalDateTime;
import java.util.Collection;

public interface ManagerTaskRepository {
    Task save(Task t, int ownerId);

    boolean delete(int taskId, int ownerId);

    Task get(int taskId, int ownerId);

    Collection<Task> getAll(int ownerId);

    Collection<Task> getAllUserTask(int userId, int ownerId);

    Collection<Task> getAllTaskByStatus(boolean complete, int ownerId);

    Collection<Task> getAllTaskCreateBetween(LocalDateTime startTime, LocalDateTime endTime, int ownerId);

    Collection<Task> getAllTaskCompleteBetween(LocalDateTime startTime, LocalDateTime endTime, int ownerId);
}
