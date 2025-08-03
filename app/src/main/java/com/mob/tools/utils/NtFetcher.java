package com.mob.tools.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import com.mob.commons.j;
import com.mob.tools.MobLog;
import com.mob.tools.a.k;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DH;

/* loaded from: classes2.dex */
public class NtFetcher implements PublicMemberKeeper {
    private static NtFetcher a;
    private Context b;
    private BroadcastReceiver c;
    private String d;

    /* renamed from: e, reason: collision with root package name */
    private Integer f17724e;

    private NtFetcher(Context context) {
        this.b = context;
        if (DH.SyncMtd.isSensitiveDevice()) {
            a();
        }
    }

    @TargetApi(21)
    private ConnectivityManager.NetworkCallback b() {
        return new ConnectivityManager.NetworkCallback() { // from class: com.mob.tools.utils.NtFetcher.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                super.onAvailable(network);
                NtFetcher.this.c();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                super.onCapabilitiesChanged(network, networkCapabilities);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                super.onLinkPropertiesChanged(network, linkProperties);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLosing(Network network, int i) {
                super.onLosing(network, i);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                super.onLost(network);
                NtFetcher.this.c();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                super.onUnavailable();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.d = g();
        this.f17724e = Integer.valueOf(d());
    }

    private int d() {
        if (DH.SyncMtd.getSystemServiceSafe("phone") == null) {
            return -1;
        }
        try {
            if (DH.SyncMtd.checkPermission(j.a("035Qbdbi f:bfcabc<f'cj5cgGbf5j=bcdedebccabicjecebchdgbbeffbdjcdebbbcfcgchcgeb"))) {
                return Build.VERSION.SDK_INT >= 24 ? k.a(this.b).a().c() : k.a(this.b).a().b();
            }
            return -1;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return -1;
        }
    }

    private void e() {
        this.c = new BroadcastReceiver() { // from class: com.mob.tools.utils.NtFetcher.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE")) {
                        NtFetcher.this.c();
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            if (Build.VERSION.SDK_INT < 33) {
                ReflectHelper.invokeInstanceMethod(this.b, j.a("016*bfCg%ddbcdeNbg4bfecUgZbeMg$bc_hg)bf"), new Object[]{this.c, intentFilter}, new Class[]{BroadcastReceiver.class, IntentFilter.class});
            } else {
                ReflectHelper.invokeInstanceMethod(this.b, j.a("016;bf*g*ddbcdeMbg!bfecMg<beMg2bc6hg,bf"), new Object[]{this.c, intentFilter, 4}, new Class[]{BroadcastReceiver.class, IntentFilter.class, Integer.TYPE});
            }
        } catch (Throwable unused) {
        }
    }

    private void f() {
        if (this.c != null) {
            try {
                ReflectHelper.invokeInstanceMethod(this.b, j.a("018IbabibfFgXddbcdePbg2bfec,gVbeQgNbc0hg0bf"), new Object[]{this.c}, new Class[]{BroadcastReceiver.class});
            } catch (Throwable unused) {
            }
            this.c = null;
        }
    }

    private String g() {
        Object systemServiceSafe;
        NetworkInfo activeNetworkInfo;
        try {
            if (DH.SyncMtd.checkPermission(j.a("039Ybdbi'f=bfcabc.f9cjOcg>bf-j5bcdedebccabicjcheeeeebcfcfbbcdebcgfadjecfhbbcfcgchcgeb")) && (systemServiceSafe = DH.SyncMtd.getSystemServiceSafe("connectivity")) != null && (activeNetworkInfo = ((ConnectivityManager) systemServiceSafe).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    if (h()) {
                        return j.a("0028fcfi");
                    }
                    if (l()) {
                        return j.a("002 hgfi");
                    }
                    return j.a(m() ? "002Shafi" : "0021eifi");
                }
                if (type == 1) {
                    return j.a("004Zdbbcdfbc");
                }
                switch (type) {
                    case 6:
                        return j.a("005Hdbbc%j>bdbj");
                    case 7:
                        return j.a("009[dacbba]gb-caca=ba");
                    case 8:
                        return j.a("005fZbaCjj<bg");
                    case 9:
                        return j.a("008gbagIbfbi$gb");
                    default:
                        return String.valueOf(type);
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        return j.a("004Nbicabi+g");
    }

    public static NtFetcher getInstance(Context context) {
        if (a == null) {
            synchronized (NtFetcher.class) {
                if (a == null) {
                    a = new NtFetcher(context);
                }
            }
        }
        return a;
    }

    private boolean h() {
        if (i() || j()) {
            return true;
        }
        return k();
    }

    private boolean i() {
        try {
            Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe("phone");
            if (systemServiceSafe != null && DH.SyncMtd.checkPermission(j.a("0357bdbiWfBbfcabcNf^cj<cgNbf'j@bcdedebccabicjecebchdgbbeffbdjcdebbbcfcgchcgeb"))) {
                String manufacturer = DH.SyncMtd.getManufacturer();
                if (!TextUtils.isEmpty(manufacturer) && ((manufacturer.contains(j.a("006a;babddbNgFbc")) || manufacturer.contains(j.a("006[fbbabddbCg8bc")) || manufacturer.contains(j.a("006Vfbccchfaebce"))) && Build.VERSION.SDK_INT >= 29)) {
                    if (((Integer) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeInstanceMethod(systemServiceSafe, j.a("015EddZgbVcf5g:bf=hKbcbe,gEcf<bAbd@bg"), new Object[0]), j.a("016CddJgbGfbdbcdQgb4dbcabfbhcgbgFcg"), new Object[0])).intValue() == 20) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        return false;
    }

    private boolean j() {
        try {
            Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe("phone");
            if (systemServiceSafe != null && DH.SyncMtd.checkPermission(j.a("035Jbdbi@fWbfcabc_f1cj@cg6bf-j?bcdedebccabicjecebchdgbbeffbdjcdebbbcfcgchcgeb")) && Build.VERSION.SDK_INT >= 26) {
                return ((Integer) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeInstanceMethod(systemServiceSafe, j.a("015XddLgbYcfCg5bf.h.bcbeRg1cfBbNbdYbg"), new Object[0]), j.a("010Pdd?gb[cdbfcf>b(bd%bg"), new Object[0])).intValue() == 3;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean k() {
        try {
            return k.a(this.b).a().b() == 20;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return false;
        }
    }

    private boolean l() {
        return k.a(this.b).a().b() == 13;
    }

    private boolean m() {
        if (DH.SyncMtd.getSystemServiceSafe("phone") == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        switch (k.a(this.b).a().b()) {
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            case 4:
            case 7:
            case 11:
            default:
                return false;
        }
    }

    @Deprecated
    public synchronized int getDtNtType() {
        if (!DH.SyncMtd.isSensitiveDevice() || this.f17724e == null) {
            this.f17724e = Integer.valueOf(d());
        }
        return this.f17724e.intValue();
    }

    public synchronized String getNtType() {
        if (!DH.SyncMtd.isSensitiveDevice() || TextUtils.isEmpty(this.d)) {
            this.d = g();
        }
        return this.d;
    }

    public void recycle() {
        f();
    }

    @SuppressLint({"MissingPermission"})
    private void a() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) DH.SyncMtd.getSystemServiceSafe("connectivity");
            if (Build.VERSION.SDK_INT >= 26 && DH.SyncMtd.checkPermission(j.a("039Rbdbi@fUbfcabcKfEcjVcgPbfTj(bcdedebccabicjcheeeeebcfcfbbcdebcgfadjecfhbbcfcgchcgeb"))) {
                connectivityManager.registerDefaultNetworkCallback(b());
            } else if (DH.SyncMtd.checkPermission(j.a("039VbdbiEfPbfcabc?f+cj:cg@bf1jWbcdedebccabicjcheeeeebcfcfbbcdebcgfadjecfhbbcfcgchcgeb"))) {
                connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), b());
            } else {
                e();
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }
}
