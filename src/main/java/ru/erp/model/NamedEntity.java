package ru.erp.model;

public class NamedEntity extends BaseEntity{

    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public NamedEntity(int id, String name, String surname) {
        super(id);
        this.name = name;
        this.surname = surname;
    }
}
