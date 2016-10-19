package ru.erp.service;

import ru.erp.model.Task;

import java.time.LocalDateTime;
import java.util.Collection;

public interface ManagerTaskService {

    Task save(Task t, int ownerId);

    void delete(int taskId, int ownerId);

    Task get(int taskId, int ownerId);

    Collection<Task> getAll(int ownerId);

    Collection<Task> getAllUserTask(int executorId, int ownerId);

    Collection<Task> getAllTaskByStatus(boolean complete, int ownerId);

    Collection<Task> getAllTaskCreateBetween(LocalDateTime startDate, LocalDateTime endDate, int ownerId);

    Collection<Task> getAllTaskCompleteBetween(LocalDateTime startDate, LocalDateTime endDate, int ownerId);
}
