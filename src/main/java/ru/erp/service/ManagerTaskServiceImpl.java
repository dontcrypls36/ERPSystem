package ru.erp.service;

import org.springframework.stereotype.Service;
import ru.erp.model.Task;
import ru.erp.repository.ManagerTaskRepository;
import ru.erp.utils.Exceptions.ExceptionUtils;

import javax.faces.bean.ManagedBean;
import java.time.LocalDateTime;
import java.util.Collection;


@Service
@ManagedBean(name = "managerTaskService")
public class ManagerTaskServiceImpl implements ManagerTaskService {

    private ManagerTaskRepository repository;

    public Task save(Task t, int ownerId) {
        return ExceptionUtils.checkNotFoundWithId(repository.save(t, ownerId), t.getId());
    }

    public void delete(int taskId, int ownerId) {
        ExceptionUtils.checkNotFoundWithId(repository.delete(taskId, ownerId), taskId);
    }

    public Task get(int taskId, int ownerId) {
        return ExceptionUtils.checkNotFoundWithId(repository.get(taskId, ownerId), taskId);
    }

    public Collection<Task> getAll(int ownerId) {
        return repository.getAll(ownerId);
    }

    public Collection<Task> getAllUserTask(int executorId, int ownerId) {
        return repository.getAllUserTask(executorId, ownerId);
    }

    public Collection<Task> getAllTaskByStatus(boolean complete, int ownerId) {
        return repository.getAllTaskByStatus(complete, ownerId);
    }

    public Collection<Task> getAllTaskCreateBetween(LocalDateTime startDate, LocalDateTime endDate, int ownerId) {
        return repository.getAllTaskCreateBetween(startDate, endDate, ownerId);
    }

    public Collection<Task> getAllTaskCompleteBetween(LocalDateTime startDate, LocalDateTime endDate, int ownerId) {
        return repository.getAllTaskCompleteBetween(startDate, endDate, ownerId);
    }
}
