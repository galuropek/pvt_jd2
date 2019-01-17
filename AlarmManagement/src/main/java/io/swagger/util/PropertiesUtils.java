package io.swagger.util;

import org.threeten.bp.OffsetDateTime;

public class PropertiesUtils {

    public static String copyStringProperties(String oldValue, String newValue) {
        if (newValue != null && !newValue.equals("string"))
            return newValue;
        else
            return oldValue;
    }

    public static OffsetDateTime copyOffsetDateTimeProperties(OffsetDateTime oldValue, OffsetDateTime newValue) {
        if (newValue != null)
            return newValue;
        else
            return oldValue;
    }
}
