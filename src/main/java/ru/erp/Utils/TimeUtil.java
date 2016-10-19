package ru.erp.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class TimeUtil {
    public static Date LDTtoDate(LocalDateTime ldt){
        return Date.from(ldt.toInstant(ZoneOffset.UTC));
    }
}
