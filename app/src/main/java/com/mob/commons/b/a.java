package com.mob.commons.b;

import android.content.Context;
import android.text.TextUtils;
import com.mob.commons.C5340r;
import com.mob.commons.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public class a {
    private static final String a = o.a("005<el+l$fgdffg");
    private static a b;
    private Context c;
    private HashMap<String, Object> d = new HashMap<>();

    private a(Context context) {
        this.c = context;
        try {
            HashMap map = (HashMap) a(a(context, a));
            if (map == null || map.size() <= 0) {
                return;
            }
            this.d.putAll(map);
        } catch (Throwable unused) {
        }
    }

    public static synchronized a a(Context context) {
        if (b == null) {
            b = new a(context);
        }
        return b;
    }

    public synchronized HashMap<String, Object> a() {
        return this.d;
    }

    public synchronized boolean a(String str, String str2, String str3, String str4, boolean z) {
        HashMap map;
        try {
            map = new HashMap();
            if (!TextUtils.isEmpty(str)) {
                map.put(o.a("004 ecdfdeNh"), str);
            }
            if (!TextUtils.isEmpty(str2)) {
                map.put(o.a("0045dfdfdeUh"), str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                map.put(o.a("004jWdfdePh"), str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                map.put(o.a("004?dc?h!deGh"), str4);
            }
            map.put(o.a("009-fgdcKee<ecdhNdih"), Boolean.valueOf(z));
        } catch (Throwable unused) {
            return false;
        }
        return a(a(this.c, a), map);
    }

    private static File a(Context context, String str) {
        try {
            File file = new File(context.getFilesDir().getAbsolutePath() + o.a("005gLgiecfc_g"));
            if (!file.exists() || !file.isDirectory()) {
                file.delete();
                file.mkdirs();
            }
            return new File(file, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Object a(File file) {
        ObjectInputStream objectInputStream;
        try {
            if (file.exists()) {
                try {
                    objectInputStream = new ObjectInputStream(new GZIPInputStream(new FileInputStream(file)));
                } catch (Throwable th) {
                    th = th;
                    objectInputStream = null;
                }
                try {
                    Object object = objectInputStream.readObject();
                    C5340r.a(objectInputStream);
                    return object;
                } catch (Throwable th2) {
                    th = th2;
                    C5340r.a(objectInputStream);
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static boolean a(File file, Object obj) {
        try {
            if (file.exists()) {
                file.delete();
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            ObjectOutputStream objectOutputStream = null;
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(file)));
                try {
                    objectOutputStream2.writeObject(obj);
                    objectOutputStream2.flush();
                    C5340r.a(objectOutputStream2);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    C5340r.a(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
