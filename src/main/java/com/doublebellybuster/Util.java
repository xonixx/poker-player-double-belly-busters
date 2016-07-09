package com.doublebellybuster;

import com.google.gson.Gson;

public final class Util {

    private static final Gson gson = new Gson();

    public static <T> T parse(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    private Util() {
    }
}
