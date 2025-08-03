package defpackage;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import defpackage.InterfaceC4346;

/* compiled from: DefaultConnectivityMonitorFactory.java */
/* renamed from: ག, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5020 implements InterfaceC2673 {
    @Override // defpackage.InterfaceC2673
    @NonNull
    /* renamed from: Ϳ */
    public InterfaceC4346 mo9815(@NonNull Context context, @NonNull InterfaceC4346.InterfaceC4347 interfaceC4347) {
        boolean z = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new C3915(context, interfaceC4347) : new C2901();
    }
}
