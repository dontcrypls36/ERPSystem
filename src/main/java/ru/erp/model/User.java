package ru.erp.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class User extends NamedEntity {

    private String department;

    private String position;

    private String login;

    private String password;

    private Date registered;

    private Set<Role> roles;

    private List<Task> taskList;

    public User(int id, String name, String surname, String department,
                String position, String login, String password) {
        super(id, name, surname);
        this.department = department;
        this.position = position;
        this.login = login;
        this.password = password;
        this.registered = new Date();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

}
