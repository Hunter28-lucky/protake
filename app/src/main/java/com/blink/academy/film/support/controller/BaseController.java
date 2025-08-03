package com.blink.academy.film.support.controller;

import com.google.gson.JsonObject;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class BaseController {
    public static final String API_V = "/v1";
    public static final String API_V2 = "/v2";
    public static final String CLIENT_VERSION = "3";

    public static String getJsonStr(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return "";
        }
        Set<String> setKeySet = map.keySet();
        JsonObject jsonObject = new JsonObject();
        for (String str : setKeySet) {
            Object obj = map.get(str);
            if (obj instanceof String) {
                jsonObject.addProperty(str, (String) obj);
            } else if (obj instanceof Number) {
                jsonObject.addProperty(str, (Number) obj);
            } else if (obj instanceof Boolean) {
                jsonObject.addProperty(str, (Boolean) obj);
            } else if (obj instanceof Character) {
                jsonObject.addProperty(str, (Character) obj);
            } else {
                jsonObject.addProperty(str, "" + obj);
            }
        }
        return jsonObject.toString();
    }
}
