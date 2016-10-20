package ru.erp;

import ru.erp.model.BaseEntity;

public class AuthorizedUser {

    private static int id = BaseEntity.START_SEQ;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }
}
