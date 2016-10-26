package ru.erp.service;

import org.springframework.stereotype.Service;
import ru.erp.model.Task;
import ru.erp.repository.UserTaskRepository;
import ru.erp.utils.Exceptions.ExceptionUtils;

import javax.faces.bean.ManagedBean;
import java.time.LocalDateTime;
import java.util.Collection;

@Service
@ManagedBean(name = "userTaskService")
public class UserTaskServiceImpl implements UserTaskService {

    private UserTaskRepository repository;

    public Task update(Task t, int executorId) {
        return ExceptionUtils.checkNotFoundWithId(repository.update(t, executorId), t.getId());
    }

    public Task get(int id, int executorId) {
        return ExceptionUtils.checkNotFoundWithId(repository.get(id, executorId), id);
    }

    public Collection<Task> getAll(int executorId) {
        return repository.getAll(executorId);
    }

    public Collection<Task> getAllByCompleteStatus(boolean completeStatus, int executorId) {
        return repository.getAllByCompleteStatus(completeStatus, executorId);
    }

    public Collection<Task> getAllCreateBetween(LocalDateTime startDate, LocalDateTime endDate, int executorId) {
        return repository.getAllCreateBetween(startDate, endDate, executorId);
    }

    public Collection<Task> getAllCompleteBetween(LocalDateTime startDate, LocalDateTime endDate, int executorId) {
        return repository.getAllCompleteBetween(startDate, endDate, executorId);
    }
}
