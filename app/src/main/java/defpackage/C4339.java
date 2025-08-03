package defpackage;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.location.LocationListenerCompat;
import java.util.List;

/* compiled from: LocationListenerCompat.java */
/* renamed from: છ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final /* synthetic */ class C4339 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m13493(LocationListenerCompat locationListenerCompat, int i) {
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m13494(LocationListenerCompat locationListenerCompat, @NonNull List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            locationListenerCompat.onLocationChanged((Location) list.get(i));
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m13495(LocationListenerCompat locationListenerCompat, @NonNull String str) {
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m13496(LocationListenerCompat locationListenerCompat, @NonNull String str) {
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m13497(LocationListenerCompat locationListenerCompat, @NonNull String str, int i, @Nullable Bundle bundle) {
    }
}
