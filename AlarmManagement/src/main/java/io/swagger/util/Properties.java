package io.swagger.util;

import java.util.List;

public class Properties<T> {

    public T copy(T oldValue, T newValue) {
        if (newValue != null)
            return newValue;
        else
            return oldValue;
    }
}
