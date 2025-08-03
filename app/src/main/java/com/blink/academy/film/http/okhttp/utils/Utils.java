package com.blink.academy.film.http.okhttp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import defpackage.AbstractC2613;
import defpackage.C2314;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class Utils {
    public static boolean checkMain() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeThrowException(closeable);
            } catch (IOException unused) {
            }
        }
    }

    public static void closeThrowException(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }

    public static AbstractC2613 createFile(String str) {
        checkNotNull(str, "name not null!");
        return AbstractC2613.create(C2314.m8683("multipart/form-data; charset=utf-8"), str);
    }

    public static AbstractC2613 createImage(File file) {
        checkNotNull(file, "file not null!");
        return AbstractC2613.create(C2314.m8683("image/jpg; charset=utf-8"), file);
    }

    public static AbstractC2613 createJson(String str) {
        checkNotNull(str, "json not null!");
        return AbstractC2613.create(C2314.m8683("application/json; charset=utf-8"), str);
    }

    public static <T> Type findNeedClass(Class<T> cls) {
        Type[] actualTypeArguments = ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments();
        Type type = actualTypeArguments[0];
        if (actualTypeArguments.length <= 1) {
            return type;
        }
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        throw new IllegalStateException("没有填写泛型参数");
    }

    public static <R> Type findNeedType(Class<R> cls) {
        List<Type> methodTypes = getMethodTypes(cls);
        return (methodTypes == null || methodTypes.isEmpty()) ? AbstractC2613.class : methodTypes.get(0);
    }

    public static <T> Type findRawType(Class<T> cls) {
        return getGenericType((ParameterizedType) cls.getGenericSuperclass(), 0);
    }

    public static Class getClass(Type type, int i) {
        return type instanceof ParameterizedType ? getGenericClass((ParameterizedType) type, i) : type instanceof TypeVariable ? getClass(((TypeVariable) type).getBounds()[0], 0) : (Class) type;
    }

    public static Class getGenericClass(ParameterizedType parameterizedType, int i) {
        Type type = parameterizedType.getActualTypeArguments()[i];
        return type instanceof ParameterizedType ? (Class) ((ParameterizedType) type).getRawType() : type instanceof GenericArrayType ? (Class) ((GenericArrayType) type).getGenericComponentType() : type instanceof TypeVariable ? getClass(((TypeVariable) type).getBounds()[0], 0) : (Class) type;
    }

    public static Type getGenericType(ParameterizedType parameterizedType, int i) {
        Type type = parameterizedType.getActualTypeArguments()[i];
        return type instanceof ParameterizedType ? ((ParameterizedType) type).getRawType() : type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : type instanceof TypeVariable ? getClass(((TypeVariable) type).getBounds()[0], 0) : type;
    }

    public static <T> List<Type> getMethodTypes(Class<T> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Type type : ((ParameterizedType) genericSuperclass).getActualTypeArguments()) {
            arrayList.add(type);
            if (type instanceof ParameterizedType) {
                Collections.addAll(arrayList, ((ParameterizedType) type).getActualTypeArguments());
            }
        }
        return arrayList;
    }

    public static Type getParameterizedType(Type type, int i) {
        return type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[i] : type instanceof TypeVariable ? getType(((TypeVariable) type).getBounds()[0], 0) : type;
    }

    public static Type getType(Type type, int i) {
        return type instanceof ParameterizedType ? getGenericType((ParameterizedType) type, i) : type instanceof TypeVariable ? getType(((TypeVariable) type).getBounds()[0], 0) : type;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true;
    }

    public static AbstractC2613 createFile(File file) {
        checkNotNull(file, "file not null!");
        return AbstractC2613.create(C2314.m8683("multipart/form-data; charset=utf-8"), file);
    }
}
