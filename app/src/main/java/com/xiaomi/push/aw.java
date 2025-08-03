package com.xiaomi.push;

import android.net.NetworkInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class aw {
    private final NetworkInfo a;

    /* renamed from: a, reason: collision with other field name */
    private final ConcurrentHashMap<String, Object> f5605a = new ConcurrentHashMap<>();

    public aw(NetworkInfo networkInfo) {
        this.a = networkInfo;
    }

    private <T> T a(String str) {
        Object objValueOf;
        if (!this.f5605a.containsKey(str)) {
            synchronized (str) {
                if (!this.f5605a.contains(str)) {
                    objValueOf = null;
                    switch (str) {
                        case "getType":
                            objValueOf = Integer.valueOf(this.a.getType());
                            break;
                        case "getTypeName":
                            objValueOf = this.a.getTypeName();
                            break;
                        case "getSubtype":
                            objValueOf = Integer.valueOf(this.a.getSubtype());
                            break;
                        case "getSubtypeName":
                            objValueOf = this.a.getSubtypeName();
                            break;
                        case "isConnected":
                            objValueOf = Boolean.valueOf(this.a.isConnected());
                            break;
                        case "getState":
                            objValueOf = this.a.getState();
                            break;
                        case "getDetailedState":
                            objValueOf = this.a.getDetailedState();
                            break;
                    }
                    if (objValueOf != null) {
                        this.f5605a.put(str, objValueOf);
                    }
                }
            }
        }
        return (T) this.f5605a.get(str);
    }

    public int b() {
        return ((Integer) a("getSubtype")).intValue();
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m5221b() {
        return (String) a("getSubtypeName");
    }

    public int a() {
        return ((Integer) a("getType")).intValue();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5219a() {
        return (String) a("getTypeName");
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5220a() {
        return ((Boolean) a("isConnected")).booleanValue();
    }

    /* renamed from: a, reason: collision with other method in class */
    public NetworkInfo.State m5218a() {
        return (NetworkInfo.State) a("getState");
    }

    /* renamed from: a, reason: collision with other method in class */
    public NetworkInfo.DetailedState m5217a() {
        return (NetworkInfo.DetailedState) a("getDetailedState");
    }
}
