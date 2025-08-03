package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: NetUtils.java */
/* renamed from: ܧ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3688 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m11833(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return "";
        }
        int type = activeNetworkInfo.getType();
        if (type != 0) {
            return type != 1 ? "" : "Wi-Fi";
        }
        int subtype = activeNetworkInfo.getSubtype();
        if (subtype == 20) {
            return "5G";
        }
        switch (subtype) {
        }
        return "";
    }
}
