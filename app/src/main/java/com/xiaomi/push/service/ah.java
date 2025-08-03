package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ah {
    private static volatile ah a;

    /* renamed from: a, reason: collision with other field name */
    public SharedPreferences f6391a;

    /* renamed from: a, reason: collision with other field name */
    private HashSet<a> f6392a = new HashSet<>();
    public SharedPreferences b;

    public static abstract class a implements Runnable {
        private String mDescription;
        private int mId;

        public a(int i, String str) {
            this.mId = i;
            this.mDescription = str;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.mId == ((a) obj).mId;
        }

        public int hashCode() {
            return this.mId;
        }

        public abstract void onCallback();

        @Override // java.lang.Runnable
        public final void run() {
            onCallback();
        }
    }

    private ah(Context context) {
        this.f6391a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.b = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    public synchronized void a(a aVar) {
        if (!this.f6392a.contains(aVar)) {
            this.f6392a.add(aVar);
        }
    }

    public void b() {
        com.xiaomi.channel.commonutils.logger.b.c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f6392a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }

    public synchronized void a() {
        this.f6392a.clear();
    }

    public static ah a(Context context) {
        if (a == null) {
            synchronized (ah.class) {
                if (a == null) {
                    a = new ah(context);
                }
            }
        }
        return a;
    }

    public void a(List<Pair<gm, Integer>> list, List<Pair<Integer, Object>> list2) {
        if (!com.xiaomi.push.aa.a(list) && !com.xiaomi.push.aa.a(list2)) {
            SharedPreferences.Editor editorEdit = this.f6391a.edit();
            editorEdit.clear();
            for (Pair<gm, Integer> pair : list) {
                Object obj = pair.first;
                if (obj != null && pair.second != null) {
                    editorEdit.putInt(a((gm) obj), ((Integer) pair.second).intValue());
                }
            }
            for (Pair<Integer, Object> pair2 : list2) {
                Object obj2 = pair2.first;
                if (obj2 != null && pair2.second != null) {
                    a(editorEdit, pair2, a(((Integer) obj2).intValue()));
                }
            }
            editorEdit.apply();
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("not update oc, because versions or configs are empty");
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (com.xiaomi.push.aa.a(list)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.b.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null) {
                String strA = a(((Integer) obj).intValue());
                if (pair.second == null) {
                    editorEdit.remove(strA);
                } else {
                    a(editorEdit, pair, strA);
                }
            }
        }
        editorEdit.apply();
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        Object obj = pair.second;
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str.equals(a(gl.AppIsInstalledList.a()))) {
                editor.putString(str, com.xiaomi.push.az.a(str2));
                return;
            } else {
                editor.putString(str, str2);
                return;
            }
        }
        if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
        }
    }

    public int a(int i, int i2) {
        try {
            String strA = a(i);
            if (this.b.contains(strA)) {
                return this.b.getInt(strA, 0);
            }
            return this.f6391a.contains(strA) ? this.f6391a.getInt(strA, 0) : i2;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a(i + " oc int error " + e2);
            return i2;
        }
    }

    public long a(int i, long j) {
        try {
            String strA = a(i);
            if (this.b.contains(strA)) {
                return this.b.getLong(strA, 0L);
            }
            return this.f6391a.contains(strA) ? this.f6391a.getLong(strA, 0L) : j;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a(i + " oc long error " + e2);
            return j;
        }
    }

    public String a(int i, String str) {
        try {
            String strA = a(i);
            if (this.b.contains(strA)) {
                return this.b.getString(strA, null);
            }
            return this.f6391a.contains(strA) ? this.f6391a.getString(strA, null) : str;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a(i + " oc string error " + e2);
            return str;
        }
    }

    public boolean a(int i, boolean z) {
        try {
            String strA = a(i);
            if (this.b.contains(strA)) {
                return this.b.getBoolean(strA, false);
            }
            return this.f6391a.contains(strA) ? this.f6391a.getBoolean(strA, false) : z;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a(i + " oc boolean error " + e2);
            return z;
        }
    }

    public int a(gm gmVar, int i) {
        try {
            return this.f6391a.getInt(a(gmVar), i);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a(gmVar + " version error " + e2);
            return i;
        }
    }

    private String a(int i) {
        return "oc_" + i;
    }

    private String a(gm gmVar) {
        return "oc_version_" + gmVar.a();
    }
}
