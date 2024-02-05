package edu.examples.java_classes.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
private static final SimpleDateFormat FORMATER = new SimpleDateFormat();
    
    static {
        FORMATER.applyPattern("yyyy-MM-dd");
    }
    
    public static String toString(Date date){
        return FORMATER.format(date);
    }
    
    public static Date toDate(String dateStr) throws ParseException {
        return FORMATER.parse(dateStr);
    }
}
