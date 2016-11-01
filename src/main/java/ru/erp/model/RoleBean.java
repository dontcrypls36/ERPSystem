package ru.erp.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class RoleBean {
    public Role[] getRoleValues(){
        return Role.values();
    }
}
