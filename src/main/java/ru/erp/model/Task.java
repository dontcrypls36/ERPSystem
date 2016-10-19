package ru.erp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = Task.EXECUTOR_GET,
                query = "select t from Task t where t.executor.id=:executorId and t.id=:taskId"),
        @NamedQuery(name = Task.EXECUTOR_GET_ALL,
                query = "select t from Task t where t.executor.id=:id"),
        @NamedQuery(name = Task.EXECUTOR_GET_BY_STATUS,
                query = "select t from Task t where t.executor.id=:id and t.complete=:complete"),
        @NamedQuery(name = Task.EXECUTOR_GET_COMPLETE_BETWEEN,
                query = "select t from Task t where t.executor.id=:id and t.complete=true " +
                        "and t.completeDate between :startDate and :endDate order by t.createDate asc"),
        @NamedQuery(name = Task.EXECUTOR_GET_CREATE_BETWEEN,
                query = "select t from Task t where t.executor.id=:id " +
                        "and t.createDate between :startDate and :endDate order by t.createDate asc"),
        @NamedQuery(name = Task.OWNER_GET,
                query = "select t from Task t where t.owner.id=:ownerId and t.id=:taskId"),
        @NamedQuery(name = Task.OWNER_DELETE,
                query = "delete from Task t where t.owner.id=:ownerId and t.id=:taskId"),
        @NamedQuery(name = Task.OWNER_GET_ALL,
                query = "select t from Task t where t.owner.id=:id"),
        @NamedQuery(name = Task.OWNER_GET_BY_STATUS,
                query = "select t from Task t where t.owner.id=:id and t.complete=:complete"),
        @NamedQuery(name = Task.OWNER_GET_COMPLETE_BETWEEN,
                query = "select t from Task t where t.owner.id=:id and t.complete=true " +
                        "and t.completeDate between :startDate and :endDate order by t.createDate asc"),
        @NamedQuery(name = Task.OWNER_GET_CREATE_BETWEEN,
                query = "select t from Task t where t.owner.id=:id " +
                        "and t.createDate between :startDate and :endDate order by t.createDate asc")
})

@Entity
@Table(name = "tasks")
public class Task extends NamedEntity {

    public static final String EXECUTOR_GET = "Task.executorGet";
    public static final String EXECUTOR_GET_ALL = "Task.executorGetAll";
    public static final String EXECUTOR_GET_BY_STATUS = "Task.executorGetByStatus";
    public static final String EXECUTOR_GET_COMPLETE_BETWEEN = "Task.executorCompleteBetween";
    public static final String EXECUTOR_GET_CREATE_BETWEEN = "Task.executorCreateBetween";

    public static final String OWNER_GET = "Task.ownerGet";
    public static final String OWNER_DELETE = "Task.ownerDelete";
    public static final String OWNER_GET_ALL = "Task.ownerGetAll";
    public static final String OWNER_GET_BY_STATUS = "Task.ownerGetByUser";
    public static final String OWNER_GET_COMPLETE_BETWEEN = "Task.ownerCompleteBetween";
    public static final String OWNER_GET_CREATE_BETWEEN = "Task.ownerCreateBetween";


    @Column(name = "description")
    private String description;

    @Column(name = "complete")
    @NotEmpty
    private boolean complete;

    @ManyToOne
    @JoinColumn(name = "executor_id", nullable = false)
    private User executor;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(name = "date_time_create", nullable = false)
    @NotEmpty
    private LocalDateTime createDate;

    @Column(name = "date_time_complete", nullable = false)
    private LocalDateTime completeDate;

    public Task() {
    }

    public Task(int id, String name, String description, User owner, User executor) {
        super(id, name);
        this.description = description;
        this.owner = owner;
        this.createDate = LocalDateTime.now();
        this.executor = executor;
        this.complete = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public LocalDateTime getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(LocalDateTime completeDate) {
        this.completeDate = completeDate;
    }

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }
}
