package ru.erp.repository;

import ru.erp.model.Task;

import java.time.LocalDateTime;
import java.util.Collection;

public interface UserTaskRepository {

    Task save(Task t, int executorId);

    //boolean delete(Task t, int executorId);

    Task get(int id, int executorId);

    Collection<Task> getAll(int executorId);

    Collection<Task> getAllByCompleteStatus(boolean completeStatus, int executorId);

    Collection<Task> getAllCreateBetween(LocalDateTime startTime, LocalDateTime endTime, int executorId);

    Collection<Task> getAllCompleteBetween(LocalDateTime startTime, LocalDateTime endTime, int executorId);
}
