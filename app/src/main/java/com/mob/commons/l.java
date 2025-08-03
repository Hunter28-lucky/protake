package com.mob.commons;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.ResHelper;
import java.io.File;

/* loaded from: classes2.dex */
public class l {
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f17681e;
    public static final String f;
    public static final String g;
    public static final Object h;
    public static final Object i;
    private static final String j;

    static {
        String strA = i.a("011%fige'nni+gfgefiflhiDi");
        j = strA;
        a = strA + ".mrlock";
        b = strA + i.a("007 gnUjeEgfgefifl");
        c = strA + i.a("011:gnhhgfgehefhgfgmgefifl");
        d = strA + i.a("008?gnKj fkffgfgefifl");
        f17681e = strA + i.a("008SgnJj;hiffgfgefifl");
        f = strA + ".cl_lock";
        g = strA + ".gcf_lock";
        h = new Object();
        i = new Object();
    }

    public static synchronized File a(String str) {
        return ResHelper.getDataCacheFile(MobSDK.getContext(), str, true);
    }

    private static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = c;
            if (str.endsWith(str2)) {
                return str2;
            }
            String str3 = b;
            if (str.endsWith(str3)) {
                return str3;
            }
            String str4 = d;
            if (str.endsWith(str4)) {
                return str4;
            }
            String str5 = f17681e;
            if (str.endsWith(str5)) {
                return str5;
            }
            String str6 = f;
            if (str.endsWith(str6)) {
                return str6;
            }
            String str7 = g;
            if (str.endsWith(str7)) {
                return str7;
            }
        }
        return str;
    }

    public static boolean a(File file, k kVar) {
        return a(file, true, kVar);
    }

    public static boolean a(File file, boolean z, k kVar) {
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            String absolutePath = file.getAbsolutePath();
            synchronized (b(absolutePath)) {
                FileLocker fileLocker = new FileLocker();
                fileLocker.setLockFile(absolutePath);
                if (!fileLocker.lock(z)) {
                    return false;
                }
                try {
                    if (!kVar.a(fileLocker)) {
                        fileLocker.release();
                    }
                } catch (Throwable unused) {
                    fileLocker.release();
                }
                return true;
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return true;
        }
    }
}
