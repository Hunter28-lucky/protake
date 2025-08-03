package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class d {
    private static List<a> a = new CopyOnWriteArrayList();

    public static class a {
        public final int a;

        /* renamed from: a, reason: collision with other field name */
        public final long f6445a;

        /* renamed from: a, reason: collision with other field name */
        public final String f6446a;

        /* renamed from: a, reason: collision with other field name */
        public final Notification.Action[] f6447a;

        public a(String str, long j, int i, Notification.Action[] actionArr) {
            this.f6446a = str;
            this.f6445a = j;
            this.a = i;
            this.f6447a = actionArr;
        }
    }

    public static void a(Context context, StatusBarNotification statusBarNotification, int i) {
        if (!com.xiaomi.push.j.m5690a(context) || i <= 0 || statusBarNotification == null) {
            return;
        }
        a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i, ag.m5756a(statusBarNotification.getNotification())));
    }

    private static void a(a aVar) {
        a.add(aVar);
        a();
    }

    private static void a() {
        for (int size = a.size() - 1; size >= 0; size--) {
            a aVar = a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f6445a > 5000) {
                a.remove(aVar);
            }
        }
        if (a.size() > 10) {
            a.remove(0);
        }
    }
}
