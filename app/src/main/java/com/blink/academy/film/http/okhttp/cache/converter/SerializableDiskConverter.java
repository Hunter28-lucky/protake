package com.blink.academy.film.http.okhttp.cache.converter;

import com.blink.academy.film.http.okhttp.utils.Utils;
import defpackage.C4638;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class SerializableDiskConverter implements IDiskConverter {
    @Override // com.blink.academy.film.http.okhttp.cache.converter.IDiskConverter
    public <T> T load(InputStream inputStream, Type type) throws Throwable {
        ObjectInputStream objectInputStream;
        Closeable closeable = (T) null;
        try {
            try {
                objectInputStream = new ObjectInputStream(inputStream);
            } catch (IOException e2) {
                e = e2;
                objectInputStream = null;
                C4638.m14100(e);
                Utils.close(objectInputStream);
                return (T) closeable;
            } catch (ClassNotFoundException e3) {
                e = e3;
                objectInputStream = null;
                C4638.m14100(e);
                Utils.close(objectInputStream);
                return (T) closeable;
            } catch (Throwable th) {
                th = th;
                Utils.close(closeable);
                throw th;
            }
            try {
                closeable = (T) objectInputStream.readObject();
            } catch (IOException e4) {
                e = e4;
                C4638.m14100(e);
                Utils.close(objectInputStream);
                return (T) closeable;
            } catch (ClassNotFoundException e5) {
                e = e5;
                C4638.m14100(e);
                Utils.close(objectInputStream);
                return (T) closeable;
            }
            Utils.close(objectInputStream);
            return (T) closeable;
        } catch (Throwable th2) {
            th = th2;
            closeable = (T) objectInputStream;
            Utils.close(closeable);
            throw th;
        }
    }

    @Override // com.blink.academy.film.http.okhttp.cache.converter.IDiskConverter
    public boolean writer(OutputStream outputStream, Object obj) throws Throwable {
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(outputStream);
                try {
                    objectOutputStream2.writeObject(obj);
                    objectOutputStream2.flush();
                    Utils.close(objectOutputStream2);
                    return true;
                } catch (IOException e2) {
                    e = e2;
                    objectOutputStream = objectOutputStream2;
                    C4638.m14100(e);
                    Utils.close(objectOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    Utils.close(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
        }
    }
}
