package ru.erp.managedBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import ru.erp.model.User;
import ru.erp.service.UserService;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@ManagedBean(name = "userBean")
@Scope("session")
public class UserManagedBean implements Serializable {

    private String name;
    private String department;
    private int id;

    @Autowired
    private UserService userService;

    public Collection<User> getAll(){
        return new ArrayList<User>(userService.getAll());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
