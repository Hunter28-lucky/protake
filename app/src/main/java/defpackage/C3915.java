package defpackage;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import defpackage.InterfaceC4346;

/* compiled from: DefaultConnectivityMonitor.java */
/* renamed from: ࡀ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3915 implements InterfaceC4346 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Context f13531;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC4346.InterfaceC4347 f13532;

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean f13533;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean f13534;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final BroadcastReceiver f13535 = new C3916();

    /* compiled from: DefaultConnectivityMonitor.java */
    /* renamed from: ࡀ$Ϳ, reason: contains not printable characters */
    public class C3916 extends BroadcastReceiver {
        public C3916() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            C3915 c3915 = C3915.this;
            boolean z = c3915.f13533;
            c3915.f13533 = c3915.m12655(context);
            if (z != C3915.this.f13533) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + C3915.this.f13533);
                }
                C3915 c39152 = C3915.this;
                c39152.f13532.mo13327(c39152.f13533);
            }
        }
    }

    public C3915(@NonNull Context context, @NonNull InterfaceC4346.InterfaceC4347 interfaceC4347) {
        this.f13531 = context.getApplicationContext();
        this.f13532 = interfaceC4347;
    }

    @Override // defpackage.InterfaceC2405
    public void onDestroy() {
    }

    @Override // defpackage.InterfaceC2405
    public void onStart() {
        m12656();
    }

    @Override // defpackage.InterfaceC2405
    public void onStop() {
        m12657();
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean m12655(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) C4513.m13867((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e2);
            }
            return true;
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m12656() {
        if (this.f13534) {
            return;
        }
        this.f13533 = m12655(this.f13531);
        try {
            this.f13531.registerReceiver(this.f13535, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f13534 = true;
        } catch (SecurityException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e2);
            }
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m12657() {
        if (this.f13534) {
            this.f13531.unregisterReceiver(this.f13535);
            this.f13534 = false;
        }
    }
}
