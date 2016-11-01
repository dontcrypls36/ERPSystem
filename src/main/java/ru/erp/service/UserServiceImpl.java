package ru.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.erp.model.User;
import ru.erp.repository.UserRepository;
import ru.erp.utils.Exceptions.ExceptionUtils;

import java.util.Collection;
import java.util.Objects;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

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
        return repository == null? null : repository.getAll();
    }

    public Collection<User> getByDepartment(String department) {
        Objects.requireNonNull(department);
        return repository.getByDepartment(department);
    }
}
