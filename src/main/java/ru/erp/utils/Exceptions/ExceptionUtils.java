package ru.erp.utils.Exceptions;

public class ExceptionUtils {

    public static void checkNotFound(boolean found, String msg){
        if (!found){
            throw new NotFoundException(msg);
        }
    }

    public static <T> T checkNotFound(T object, String msg){
        checkNotFound(object != null, msg);
        return object;
    }

    public static void checkNotFoundWithId(boolean found, int id){
        checkNotFound(found, "id= " + id);
    }

    public static <T> T checkNotFoundWithId(T object, int id){
        checkNotFound(object != null, "id= " + id);
        return object;
    }
}


