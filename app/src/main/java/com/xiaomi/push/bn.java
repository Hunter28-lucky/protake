package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes2.dex */
public class bn {
    private static volatile bn a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5622a;

    private bn(Context context) {
        this.f5622a = context;
    }

    public static bn a(Context context) {
        if (a == null) {
            synchronized (bn.class) {
                if (a == null) {
                    a = new bn(context);
                }
            }
        }
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m5253a(String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = this.f5622a.getSharedPreferences(str, 4).edit();
        editorEdit.putString(str2, str3);
        editorEdit.commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m5252a(String str, String str2, long j) {
        SharedPreferences.Editor editorEdit = this.f5622a.getSharedPreferences(str, 4).edit();
        editorEdit.putLong(str2, j);
        editorEdit.commit();
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f5622a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public synchronized long a(String str, String str2, long j) {
        try {
        } catch (Throwable unused) {
            return j;
        }
        return this.f5622a.getSharedPreferences(str, 4).getLong(str2, j);
    }
}
