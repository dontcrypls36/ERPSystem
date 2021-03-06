package ru.erp.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;


@NamedQueries({
        @NamedQuery(name = User.DELETE,
                query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.GET_ALL_SORTED,
                query = "SELECT u FROM User u LEFT JOIN u.roles ORDER BY u.surname ASC"),
        @NamedQuery(name = User.GET_ALL_BY_DEPARTMENT,
                query = "SELECT u from User u LEFT JOIN u.roles WHERE u.department=:department ORDER BY u.surname asc"),
        @NamedQuery(name = User.GET_USER,
                query = "select u from User u LEFT JOIN u.roles where u.id=:id")
})

@ManagedBean(name = "user")
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
public class User extends NamedEntity implements Serializable{

    public static final String DELETE = "User.delete";
    public static final String GET_ALL_SORTED = "User.getAll";
    public static final String GET_ALL_BY_DEPARTMENT = "User.getByDepartment";
    public static final String GET_USER = "User.get";

    @Column(name = "surname")
    @NotBlank
    public String surname;

    @Column(name = "email", unique = true)
    @Email
    private String email;

    @Column(name = "department")
    @NotBlank
    private String department;

    @Column(name = "position")
    @NotBlank
    private String position;

    @Column(name = "login")
    @NotBlank
    private String login;

    @Column(name = "password")
    @Length(min = 5)
    private String password;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    private Date registered = new Date();

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<Role> roles;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "executor")
    @OrderBy("createDate ASC")
    private List<Task> taskList;

    public User() {

    }

    public User(int id, String name, String surname, String email, String department,
                String position, String login, String password) {
        super(id, name);
        this.surname = surname;
        this.email = email;
        this.department = department;
        this.position = position;
        this.login = login;
        this.password = password;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
