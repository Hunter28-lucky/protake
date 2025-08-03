package com.blink.academy.film.http.okhttp.cache.converter;

import com.blink.academy.film.http.okhttp.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import defpackage.C4638;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class GsonDiskConverter implements IDiskConverter {
    private Gson gson;

    public GsonDiskConverter() {
        this.gson = new Gson();
        this.gson = new Gson();
    }

    @Override // com.blink.academy.film.http.okhttp.cache.converter.IDiskConverter
    public <T> T load(InputStream inputStream, Type type) {
        try {
            try {
                return this.gson.getAdapter(TypeToken.get(type)).read2(this.gson.newJsonReader(new InputStreamReader(inputStream)));
            } catch (Exception e2) {
                C4638.m14100(e2.getMessage());
                Utils.close(inputStream);
                return null;
            }
        } finally {
            Utils.close(inputStream);
        }
    }

    @Override // com.blink.academy.film.http.okhttp.cache.converter.IDiskConverter
    public boolean writer(OutputStream outputStream, Object obj) {
        try {
            byte[] bytes = this.gson.toJson(obj).getBytes();
            outputStream.write(bytes, 0, bytes.length);
            outputStream.flush();
            return true;
        } catch (Exception e2) {
            C4638.m14100(e2.getMessage());
            return false;
        } finally {
            Utils.close(outputStream);
        }
    }

    public GsonDiskConverter(Gson gson) {
        this.gson = new Gson();
        Utils.checkNotNull(gson, "gson ==null");
        this.gson = gson;
    }
}
