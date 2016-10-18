package ru.erp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NamedEntity extends BaseEntity{

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    public NamedEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NamedEntity(int id, String name) {
        super(id);
        this.name = name;
    }
}
