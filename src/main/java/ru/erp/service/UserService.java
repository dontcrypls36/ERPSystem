package ru.erp.service;

import ru.erp.model.User;

import java.util.Collection;

public interface UserService {

    User save(User u);

    void delete(int userId);

    User get(int userId);

    Collection<User> getAll();

    Collection<User> getByDepartment(String department);
}
