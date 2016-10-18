package ru.erp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="tasks")
public class Task extends NamedEntity{

        @Column(name = "description")
        private String description;

        @Column(name = "complete")
        @NotEmpty
        private boolean complete;

        @ManyToOne
        @JoinColumn(name = "executor_id", nullable = false)
        private User executor;

        @ManyToOne
        @JoinColumn(name= "owner_id", nullable= false)
        private User owner;

        @Column(name = "date_time_create", nullable = false)
        @NotEmpty
        private Date createDate;

        @Column(name = "date_time_complete", nullable = false)
        @NotEmpty
        private Date completeDate;

        public Task(int id, String name, String description, User owner, User executor) {
            super(id, name);
            this.description = description;
            this.owner = owner;
            this.createDate = new Date();
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }
}
