package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: ApplicationVersionSignature.java */
/* renamed from: ൔ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4747 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final ConcurrentMap<String, InterfaceC3773> f16020 = new ConcurrentHashMap();

    @Nullable
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static PackageInfo m14289(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e2);
            return null;
        }
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m14290(@Nullable PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters */
    public static InterfaceC3773 m14291(@NonNull Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, InterfaceC3773> concurrentMap = f16020;
        InterfaceC3773 interfaceC3773 = concurrentMap.get(packageName);
        if (interfaceC3773 != null) {
            return interfaceC3773;
        }
        InterfaceC3773 interfaceC3773M14292 = m14292(context);
        InterfaceC3773 interfaceC3773PutIfAbsent = concurrentMap.putIfAbsent(packageName, interfaceC3773M14292);
        return interfaceC3773PutIfAbsent == null ? interfaceC3773M14292 : interfaceC3773PutIfAbsent;
    }

    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters */
    public static InterfaceC3773 m14292(@NonNull Context context) {
        return new C2969(m14290(m14289(context)));
    }
}
