package ru.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.erp.model.User;
import ru.erp.repository.UserRepository;
import ru.erp.utils.Exceptions.ExceptionUtils;

import javax.faces.bean.ManagedBean;
import java.util.Collection;
import java.util.Objects;

@Component
@Service
@ManagedBean(name = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    public User save(User u) {
        return repository.save(u);
    }

    public void delete(int userId) {
        ExceptionUtils.checkNotFoundWithId(repository.delete(userId), userId);
    }

    public User get(int userId) {
        return ExceptionUtils.checkNotFoundWithId(repository.get(userId), userId);
    }

    public Collection<User> getAll() {
        return repository.getAll();
    }

    public Collection<User> getByDepartment(String department) {
        Objects.requireNonNull(department);
        return repository.getByDepartment(department);
    }
}
