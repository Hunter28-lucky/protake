package com.blink.academy.film.http.okhttp.cache.converter;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public interface IDiskConverter {
    <T> T load(InputStream inputStream, Type type);

    boolean writer(OutputStream outputStream, Object obj);
}
