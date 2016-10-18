package ru.erp.repository;

import ru.erp.model.User;

import java.util.Collection;

public interface UserRepository {

    User save(User u);

    boolean delete(int userId);

    User get(int userId);

    Collection<User> getAll();

    Collection<User> getByDepartment(String department);

}
