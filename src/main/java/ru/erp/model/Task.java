package ru.erp.model;

import java.util.Date;

public class Task extends BaseEntity{

        private String name;

        private String description;

        private boolean complete;

        private User executor;

        private User owner;

        private Date createDate;

        private Date completeDate;

        public Task(int id, String name, String description, User owner, User executor) {
            super(id);
            this.name = name;
            this.description = description;
            this.owner = owner;
            this.createDate = new Date();
            this.executor = executor;
            this.complete = false;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
