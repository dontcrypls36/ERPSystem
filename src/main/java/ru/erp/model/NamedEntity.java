package ru.erp.model;

public class NamedEntity extends BaseEntity{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NamedEntity(int id, String name, String surname) {
        super(id);
        this.name = name;
    }
}
