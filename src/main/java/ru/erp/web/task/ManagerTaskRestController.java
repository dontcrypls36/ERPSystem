package ru.erp.web.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import ru.erp.AuthorizedUser;
import ru.erp.model.Task;
import ru.erp.service.ManagerTaskService;

import java.time.LocalDateTime;
import java.util.Collection;

@Controller
public class ManagerTaskRestController {

    public static final Logger LOG = LoggerFactory.getLogger(Task.class);

    private ManagerTaskService service;

    public Task save(Task t){
        int userId = AuthorizedUser.id();
        LOG.info("save task {} by owner {}", t.getId(), userId);
        return service.save(t, userId);
    }

    public void delete(int taskId){
        int userId = AuthorizedUser.id();
        LOG.info("delete task {} by owner {}", taskId, userId);
        service.delete(taskId, userId);
    }

    public Task get(int taskId){
        int userId = AuthorizedUser.id();
        LOG.info("get task {} by owner {}", taskId, userId);
        return service.get(taskId, userId);
    }

    public Collection<Task> getAll(){
        int userId = AuthorizedUser.id();
        LOG.info("gett all tasks by owner {}", userId);
        return service.getAll(userId);
    }

    public Collection<Task> getAllUserTask(int executorId){
        int userId = AuthorizedUser.id();
        LOG.info("get all user {} tasks by owner {}", executorId, userId);
        return service.getAllUserTask(executorId, userId);
    }

    public Collection<Task> getAllTaskByStatus(boolean complete){
        int userId = AuthorizedUser.id();
        LOG.info("get all tasks by status {} by owner {}", complete, userId);
        return service.getAllTaskByStatus(complete, userId);
    }

    public Collection<Task> getAllTaskCreateBetween(LocalDateTime startDate, LocalDateTime endDate){
        int userId = AuthorizedUser.id();
        LOG.info("get all tasks create between {} and {} by owner {}", startDate, endDate, userId);
        return service.getAllTaskCreateBetween(startDate, endDate, userId);
    }

    public Collection<Task> getAllTaskCompleteBetween(LocalDateTime startDate, LocalDateTime endDate){
        int userId = AuthorizedUser.id();
        LOG.info("get all tasks complete between {} and {} by owner {}", startDate, endDate, userId);
        return service.getAllTaskCompleteBetween(startDate, endDate, userId);
    }
}
