package ru.erp.repository;

import ru.erp.model.Task;

import java.time.LocalDateTime;
import java.util.Collection;

public interface UserTaskRepository {

    void update(Task t);

    Task get(int id, int executorId);

    Collection<Task> getAll(int executorId);

    Collection<Task> getAllByCompleteStatus(boolean completeStatus, int executorId);

    Collection<Task> getAllCreateBetween(LocalDateTime startDate, LocalDateTime endDate, int executorId);

    Collection<Task> getAllCompleteBetween(LocalDateTime startDate, LocalDateTime endDate, int executorId);
}
