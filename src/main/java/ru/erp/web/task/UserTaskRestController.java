package ru.erp.web.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import ru.erp.AuthorizedUser;
import ru.erp.model.Task;
import ru.erp.model.User;
import ru.erp.service.UserTaskService;

import java.time.LocalDateTime;
import java.util.Collection;

@Controller
public class UserTaskRestController {
    public static final Logger LOG = LoggerFactory.getLogger(User.class);

    private UserTaskService service;

    public Task update(Task t){
        int userId = AuthorizedUser.id();
        LOG.info("update Task {} by executor {}", t.getId(), userId);
        return service.update(t, userId);
    }

    public Task get(int id){
        int userId = AuthorizedUser.id();
        LOG.info("get Task {} by executor {}", id, userId);
        return service.get(id, userId);
    }

    public Collection<Task> getAll(){
        int userId = AuthorizedUser.id();
        LOG.info("get all tasks by executor {}", userId);
        return service.getAll(userId);
    }

    public Collection<Task> getAllByCompleteStatus(boolean completeStatus){
        int userId = AuthorizedUser.id();
        LOG.info("get all tasks by complete status {} by executor {}", completeStatus, userId);
        return service.getAllByCompleteStatus(completeStatus, userId);
    }

    public Collection<Task> getAllCreateBetween(LocalDateTime startDate, LocalDateTime endDate){
        int userId = AuthorizedUser.id();
        LOG.info("get all tasks create between {} and {} by executor {}", startDate, endDate, userId);
        return service.getAllCreateBetween(startDate, endDate, userId);
    }

    public Collection<Task> getAllCompleteBetween(LocalDateTime startDate, LocalDateTime endDate){
        int userId = AuthorizedUser.id();
        LOG.info("get all tasks complete between {} and {} by executor {}", startDate, endDate, userId);
        return service.getAllCompleteBetween(startDate, endDate, userId);
    }


}
