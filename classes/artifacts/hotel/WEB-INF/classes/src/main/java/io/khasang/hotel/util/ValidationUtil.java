package io.khasang.hotel.util;

import io.khasang.hotel.util.exception.NotFoundException;

public class ValidationUtil {
    private ValidationUtil() {
    }

    public static <T> T checkNotFoundWithId(T object, Long id) {
        return checkNotFound(object, "id=" + id);
    }

    public static <T> T checkNotFound(T object, String msg) {
        if (object == null) {
            throw new NotFoundException("Not found entity with " + msg);
        }
        return object;
    }
}
