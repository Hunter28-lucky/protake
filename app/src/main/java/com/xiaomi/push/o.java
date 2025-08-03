package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class o {
    private static volatile o a;

    /* renamed from: a, reason: collision with other field name */
    private Context f6317a;

    /* renamed from: a, reason: collision with other field name */
    private Handler f6318a = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with other field name */
    private Map<String, Map<String, String>> f6319a = new HashMap();

    private o(Context context) {
        this.f6317a = context;
    }

    private synchronized void b(String str, String str2, String str3) {
        if (this.f6319a == null) {
            this.f6319a = new HashMap();
        }
        Map<String, String> map = this.f6319a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f6319a.put(str, map);
    }

    public static o a(Context context) {
        if (a == null) {
            synchronized (o.class) {
                if (a == null) {
                    a = new o(context);
                }
            }
        }
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m5700a(final String str, final String str2, final String str3) {
        b(str, str2, str3);
        this.f6318a.post(new Runnable() { // from class: com.xiaomi.push.o.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = o.this.f6317a.getSharedPreferences(str, 4).edit();
                editorEdit.putString(str2, str3);
                editorEdit.commit();
            }
        });
    }

    private synchronized String a(String str, String str2) {
        if (this.f6319a != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f6319a.get(str);
                    if (map == null) {
                        return "";
                    }
                    return map.get(str2);
                } catch (Throwable unused) {
                    return "";
                }
            }
        }
        return "";
    }

    public synchronized String a(String str, String str2, String str3) {
        String strA = a(str, str2);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        return this.f6317a.getSharedPreferences(str, 4).getString(str2, str3);
    }
}
